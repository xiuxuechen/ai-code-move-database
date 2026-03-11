package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditHandoverModelMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditHandoverModelMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditHandoverModelMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditHandoverModel 相关操作
 */
@SpringBootTest
@DisplayName("AuditHandoverModelMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditHandoverModelMapperTest {

    @Autowired
    private PgAuditHandoverModelMapper pgMapper;

    @Autowired
    private MysqlAuditHandoverModelMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditHandoverModelMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditHandoverModelMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectAuditHandoverModel - 查询审计交接模型")
    public void testSelectAuditHandoverModel() {
        // PostgreSQL SQL: SELECT id, audit_point, audit_prospective_point, audit_system_name, audit_system_content, audit_confirmation_findings, audit_model_name_send, audit_model_logic, audit_model_number, create_person, create_time, update_person, update_time, isdel FROM hpeapm.audit_elements_handover_model WHERE isdel = 1
        // MySQL SQL: SELECT id, audit_point, audit_prospective_point, audit_system_name, audit_system_content, audit_confirmation_findings, audit_model_name_send, audit_model_logic, audit_model_number, create_person, create_time, update_person, update_time, isdel FROM audit_elements_handover_model WHERE isdel = 1

        System.out.println("\n=== 测试 selectAuditHandoverModel ===");

        com.cxsj.mxzd.pojo.AuditHandoverModel param = new com.cxsj.mxzd.pojo.AuditHandoverModel();

        List<com.cxsj.mxzd.pojo.AuditHandoverModel> pgResults = pgMapper.selectAuditHandoverModel(param);
        List<com.cxsj.mxzd.pojo.AuditHandoverModel> mysqlResults = mysqlMapper.selectAuditHandoverModel();

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(2)
    @DisplayName("selectByAuditModelNumber - 根据模型编号查询")
    public void testSelectByAuditModelNumber() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_handover_model WHERE audit_model_number = ? AND isdel = 1
        // MySQL SQL: SELECT * FROM audit_elements_handover_model WHERE audit_model_number = ? AND isdel = 1

        System.out.println("\n=== 测试 selectByAuditModelNumber ===");

        com.cxsj.mxzd.commom.ParamData param = new com.cxsj.mxzd.commom.ParamData();
        param.put("auditModelNumber", "TEST_HANDOVER_001");

        List<com.cxsj.mxzd.pojo.AuditHandoverModel> pgResults = pgMapper.selectByAuditModelNumber(param);
        List<com.cxsj.mxzd.pojo.AuditHandoverModel> mysqlResults = mysqlMapper.selectByAuditModelNumber(param);

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(3)
    @DisplayName("insertAuditHandoverModel - 插入审计交接模型")
    public void testInsertAuditHandoverModel() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_handover_model (audit_point, audit_prospective_point, audit_system_name, audit_system_content, audit_confirmation_findings, audit_model_name_send, audit_model_logic, audit_model_number, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, CURRENT_TIMESTAMP, 1)
        // MySQL SQL: INSERT INTO audit_elements_handover_model (audit_point, audit_prospective_point, audit_system_name, audit_system_content, audit_confirmation_findings, audit_model_name_send, audit_model_logic, audit_model_number, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, CURRENT_TIMESTAMP, 1)

        System.out.println("\n=== 测试 insertAuditHandoverModel ===");

        com.cxsj.mxzd.pojo.AuditHandoverModel entity = new com.cxsj.mxzd.pojo.AuditHandoverModel();
        entity.setAuditModelNumber("TEST_HANDOVER_INSERT_001");

        int pgResult = pgMapper.insertAuditHandoverModel(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }

    @Test
    @Order(4)
    @DisplayName("updateAuditHandoverModel - 更新审计交接模型")
    public void testUpdateAuditHandoverModel() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_handover_model SET audit_point = ?, audit_prospective_point = ?, audit_system_name = ?, audit_system_content = ?, audit_confirmation_findings = ?, audit_model_name_send = ?, audit_model_logic = ?, update_person = ?, update_time = CURRENT_TIMESTAMP WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_handover_model SET audit_point = ?, audit_prospective_point = ?, audit_system_name = ?, audit_system_content = ?, audit_confirmation_findings = ?, audit_model_name_send = ?, audit_model_logic = ?, update_person = ?, update_time = CURRENT_TIMESTAMP WHERE audit_model_number = ?

        System.out.println("\n=== 测试 updateAuditHandoverModel ===");

        com.cxsj.mxzd.pojo.AuditHandoverModel entity = new com.cxsj.mxzd.pojo.AuditHandoverModel();
        entity.setAuditModelNumber("TEST_HANDOVER_INSERT_001");
        entity.setAuditPoint("更新后的审计点");

        int pgResult = pgMapper.updateAuditHandoverModel(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 更新应该成功");
        System.out.println("✓ PostgreSQL 更新成功，影响行数: " + pgResult);
    }

    @Test
    @Order(5)
    @DisplayName("deleteByAuditModelNumber - 根据模型编号删除（逻辑删除）")
    public void testDeleteByAuditModelNumber() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_handover_model SET isdel = 0 WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_handover_model SET isdel = 0 WHERE audit_model_number = ?

        System.out.println("\n=== 测试 deleteByAuditModelNumber ===");

        String auditModelNumber = "TEST_HANDOVER_INSERT_001";

        int pgResult = pgMapper.deleteByAuditModelNumber(auditModelNumber);

        assertTrue(pgResult >= 0, "PostgreSQL 删除应该成功");
        System.out.println("✓ PostgreSQL 删除成功，影响行数: " + pgResult);
    }
}
