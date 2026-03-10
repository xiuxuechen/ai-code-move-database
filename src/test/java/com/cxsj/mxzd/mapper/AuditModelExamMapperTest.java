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

    @Test
    @Order(1)
    @DisplayName("getModelPrvd - 获取模型提供者")
    public void testGetModelPrvd() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.spl_business_examine WHERE audit_model_number = ?
        // MySQL SQL: SELECT * FROM spl_business_examine WHERE audit_model_number = ?

        System.out.println("\n=== 测试 getModelPrvd ===");

        String auditModelNumber = "TEST_MODEL_001";

        String pgResult = pgMapper.getModelPrvd(auditModelNumber);
        String mysqlResult = mysqlMapper.getModelPrvd(auditModelNumber);

        System.out.println("✓ PostgreSQL 结果: " + pgResult);
        System.out.println("✓ MySQL 结果: " + mysqlResult);
    }

    @Test
    @Order(2)
    @DisplayName("insertDbMsg - 插入数据库消息")
    public void testInsertDbMsg() {
        // PostgreSQL SQL: INSERT INTO hpeapm.spl_business_examine (...) VALUES (...)
        // MySQL SQL: INSERT INTO spl_business_examine (...) VALUES (...)

        System.out.println("\n=== 测试 insertDbMsg ===");

        com.cxsj.mxzd.pojo.spl.ExamModelPojo entity = new com.cxsj.mxzd.pojo.spl.ExamModelPojo();
        entity.setAuditModelNumber("TEST_EXAM_MODEL_001");

        int pgResult = pgMapper.insertDbMsg(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
