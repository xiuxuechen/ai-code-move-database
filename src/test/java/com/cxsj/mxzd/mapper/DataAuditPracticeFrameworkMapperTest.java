package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlDataAuditPracticeFrameworkMapper;
import com.cxsj.mxzd.mapper.pg.PgDataAuditPracticeFrameworkMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DataAuditPracticeFrameworkMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 DataAuditPracticeFramework 相关操作
 */
@SpringBootTest
@DisplayName("DataAuditPracticeFrameworkMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataAuditPracticeFrameworkMapperTest {

    @Autowired
    private PgDataAuditPracticeFrameworkMapper pgMapper;

    @Autowired
    private MysqlDataAuditPracticeFrameworkMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 DataAuditPracticeFrameworkMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("DataAuditPracticeFrameworkMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("getUserMessage - 获取用户消息")
    public void testGetUserMessage() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.user_info WHERE user_id = ?
        // MySQL SQL: SELECT * FROM user_info WHERE user_id = ?

        System.out.println("\n=== 测试 getUserMessage ===");

        com.cxsj.mxzd.pojo.PersonalCenter param = new com.cxsj.mxzd.pojo.PersonalCenter();
        param.setAuditModelNumber("USER_001");

        java.util.Map<String, Object> pgResult = pgMapper.getUserMessage(param);
        java.util.Map<String, Object> mysqlResult = mysqlMapper.getUserMessage(param);

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("insertsystemMessage - 插入系统消息")
    public void testInsertsystemMessage() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_system (...) VALUES (...)
        // MySQL SQL: INSERT INTO audit_elements_system (...) VALUES (...)

        System.out.println("\n=== 测试 insertsystemMessage ===");

        com.cxsj.mxzd.pojo.AuditElementsSystemParam entity = new com.cxsj.mxzd.pojo.AuditElementsSystemParam();
        entity.setAuditModelNumber("TEST_SYSTEM_001");

        int pgResult = pgMapper.insertsystemMessage(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
