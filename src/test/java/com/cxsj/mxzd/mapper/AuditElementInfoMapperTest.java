package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditElementInfoMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditElementInfoMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditElementInfoMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditElementInfo 相关操作
 */
@SpringBootTest
@DisplayName("AuditElementInfoMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditElementInfoMapperTest {

    @Autowired
    private PgAuditElementInfoMapper pgMapper;

    @Autowired
    private MysqlAuditElementInfoMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditElementInfoMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditElementInfoMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectAuditElementInfo - 查询审计要素信息列表")
    public void testSelectAuditElementInfo() {
        // PostgreSQL SQL: SELECT id, audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process FROM hpeapm.audit_elements_info WHERE isdel = 1
        // MySQL SQL: SELECT id, audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process FROM audit_elements_info WHERE isdel = 1

        System.out.println("\n=== 测试 selectAuditElementInfo ===");

        com.cxsj.mxzd.pojo.AuditElementInfo param = new com.cxsj.mxzd.pojo.AuditElementInfo();
        param.setAuditModelNumber("TEST_MODEL_001");

        List<com.cxsj.mxzd.pojo.AuditElementInfo> pgResults = pgMapper.selectAuditElementInfo(param);
        List<com.cxsj.mxzd.pojo.AuditElementInfo> mysqlResults = mysqlMapper.selectAuditElementInfo(param);

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(2)
    @DisplayName("selectByAuditModelNumber - 根据模型编号查询")
    public void testSelectByAuditModelNumber() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_info WHERE audit_model_number = ?
        // MySQL SQL: SELECT * FROM audit_elements_info WHERE audit_model_number = ?

        System.out.println("\n=== 测试 selectByAuditModelNumber ===");

        String auditModelNumber = "TEST_MODEL_001";

        List<com.cxsj.mxzd.pojo.AuditElementInfo> pgResults = pgMapper.selectByAuditModelNumber(auditModelNumber);
        List<com.cxsj.mxzd.pojo.AuditElementInfo> mysqlResults = mysqlMapper.selectByAuditModelNumber(auditModelNumber);

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(3)
    @DisplayName("insertAuditElementInfo - 插入审计要素信息")
    public void testInsertAuditElementInfo() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_info (audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process, create_time, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now(), 1)
        // MySQL SQL: INSERT INTO audit_elements_info (audit_point_number, audit_point_name, audit_model_number, audit_model_name, audit_model_describe, information_supplement, information_sources, remark, audit_business_logic, primary_business_process, expected_risks, expected_data_requirements, expected_data_covers_unit_demand, requirements_involve_the_system, subordinate_to_system, model_code, secondary_business_process, create_time, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now(), 1)

        System.out.println("\n=== 测试 insertAuditElementInfo ===");

        com.cxsj.mxzd.pojo.AuditElementInfo entity = new com.cxsj.mxzd.pojo.AuditElementInfo();
        entity.setAuditPointNumber("TEST_POINT_001");
        entity.setAuditPointName("测试审计点");
        entity.setAuditModelNumber("TEST_INSERT_MODEL_001");
        entity.setAuditModelName("测试模型");
        entity.setAuditModelDescribe("测试模型描述");

        int pgResult = pgMapper.insertAuditElementInfo(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }

    @Test
    @Order(4)
    @DisplayName("selectWriteTime - 查询写入时间")
    public void testSelectWriteTime() {
        // PostgreSQL SQL: SELECT write_time FROM hpeapm.audit_elements_info WHERE audit_model_number = ?
        // MySQL SQL: SELECT write_time FROM audit_elements_info WHERE audit_model_number = ?

        System.out.println("\n=== 测试 selectWriteTime ===");

        String auditModelNumber = "TEST_MODEL_001";

        String pgResult = pgMapper.selectWriteTime(auditModelNumber);
        String mysqlResult = mysqlMapper.selectWriteTime(auditModelNumber);

        System.out.println("✓ PostgreSQL 结果: " + pgResult);
        System.out.println("✓ MySQL 结果: " + mysqlResult);
    }
}
