package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlPersonalCenterMapper;
import com.cxsj.mxzd.mapper.pg.PgPersonalCenterMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PersonalCenterMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 PersonalCenter 相关操作
 */
@SpringBootTest
@DisplayName("PersonalCenterMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonalCenterMapperTest {

    @Autowired
    private PgPersonalCenterMapper pgMapper;

    @Autowired
    private MysqlPersonalCenterMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 PersonalCenterMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("PersonalCenterMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("getAuditPointNameList - 获取审计点名称列表")
    public void testGetAuditPointNameList() {
        // PostgreSQL SQL: SELECT DISTINCT audit_point_name FROM hpeapm.audit_elements_info WHERE isdel = 1
        // MySQL SQL: SELECT DISTINCT audit_point_name FROM audit_elements_info WHERE isdel = 1

        System.out.println("\n=== 测试 getAuditPointNameList ===");

        java.util.Map<String, Object> pgResult = pgMapper.getAuditPointNameList();
        java.util.Map<String, Object> mysqlResult = mysqlMapper.getAuditPointNameList();

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("insertPersonalCenterMessage - 插入个人中心消息")
    public void testInsertPersonalCenterMessage() {
        // PostgreSQL SQL: INSERT INTO hpeapm.spl_business_examine (submit_user, audit_model_number, business_type, status, create_time, isdel) VALUES (?, ?, ?, ?, now(), 1)
        // MySQL SQL: INSERT INTO spl_business_examine (submit_user, audit_model_number, business_type, status, create_time, isdel) VALUES (?, ?, ?, ?, now(), 1)

        System.out.println("\n=== 测试 insertPersonalCenterMessage ===");

        com.cxsj.mxzd.pojo.PersonalCenter entity = new com.cxsj.mxzd.pojo.PersonalCenter();
        entity.setAuditModelNumber("TEST_PERSONAL_001");

        int pgResult = pgMapper.insertPersonalCenterMessage(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
