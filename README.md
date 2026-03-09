# MXZD Spring Boot 双数据源测试项目

MySQL 8.0 → PostgreSQL 17 数据库迁移验证项目

## 项目说明

本项目用于验证 MySQL 和 PostgreSQL 双数据源的数据一致性，支持同时连接两个数据库并进行对比测试。

## 项目结构

```
mxzd-spring-boot-test/
├── pom.xml                                    # Maven 配置
├── init_dual_source_test.sh                   # 初始化脚本
├── SPRING_BOOT_DUAL_SOURCE_SETUP.md          # 详细配置文档
└── src/
    ├── main/
    │   ├── java/com/cxsj/mxzd/
    │   │   ├── MxzdApplication.java          # 主应用
    │   │   ├── config/
    │   │   │   ├── PostgresDataSourceConfig.java
    │   │   │   └── MysqlDataSourceConfig.java
    │   │   ├── entity/
    │   │   │   └── AuditModel.java
    │   │   └── mapper/
    │   │       ├── pg/AuditModelMapper.java
    │   │       └── mysql/AuditModelMapper.java
    │   └── resources/
    │       ├── application.yml
    │       └── mapper/
    │           ├── pg/AuditModelMapper.xml
    │           └── mysql/AuditModelMapper.xml
    └── test/
        └── java/com/cxsj/mxzd/
            └── DualSourceCompareTest.java    # 双数据源对比测试

```

## 快速开始

### 1. 初始化环境

```bash
cd /home/hinkpad/mxzd-spring-boot-test
chmod +x init_dual_source_test.sh
./init_dual_source_test.sh
```

### 2. 运行测试

```bash
mvn test
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

## 数据库配置

项目连接两个数据库：

- **PostgreSQL**: localhost:5432/mxzd_audit (主数据源)
- **MySQL**: localhost:3306/mxzd_audit (辅助数据源)

配置详见 `src/main/resources/application.yml`

## 测试说明

`DualSourceCompareTest` 包含以下测试：

1. `testCountConsistency()` - 验证记录总数一致性
2. `testSelectAllConsistency()` - 验证全表查询一致性
3. `testSelectByIdConsistency()` - 验证按 ID 查询一致性
4. `testSelectByStatusConsistency()` - 验证按状态查询一致性

## 相关文档

- [双数据源配置详细文档](SPRING_BOOT_DUAL_SOURCE_SETUP.md)
- [主项目仓库](https://github.com/xiuxuechen/ai-code-move-database.git)

## 技术栈

- Spring Boot 2.7.18
- MyBatis 2.3.2
- PostgreSQL 42.7.3
- MySQL 8.0.33
- JUnit 5
