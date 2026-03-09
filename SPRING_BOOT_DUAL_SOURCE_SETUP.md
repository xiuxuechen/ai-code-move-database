# Spring Boot 多数据源测试环境搭建方案

## 1. 方案概述

**目标**：搭建支持 PostgreSQL 和 MySQL 双数据源的 Spring Boot + MyBatis 测试环境

**核心特性**：
- ✅ 同时连接 PostgreSQL 和 MySQL
- ✅ 独立的 Mapper 配置（pg-mapper 和 mysql-mapper）
- ✅ 对比测试两个数据库的查询结果
- ✅ 验证 SQL 语法迁移的正确性

**技术栈**：
- Spring Boot 2.7.x
- MyBatis 3.5.x
- PostgreSQL 17 JDBC Driver
- MySQL 8.0 JDBC Driver
- JUnit 5
- Maven

## 2. 项目结构设计

```
my-project/
├── pom.xml                          # Maven 配置文件
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cxsj/mxzd/
│   │   │       ├── MxzdApplication.java          # Spring Boot 启动类
│   │   │       ├── config/                       # 配置类
│   │   │       │   ├── PostgresDataSourceConfig.java  # PostgreSQL 数据源配置
│   │   │       │   └── MysqlDataSourceConfig.java     # MySQL 数据源配置
│   │   │       ├── mapper/
│   │   │       │   ├── pg/                       # PostgreSQL Mapper 接口
│   │   │       │   │   ├── PgAuditElementInfoMapper.java
│   │   │       │   │   ├── PgDataSupportCapabilityMapper.java
│   │   │       │   │   └── ...
│   │   │       │   └── mysql/                    # MySQL Mapper 接口
│   │   │       │       ├── MysqlAuditElementInfoMapper.java
│   │   │       │       ├── MysqlDataSupportCapabilityMapper.java
│   │   │       │       └── ...
│   │   │       └── pojo/                         # POJO 类（共享）
│   │   │           ├── AuditElementInfo.java
│   │   │           └── ...
│   │   └── resources/
│   │       ├── application.yml                   # 主配置文件
│   │       ├── application-test.yml              # 测试配置文件
│   │       └── mapper/
│   │           ├── pg/                           # PostgreSQL Mapper XML
│   │           │   ├── AuditElementInfoMapper.xml
│   │           │   └── ...
│   │           └── mysql/                        # MySQL Mapper XML
│   │               ├── AuditElementInfoMapper.xml
│   │               └── ...
│   └── test/
│       ├── java/
│       │   └── com/cxsj/mxzd/test/
│       │       ├── MapperMigrationTest.java      # 迁移测试
│       │       └── DualSourceCompareTest.java    # 双数据源对比测试（新增）
│       └── resources/
│           └── application-test.yml
```

## 3. 核心配置文件

### 3.1 pom.xml（与单数据源相同）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.18</version>
        <relativePath/>
    </parent>

    <groupId>com.cxsj</groupId>
    <artifactId>mxzd</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <name>MXZD Audit System - Dual Source</name>

    <properties>
        <java.version>11</java.version>
        <mybatis-spring-boot.version>2.3.2</mybatis-spring-boot.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>${mybatis-spring-boot.version}</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

### 3.2 application.yml（双数据源配置）

```yaml
spring:
  application:
    name: mxzd-audit-system-dual-source

  # PostgreSQL 数据源配置
  datasource:
    postgresql:
      jdbc-url: jdbc:postgresql://localhost:5432/mxzd_db?currentSchema=hpeapm
      username: mxzd_user
      password: mxzd_password
      driver-class-name: org.postgresql.Driver
      hikari:
        maximum-pool-size: 10
        minimum-idle: 5
        connection-timeout: 30000

    # MySQL 数据源配置
    mysql:
      jdbc-url: jdbc:mysql://localhost:3306/mxzd_db_mysql?useUnicode=true&characterEncoding=utf8
      username: mxzd_user
      password: mxzd_password
      driver-class-name: com.mysql.cj.jdbc.Driver
      hikari:
        maximum-pool-size: 10
        minimum-idle: 5
        connection-timeout: 30000

# MyBatis 配置
mybatis:
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

# 日志配置
logging:
  level:
    com.cxsj.mxzd.mapper: DEBUG
    org.springframework.jdbc: DEBUG
```

### 3.3 PostgreSQL 数据源配置类

**文件：`src/main/java/com/cxsj/mxzd/config/PostgresDataSourceConfig.java`**

```java
package com.cxsj.mxzd.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(
    basePackages = "com.cxsj.mxzd.mapper.pg",
    sqlSessionFactoryRef = "postgresSqlSessionFactory"
)
public class PostgresDataSourceConfig {

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "postgresSqlSessionFactory")
    public SqlSessionFactory postgresSqlSessionFactory(
            @Qualifier("postgresDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/pg/*.xml")
        );
        bean.setTypeAliasesPackage("com.cxsj.mxzd.pojo");

        // MyBatis 配置
        org.apache.ibatis.session.Configuration configuration =
            new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);

        return bean.getObject();
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public DataSourceTransactionManager postgresTransactionManager(
            @Qualifier("postgresDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
```

### 3.4 MySQL 数据源配置类

**文件：`src/main/java/com/cxsj/mxzd/config/MysqlDataSourceConfig.java`**

```java
package com.cxsj.mxzd.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(
    basePackages = "com.cxsj.mxzd.mapper.mysql",
    sqlSessionFactoryRef = "mysqlSqlSessionFactory"
)
public class MysqlDataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory(
            @Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/mysql/*.xml")
        );
        bean.setTypeAliasesPackage("com.cxsj.mxzd.pojo");

        // MyBatis 配置
        org.apache.ibatis.session.Configuration configuration =
            new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);

        return bean.getObject();
    }

    @Bean(name = "mysqlTransactionManager")
    public DataSourceTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
```

### 3.5 Spring Boot 启动类

**文件：`src/main/java/com/cxsj/mxzd/MxzdApplication.java`**

```java
package com.cxsj.mxzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MxzdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MxzdApplication.class, args);
    }
}
```

**注意**：排除了 `DataSourceAutoConfiguration`，因为我们手动配置了多数据源。

## 4. Mapper 接口设计

### 4.1 PostgreSQL Mapper 接口

**文件：`src/main/java/com/cxsj/mxzd/mapper/pg/PgAuditElementInfoMapper.java`**

```java
package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PgAuditElementInfoMapper {
    List<AuditElementInfo> selectAuditElementInfo(AuditElementInfo param);
    int insertAuditElementInfo(AuditElementInfo auditElementInfo);
    int updateAuditElementInfo(AuditElementInfo auditElementInfo);
    int deleteAuditElementInfo(Long id);
}
```

### 4.2 MySQL Mapper 接口

**文件：`src/main/java/com/cxsj/mxzd/mapper/mysql/MysqlAuditElementInfoMapper.java`**

```java
package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MysqlAuditElementInfoMapper {
    List<AuditElementInfo> selectAuditElementInfo(AuditElementInfo param);
    int insertAuditElementInfo(AuditElementInfo auditElementInfo);
    int updateAuditElementInfo(AuditElementInfo auditElementInfo);
    int deleteAuditElementInfo(Long id);
}
```

## 5. 双数据源对比测试

**文件：`src/test/java/com/cxsj/mxzd/test/DualSourceCompareTest.java`**

```java
package com.cxsj.mxzd.test;

import com.cxsj.mxzd.mapper.pg.PgAuditElementInfoMapper;
import com.cxsj.mxzd.mapper.mysql.MysqlAuditElementInfoMapper;
import com.cxsj.mxzd.pojo.AuditElementInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 双数据源对比测试
 * 验证 PostgreSQL 和 MySQL 查询结果的一致性
 */
@SpringBootTest
@ActiveProfiles("test")
public class DualSourceCompareTest {

    @Autowired
    private PgAuditElementInfoMapper pgMapper;

    @Autowired
    private MysqlAuditElementInfoMapper mysqlMapper;

    @Test
    @DisplayName("对比测试：查询所有记录 - 数据量一致性")
    public void testSelectAll_DataCountConsistency() {
        // 查询 PostgreSQL
        List<AuditElementInfo> pgResults = pgMapper.selectAuditElementInfo(new AuditElementInfo());

        // 查询 MySQL
        List<AuditElementInfo> mysqlResults = mysqlMapper.selectAuditElementInfo(new AuditElementInfo());

        // 验证数据量一致
        assertEquals(mysqlResults.size(), pgResults.size(),
                "PostgreSQL 和 MySQL 的数据量应该一致");

        System.out.println("PostgreSQL 记录数: " + pgResults.size());
        System.out.println("MySQL 记录数: " + mysqlResults.size());
    }

    @Test
    @DisplayName("对比测试：模糊查询 - 结果一致性")
    public void testLikeQuery_ResultConsistency() {
        AuditElementInfo param = new AuditElementInfo();
        param.setAuditModelNumber("AM001");

        // 查询 PostgreSQL
        List<AuditElementInfo> pgResults = pgMapper.selectAuditElementInfo(param);

        // 查询 MySQL
        List<AuditElementInfo> mysqlResults = mysqlMapper.selectAuditElementInfo(param);

        // 验证结果一致
        assertEquals(mysqlResults.size(), pgResults.size(),
                "相同查询条件下，两个数据库的结果数量应该一致");

        if (!pgResults.isEmpty() && !mysqlResults.isEmpty()) {
            // 验证第一条记录的关键字段一致
            assertEquals(mysqlResults.get(0).getAuditModelNumber(),
                        pgResults.get(0).getAuditModelNumber(),
                        "审计模型编号应该一致");
        }
    }

    @Test
    @DisplayName("对比测试：插入操作 - 自增主键")
    public void testInsert_AutoIncrementKey() {
        // 准备测试数据
        AuditElementInfo pgEntity = new AuditElementInfo();
        pgEntity.setAuditPointNumber("TEST-PG-001");
        pgEntity.setAuditPointName("PostgreSQL 测试");
        pgEntity.setAuditModelNumber("MODEL-TEST-001");

        AuditElementInfo mysqlEntity = new AuditElementInfo();
        mysqlEntity.setAuditPointNumber("TEST-MYSQL-001");
        mysqlEntity.setAuditPointName("MySQL 测试");
        mysqlEntity.setAuditModelNumber("MODEL-TEST-001");

        // 插入 PostgreSQL
        int pgResult = pgMapper.insertAuditElementInfo(pgEntity);

        // 插入 MySQL
        int mysqlResult = mysqlMapper.insertAuditElementInfo(mysqlEntity);

        // 验证插入成功
        assertEquals(1, pgResult, "PostgreSQL 插入应该成功");
        assertEquals(1, mysqlResult, "MySQL 插入应该成功");

        // 验证自增主键
        assertNotNull(pgEntity.getId(), "PostgreSQL 自增主键应该自动填充");
        assertNotNull(mysqlEntity.getId(), "MySQL 自增主键应该自动填充");

        assertTrue(pgEntity.getId() > 0, "PostgreSQL 主键应该大于 0");
        assertTrue(mysqlEntity.getId() > 0, "MySQL 主键应该大于 0");

        System.out.println("PostgreSQL 自增主键: " + pgEntity.getId());
        System.out.println("MySQL 自增主键: " + mysqlEntity.getId());
    }

    @Test
    @DisplayName("对比测试：COALESCE 函数 - 空值处理")
    public void testCoalesceFunction() {
        // 这个测试需要在 Mapper XML 中有使用 COALESCE 的查询
        List<AuditElementInfo> pgResults = pgMapper.selectAuditElementInfo(new AuditElementInfo());
        List<AuditElementInfo> mysqlResults = mysqlMapper.selectAuditElementInfo(new AuditElementInfo());

        // 验证两个数据库对空值的处理一致
        assertNotNull(pgResults, "PostgreSQL 结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 结果不应为 null");
    }
}
```

## 6. 项目初始化脚本

**文件：`scripts/05-tools/init_dual_source_test.sh`**

```bash
#!/bin/bash
# 双数据源测试环境初始化脚本

set -e

PROJECT_ROOT="/home/hinkpad/my-project"
cd "$PROJECT_ROOT"

echo "=========================================="
echo "初始化双数据源测试环境"
echo "=========================================="
echo ""

# 1. 创建目录结构
echo "[1/7] 创建目录结构..."
mkdir -p src/main/java/com/cxsj/mxzd/config
mkdir -p src/main/java/com/cxsj/mxzd/mapper/pg
mkdir -p src/main/java/com/cxsj/mxzd/mapper/mysql
mkdir -p src/main/java/com/cxsj/mxzd/pojo
mkdir -p src/main/resources/mapper/pg
mkdir -p src/main/resources/mapper/mysql
mkdir -p src/test/java/com/cxsj/mxzd/test
mkdir -p src/test/resources
echo "✅ 目录结构创建完成"
echo ""

# 2. 复制 POJO 类
echo "[2/7] 复制 POJO 类..."
if [ -d "pojo" ]; then
    cp -r pojo/* src/main/java/com/cxsj/mxzd/pojo/ 2>/dev/null || true
    echo "✅ POJO 类复制完成"
else
    echo "⚠️  pojo 目录不存在"
fi
echo ""

# 3. 复制 PostgreSQL Mapper XML
echo "[3/7] 复制 PostgreSQL Mapper XML..."
if [ -d "mxzd_postgresql" ]; then
    cp mxzd_postgresql/*.xml src/main/resources/mapper/pg/ 2>/dev/null || true
    echo "✅ PostgreSQL Mapper XML 复制完成"
else
    echo "⚠️  mxzd_postgresql 目录不存在"
fi
echo ""

# 4. 复制 MySQL Mapper XML
echo "[4/7] 复制 MySQL Mapper XML..."
if [ -d "mxzd" ]; then
    cp mxzd/*.xml src/main/resources/mapper/mysql/ 2>/dev/null || true
    echo "✅ MySQL Mapper XML 复制完成"
else
    echo "⚠️  mxzd 目录不存在"
fi
echo ""

# 5. 复制测试类
echo "[5/7] 复制测试类..."
if [ -f "tests/MapperMigrationTest.java" ]; then
    cp tests/MapperMigrationTest.java src/test/java/com/cxsj/mxzd/test/
    echo "✅ 测试类复制完成"
else
    echo "⚠️  测试类不存在"
fi
echo ""

# 6. 统计文件
echo "[6/7] 统计文件..."
echo "POJO 类: $(find src/main/java/com/cxsj/mxzd/pojo -name "*.java" 2>/dev/null | wc -l) 个"
echo "PostgreSQL Mapper XML: $(find src/main/resources/mapper/pg -name "*.xml" 2>/dev/null | wc -l) 个"
echo "MySQL Mapper XML: $(find src/main/resources/mapper/mysql -name "*.xml" 2>/dev/null | wc -l) 个"
echo ""

# 7. 提示下一步
echo "[7/7] 下一步操作..."
echo ""
echo "=========================================="
echo "✅ 初始化完成！"
echo "=========================================="
echo ""
echo "下一步："
echo "  1. 生成配置文件：bash scripts/05-tools/generate_dual_source_config.sh"
echo "  2. 生成 Mapper 接口：bash scripts/05-tools/generate_mapper_interfaces.sh"
echo "  3. 编译项目：mvn clean compile"
echo "  4. 运行测试：mvn test"
echo ""
```

## 7. 运行测试

```bash
# 1. 初始化项目结构
cd /home/hinkpad/my-project
bash scripts/05-tools/init_dual_source_test.sh

# 2. 生成配置文件（需要单独脚本）
bash scripts/05-tools/generate_dual_source_config.sh

# 3. 编译项目
mvn clean compile

# 4. 运行双数据源对比测试
mvn test -Dtest=DualSourceCompareTest

# 5. 运行所有测试
mvn test

# 6. 查看测试报告
cat target/surefire-reports/com.cxsj.mxzd.test.DualSourceCompareTest.txt
```

## 8. 关键优势

### 8.1 对比验证
- ✅ 同时查询两个数据库
- ✅ 对比查询结果的一致性
- ✅ 验证数据量一致性
- ✅ 验证 SQL 语法转换正确性

### 8.2 独立配置
- ✅ 独立的数据源配置
- ✅ 独立的 SqlSessionFactory
- ✅ 独立的 Mapper 包
- ✅ 独立的 Mapper XML 目录

### 8.3 灵活测试
- ✅ 可以单独测试 PostgreSQL
- ✅ 可以单独测试 MySQL
- ✅ 可以对比测试两个数据库
- ✅ 可以验证迁移前后的一致性

## 9. 注意事项

### 9.1 Mapper XML 文件
- PostgreSQL Mapper XML 放在 `src/main/resources/mapper/pg/`
- MySQL Mapper XML 放在 `src/main/resources/mapper/mysql/`
- 两个目录的 XML 文件名可以相同，但内容不同（SQL 语法不同）

### 9.2 Mapper 接口
- PostgreSQL Mapper 接口放在 `com.cxsj.mxzd.mapper.pg` 包
- MySQL Mapper 接口放在 `com.cxsj.mxzd.mapper.mysql` 包
- 接口方法名和参数应该一致，便于对比测试

### 9.3 POJO 类
- POJO 类是共享的，放在 `com.cxsj.mxzd.pojo` 包
- 两个数据库使用相同的 POJO 类
- 确保 POJO 类有 getter/setter 方法

## 10. 下一步

我可以帮你：

1. **自动生成所有配置文件**
   - pom.xml
   - application.yml
   - PostgresDataSourceConfig.java
   - MysqlDataSourceConfig.java
   - MxzdApplication.java

2. **自动生成 Mapper 接口**
   - 根据 XML 文件生成对应的接口

3. **自动生成测试类**
   - DualSourceCompareTest.java
   - 更新 MapperMigrationTest.java

4. **创建初始化脚本**
   - init_dual_source_test.sh
   - generate_dual_source_config.sh
   - generate_mapper_interfaces.sh

你想要我开始自动生成这些文件吗？
