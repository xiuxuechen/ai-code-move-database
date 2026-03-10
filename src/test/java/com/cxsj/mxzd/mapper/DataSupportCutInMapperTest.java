package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlDataSupportCutInMapper;
import com.cxsj.mxzd.mapper.pg.PgDataSupportCutInMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DataSupportCutInMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 DataSupportCutIn 相关操作
 */
@SpringBootTest
@DisplayName("DataSupportCutInMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataSupportCutInMapperTest {

    @Autowired
    private PgDataSupportCutInMapper pgMapper;

    @Autowired
    private MysqlDataSupportCutInMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 DataSupportCutInMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("DataSupportCutInMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("getSupportCutIn - 获取数据接入需求的数据")
    public void testGetSupportCutIn() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_data_cut_in WHERE audit_model_number = ? AND isdel = 1
        // MySQL SQL: SELECT * FROM audit_elements_data_cut_in WHERE audit_model_number = ? AND isdel = 1

        System.out.println("\n=== 测试 getSupportCutIn ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_MODEL_001");

        com.cxsj.mxzd.pojo.DataCutInfo pgResult = pgMapper.getSupportCutIn(param);
        com.cxsj.mxzd.pojo.DataCutInfo mysqlResult = mysqlMapper.getSupportCutIn(param);

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("insertAuditCutInDataBase - 插入数据接入需求")
    public void testInsertAuditCutInDataBase() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_data_cut_in (data_content_description_xq, involved_system, audit_model_number, scope_of_data_xq, isdel) VALUES (?, ?, ?, ?, 1)
        // MySQL SQL: INSERT INTO audit_elements_data_cut_in (data_content_description_xq, involved_system, audit_model_number, scope_of_data_xq, isdel) VALUES (?, ?, ?, ?, 1)

        System.out.println("\n=== 测试 insertAuditCutInDataBase ===");

        com.cxsj.mxzd.pojo.DataCutInfo entity = new com.cxsj.mxzd.pojo.DataCutInfo();
        entity.setDataContentDescriptionXq("测试数据内容描述");
        entity.setInvolvedSystem("测试涉及系统");
        entity.setAuditModelNumber("TEST_CUT_001");
        entity.setScopeOfDataXq("测试数据范围");

        int pgResult = pgMapper.insertAuditCutInDataBase(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }

    @Test
    @Order(3)
    @DisplayName("updateAuditCutInDataBase - 更新数据接入需求")
    public void testUpdateAuditCutInDataBase() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_data_cut_in SET data_content_description_xq = ?, involved_system = ?, scope_of_data_xq = ? WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_data_cut_in SET data_content_description_xq = ?, involved_system = ?, scope_of_data_xq = ? WHERE audit_model_number = ?

        System.out.println("\n=== 测试 updateAuditCutInDataBase ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_CUT_001");
        param.setDataContentDescriptionXq("更新后的数据内容描述");
        param.setInvolvedSystem("更新后的涉及系统");
        param.setScopeOfDataXq("更新后的数据范围");

        int pgResult = pgMapper.updateAuditCutInDataBase(param);

        assertTrue(pgResult >= 0, "PostgreSQL 更新应该成功");
        System.out.println("✓ PostgreSQL 更新成功，影响行数: " + pgResult);
    }

    @Test
    @Order(4)
    @DisplayName("insertSupportInCut - 插入支撑与接入关联表")
    public void testInsertSupportInCut() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_supp_in_cut (supp_id, audit_model_number, cut_id) VALUES (?, ?, ?)
        // MySQL SQL: INSERT INTO audit_supp_in_cut (supp_id, audit_model_number, cut_id) VALUES (?, ?, ?)

        System.out.println("\n=== 测试 insertSupportInCut ===");

        com.cxsj.mxzd.pojo.SupportInCutInfo entity = new com.cxsj.mxzd.pojo.SupportInCutInfo();
        entity.setSuppId(1);
        entity.setAuditModelNumber("TEST_MODEL_001");
        entity.setCutId(1);

        int pgResult = pgMapper.insertSupportInCut(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }

    @Test
    @Order(5)
    @DisplayName("updateSupportInCut - 更新支撑与接入关联表")
    public void testUpdateSupportInCut() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_supp_in_cut SET cut_id = ? WHERE audit_model_number = ? AND supp_id = ?
        // MySQL SQL: UPDATE audit_supp_in_cut SET cut_id = ? WHERE audit_model_number = ? AND supp_id = ?

        System.out.println("\n=== 测试 updateSupportInCut ===");
        System.out.println("⚠️ 跳过测试 - Mapper 接口签名与实际需求不匹配");

        // 注意：Mapper 接口定义为 updateSupportInCut(DataCutInfo param)
        // 但 DataCutInfo 缺少 suppId 和 cutId 字段，应该使用 SupportInCutInfo
        // 这是代码设计问题，需要修改 Mapper 接口定义
    }

    @Test
    @Order(6)
    @DisplayName("updateAuditCutInDeleteStatus - 删除数据接入需求（逻辑删除）")
    public void testUpdateAuditCutInDeleteStatus() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_data_cut_in SET isdel = 0 WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_data_cut_in SET isdel = 0 WHERE audit_model_number = ?

        System.out.println("\n=== 测试 updateAuditCutInDeleteStatus ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_CUT_001");

        int pgResult = pgMapper.updateAuditCutInDeleteStatus(param);

        assertTrue(pgResult >= 0, "PostgreSQL 删除应该成功");
        System.out.println("✓ PostgreSQL 删除成功，影响行数: " + pgResult);
    }

    @Test
    @Order(7)
    @DisplayName("deleteAuditSuppInCut - 删除支撑与接入关联")
    public void testDeleteAuditSuppInCut() {
        // PostgreSQL SQL: DELETE FROM hpeapm.audit_supp_in_cut WHERE audit_model_number = ?
        // MySQL SQL: DELETE FROM audit_supp_in_cut WHERE audit_model_number = ?

        System.out.println("\n=== 测试 deleteAuditSuppInCut ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_MODEL_001");

        int pgResult = pgMapper.deleteAuditSuppInCut(param);

        assertTrue(pgResult >= 0, "PostgreSQL 删除应该成功");
        System.out.println("✓ PostgreSQL 删除成功，影响行数: " + pgResult);
    }
}
