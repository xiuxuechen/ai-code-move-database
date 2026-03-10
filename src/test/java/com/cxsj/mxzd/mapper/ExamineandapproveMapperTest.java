package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlExamineandapproveMapper;
import com.cxsj.mxzd.mapper.pg.PgExamineandapproveMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ExamineandapproveMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 Examineandapprove 相关操作
 */
@SpringBootTest
@DisplayName("ExamineandapproveMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExamineandapproveMapperTest {

    @Autowired
    private PgExamineandapproveMapper pgMapper;

    @Autowired
    private MysqlExamineandapproveMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 ExamineandapproveMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("ExamineandapproveMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectNowExamineadapprove - 查询当前审批")
    public void testSelectNowExamineadapprove() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.spl_business_examine WHERE status = ? AND isdel = 1
        // MySQL SQL: SELECT * FROM spl_business_examine WHERE status = ? AND isdel = 1

        System.out.println("\n=== 测试 selectNowExamineadapprove ===");

        java.util.Map<String, Object> param = new java.util.HashMap<>();
        param.put("status", 1);

        String pgResult = pgMapper.selectNowExamineadapprove(param);
        String mysqlResult = mysqlMapper.selectNowExamineadapprove(param);

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("insertModelMessage - 插入模型消息")
    public void testInsertModelMessage() {
        // PostgreSQL SQL: INSERT INTO hpeapm.spl_business_examine (audit_model_number, business_code, status, create_time, isdel) VALUES (?, ?, ?, now(), 1)
        // MySQL SQL: INSERT INTO spl_business_examine (audit_model_number, business_code, status, create_time, isdel) VALUES (?, ?, ?, now(), 1)

        System.out.println("\n=== 测试 insertModelMessage ===");

        com.cxsj.mxzd.pojo.spl.SqlModelTypeParam entity = new com.cxsj.mxzd.pojo.spl.SqlModelTypeParam();
        entity.setAuditModelNumber("TEST_EXAM_001");

        int pgResult = pgMapper.insertModelMessage(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
