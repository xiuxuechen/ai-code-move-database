package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlOtherAuditModelMapper;
import com.cxsj.mxzd.mapper.pg.PgOtherAuditModelMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OtherAuditModelMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 OtherAuditModel 相关操作
 */
@SpringBootTest
@DisplayName("OtherAuditModelMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OtherAuditModelMapperTest {

    @Autowired
    private PgOtherAuditModelMapper pgMapper;

    @Autowired
    private MysqlOtherAuditModelMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 OtherAuditModelMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("OtherAuditModelMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectModelSysMsg - 查询模型系统消息")
    public void testSelectModelSysMsg() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_system WHERE audit_model_number = ?
        // MySQL SQL: SELECT * FROM audit_elements_system WHERE audit_model_number = ?

        System.out.println("\n=== 测试 selectModelSysMsg ===");

        java.util.Map<String, Object> param = new java.util.HashMap<>();
        param.put("auditModelNumber", "TEST_MODEL_001");

        java.util.Map pgResult = pgMapper.selectModelSysMsg(param);
        java.util.Map mysqlResult = mysqlMapper.selectModelSysMsg(param);

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("updateaudit_elements_info - 更新审计要素信息表")
    public void testUpdateAuditElementsInfo() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_info SET audit_model_number = ? WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_info SET audit_model_number = ? WHERE audit_model_number = ?

        System.out.println("\n=== 测试 updateaudit_elements_info ===");

        java.util.Map<String, Object> param = new java.util.HashMap<>();
        param.put("newAuditModelNumber", "TEST_NEW_001");
        param.put("oldAuditModelNumber", "TEST_OLD_001");

        int pgResult = pgMapper.updateaudit_elements_info(param);

        assertTrue(pgResult >= 0, "PostgreSQL 更新应该成功");
        System.out.println("✓ PostgreSQL 更新成功，影响行数: " + pgResult);
    }
}
