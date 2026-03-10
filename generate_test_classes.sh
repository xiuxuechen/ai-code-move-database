#!/bin/bash
# 批量生成 Mapper 测试类框架脚本

# Mapper 列表
mappers=(
    "AuditFindDataBase"
    "AuditElementInfo"
    "AuditElementInfoLog"
    "AuditHandoverModel"
    "AuditModelExam"
    "AuditOther"
    "DataAuditPracticeFramework"
    "DataSupportCapability"
    "DataSupportCutIn"
    "Examineandapprove"
    "ModelEvaluation"
    "OnlineModel"
    "OtherAuditModel"
    "PersonalCenter"
)

# 测试类模板
generate_test_class() {
    local mapper_name=$1
    local test_file="src/test/java/com/cxsj/mxzd/mapper/${mapper_name}MapperTest.java"

    cat > "$test_file" << EOF
package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.Mysql${mapper_name}Mapper;
import com.cxsj.mxzd.mapper.pg.Pg${mapper_name}Mapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ${mapper_name}Mapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 ${mapper_name} 相关操作
 */
@SpringBootTest
@DisplayName("${mapper_name}Mapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ${mapper_name}MapperTest {

    @Autowired
    private Pg${mapper_name}Mapper pgMapper;

    @Autowired
    private Mysql${mapper_name}Mapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\\n========================================");
        System.out.println("开始测试 ${mapper_name}Mapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\\n========================================");
        System.out.println("${mapper_name}Mapper 测试完成");
        System.out.println("========================================");
    }

    // TODO: 添加具体的测试方法
    // 参考 AuditModelMapperTest.java 的实现方式
    // 每个方法需要：
    // 1. @Test 和 @Order 注解
    // 2. @DisplayName 描述
    // 3. SQL 注释（单行 // 格式）
    // 4. 双数据源查询对比
}
EOF

    echo "✓ 生成测试类: $test_file"
}

# 生成所有测试类
for mapper in "${mappers[@]}"; do
    generate_test_class "$mapper"
done

echo ""
echo "========================================="
echo "测试类框架生成完成！"
echo "共生成 ${#mappers[@]} 个测试类"
echo "========================================="
