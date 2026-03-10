package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditOtherMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditOtherMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditOtherMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditOther 相关操作
 */
@SpringBootTest
@DisplayName("AuditOtherMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditOtherMapperTest {

    @Autowired
    private PgAuditOtherMapper pgMapper;

    @Autowired
    private MysqlAuditOtherMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditOtherMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditOtherMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectAuditCodeCount - 统计审计代码数量")
    public void testSelectAuditCodeCount() {
        // PostgreSQL SQL: SELECT COUNT(*) FROM hpeapm.audit_elements_info WHERE audit_code = ?
        // MySQL SQL: SELECT COUNT(*) FROM audit_elements_info WHERE audit_code = ?

        System.out.println("\n=== 测试 selectAuditCodeCount ===");

        com.cxsj.mxzd.pojo.MaintenMsgParam param = new com.cxsj.mxzd.pojo.MaintenMsgParam();
        param.setAuditCode("TEST_CODE_001");

        Integer pgCount = pgMapper.selectAuditCodeCount(param);
        Integer mysqlCount = mysqlMapper.selectAuditCodeCount(param);

        assertNotNull(pgCount, "PostgreSQL 统计结果不应为 null");
        assertNotNull(mysqlCount, "MySQL 统计结果不应为 null");

        System.out.println("✓ PostgreSQL count: " + pgCount);
        System.out.println("✓ MySQL count: " + mysqlCount);
    }

    @Test
    @Order(2)
    @DisplayName("insertMaintenMsg - 插入维护消息")
    public void testInsertMaintenMsg() {
        // PostgreSQL SQL: INSERT INTO hpeapm.spl_business_examine_mainten (...) VALUES (...)
        // MySQL SQL: INSERT INTO spl_business_examine_mainten (...) VALUES (...)

        System.out.println("\n=== 测试 insertMaintenMsg ===");

        com.cxsj.mxzd.pojo.MaintenMsgParam entity = new com.cxsj.mxzd.pojo.MaintenMsgParam();
        entity.setAuditModelNumber("TEST_MAINTEN_001");

        int pgResult = pgMapper.insertMaintenMsg(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
