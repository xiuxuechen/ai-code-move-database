#!/bin/bash

# 双数据源 Spring Boot 测试环境初始化脚本
# 用途：创建项目目录结构并验证配置

set -e

PROJECT_ROOT="/home/hinkpad/my-project"
cd "$PROJECT_ROOT"

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "双数据源 Spring Boot 测试环境初始化"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# 1. 验证数据库连接
echo ""
echo "[1/5] 验证数据库连接..."

# 验证 PostgreSQL
if psql -U mxzd_user -d mxzd_audit -c "SELECT COUNT(*) FROM audit_models;" > /dev/null 2>&1; then
    PG_COUNT=$(psql -U mxzd_user -d mxzd_audit -t -c "SELECT COUNT(*) FROM audit_models;")
    echo "✅ PostgreSQL 连接成功，记录数: $PG_COUNT"
else
    echo "❌ PostgreSQL 连接失败"
    exit 1
fi

# 验证 MySQL
if mysql -u mxzd_user -pmxzd_pass mxzd_audit -e "SELECT COUNT(*) FROM audit_models;" > /dev/null 2>&1; then
    MYSQL_COUNT=$(mysql -u mxzd_user -pmxzd_pass mxzd_audit -N -e "SELECT COUNT(*) FROM audit_models;")
    echo "✅ MySQL 连接成功，记录数: $MYSQL_COUNT"
else
    echo "❌ MySQL 连接失败"
    exit 1
fi

# 2. 验证项目结构
echo ""
echo "[2/5] 验证项目结构..."

REQUIRED_FILES=(
    "pom.xml"
    "src/main/resources/application.yml"
    "src/main/java/com/cxsj/mxzd/MxzdApplication.java"
    "src/main/java/com/cxsj/mxzd/config/PostgresDataSourceConfig.java"
    "src/main/java/com/cxsj/mxzd/config/MysqlDataSourceConfig.java"
    "src/main/java/com/cxsj/mxzd/entity/AuditModel.java"
    "    "src/main/java/com/cxsj/mxzd/mapper/pg/AuditModelMapper.java"
    "src/main/java/com/cxsj/mxzd/mapper/mysql/AuditModelMapper.java"
    "src/main/resources/mapper/pg/AuditModelMapper.xml"
    "src/main/resources/mapper/mysql/AuditModelMapper.xml"
    "src/test/java/com/cxsj/mxzd/DualSourceCompareTest.java"
)

MISSING_FILES=()
for file in "${REQUIRED_FILES[@]}"; do
    if [ ! -f "$file" ]; then
        MISSING_FILES+=("$file")
    fi
done

if [ ${#MISSING_FILES[@]} -eq 0 ]; then
    echo "✅ 所有必需文件已创建 (${#REQUIRED_FILES[@]}/${#REQUIRED_FILES[@]})"
else
    echo "❌ 缺少以下文件:"
    for file in "${MISSING_FILES[@]}"; do
        echo "   - $file"
    done
    exit 1
fi

# 3. 验证 Maven 依赖
echo ""
echo "[3/5] 验证 Maven 配置..."

if [ -f "pom.xml" ]; then
    if grep -q "postgresql" pom.xml && grep -q "mysql-connector-j" pom.xml; then
        echo "✅ Maven 依赖配置正确"
    else
        echo "❌ Maven 依赖配置不完整"
        exit 1
    fi
else
    echo "❌ pom.xml 不存在"
    exit 1
fi

# 4. 编译项目
echo ""
echo "[4/5] 编译项目..."

if command -v mvn > /dev/null 2>&1; then
    mvn clean compile -DskipTests
    echo "✅ 项目编译成功"
else
    echo "⚠️  Maven 未安装，跳过编译"
fi

# 5. 生成测试报告
echo ""
echo "[5/5] 生成配置摘要..."

cat << EOF

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📋 双数据源配置摘要
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

数据库状态:
  PostgreSQL: ✅ 连接成功 ($PG_COUNT 条记录)
  MySQL:      ✅ 连接成功 ($MYSQL_COUNT 条记录)

项目结构:
  配置文件:   ✅ pom.xml, application.yml
  数据源配置: ✅ PostgresDataSourceConfig, MysqlDataSourceConfig
  实体类:     ✅ AuditModel
  Mapper:     ✅ pg/AuditModelMapper, mysql/AuditModelMapper
  测试类:     ✅ DualSourceCompareTest

下一步操作:
  1. 运行测试: mvn test
  2. 查看文档: docs/SPRING_BOOT_DUAL_SOURCE_SETUP.md
  3. 启动应用: mvn spring-boot:run

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
EOF

echo ""
echo "✅ 初始化完成！"
"
