package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditModelExamMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditModelExamMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditModelExamMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditModelExam 相关操作
 */
@SpringBootTest
@DisplayName("AuditModelExamMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditModelExamMapperTest {

    @Autowired
    private PgAuditModelExamMapper pgMapper;

    @Autowired
    private MysqlAuditModelExamMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditModelExamMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditModelExamMapper 测试完成");
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
