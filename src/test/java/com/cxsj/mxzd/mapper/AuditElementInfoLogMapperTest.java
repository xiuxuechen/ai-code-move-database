package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditElementInfoLogMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditElementInfoLogMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditElementInfoLogMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditElementInfoLog 相关操作
 */
@SpringBootTest
@DisplayName("AuditElementInfoLogMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditElementInfoLogMapperTest {

    @Autowired
    private PgAuditElementInfoLogMapper pgMapper;

    @Autowired
    private MysqlAuditElementInfoLogMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditElementInfoLogMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditElementInfoLogMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("insertInfoLog - 插入审计要素信息日志")
    public void testInsertInfoLog() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_info_log (audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, find_remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process, dock_phone, dock_people, write_time, dock_department, ...) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ...)
        // MySQL SQL: INSERT INTO audit_elements_info_log (audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, find_remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process, dock_phone, dock_people, write_time, dock_department, ...) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ...)

        System.out.println("\n=== 测试 insertInfoLog ===");

        com.cxsj.mxzd.pojo.AuditElementInfoLog entity = new com.cxsj.mxzd.pojo.AuditElementInfoLog();
        entity.setAuditPointNumber("TEST_LOG_001");
        entity.setAuditPointName("测试日志审计点");
        entity.setAuditModelNumber("TEST_MODEL_LOG_001");
        entity.setAuditModelName("测试日志模型");
        entity.setAuditModelDescribe("测试日志模型描述");
        entity.setInformationSupplement("测试信息补充");
        entity.setInformationSources("测试信息来源");
        entity.setFindRemark("测试发现备注");
        entity.setAuditBusinessLogic("测试审计业务逻辑");
        entity.setPrimaryBusinessProcess("测试主要业务流程");
        entity.setExpectedRisks("测试预期风险");
        entity.setExpectedDataRequirements("测试预期数据需求");
        entity.setExpectedDataCoversUnitDemand("测试预期数据覆盖单位需求");
        entity.setRequirementsInvolveTheSystem("测试需求涉及系统");
        entity.setSubordinateToSystem("测试从属系统");
        entity.setModelCode("TEST_CODE_001");
        entity.setSecondaryBusinessProcess("测试次要业务流程");
        entity.setDockPhone("13800138000");
        entity.setDockPeople("测试对接人");
        entity.setWriteTime("2026-03-10");
        entity.setDockDepartment("测试对接部门");

        int pgResult = pgMapper.insertInfoLog(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入日志应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
