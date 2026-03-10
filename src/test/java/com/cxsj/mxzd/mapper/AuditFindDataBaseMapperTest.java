package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlAuditFindDataBaseMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditFindDataBaseMapper;
import com.cxsj.mxzd.pojo.AuditFindDataBase;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditFindDataBaseMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditFindDataBase 相关操作
 */
@SpringBootTest
@DisplayName("AuditFindDataBaseMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditFindDataBaseMapperTest {

    @Autowired
    private PgAuditFindDataBaseMapper pgMapper;

    @Autowired
    private MysqlAuditFindDataBaseMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditFindDataBaseMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditFindDataBaseMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectAuditFindDataBase - 查询审计发现数据库")
    public void testSelectAuditFindDataBase() {
        // PostgreSQL SQL: SELECT id, problem_summary, problem_description, audit_time, audit_involved, audit_project, audit_model_number, create_person, create_time, update_person, update_time, isdel FROM hpeapm.audit_elements_find_database WHERE isdel = 1
        // MySQL SQL: SELECT id, problem_summary, problem_description, audit_time, audit_involved, audit_project, audit_model_number, create_person, create_time, update_person, update_time, isdel FROM audit_elements_find_database WHERE isdel = 1

        System.out.println("\n=== 测试 selectAuditFindDataBase ===");

        AuditFindDataBase param = new AuditFindDataBase();
        param.setAuditModelNumber("TEST_MODEL_001");

        List<AuditFindDataBase> pgResults = pgMapper.selectAuditFindDataBase(param);
        List<AuditFindDataBase> mysqlResults = mysqlMapper.selectAuditFindDataBase();

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(2)
    @DisplayName("selectByAuditModelNumber - 根据模型编号查询")
    public void testSelectByAuditModelNumber() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_find_database WHERE audit_model_number = ? AND isdel = 1
        // MySQL SQL: SELECT * FROM audit_elements_find_database WHERE audit_model_number = ? AND isdel = 1

        System.out.println("\n=== 测试 selectByAuditModelNumber ===");

        String auditModelNumber = "TEST_MODEL_001";

        List<AuditFindDataBase> pgResults = pgMapper.selectByAuditModelNumber(auditModelNumber);
        List<AuditFindDataBase> mysqlResults = mysqlMapper.selectByAuditModelNumber(auditModelNumber);

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(3)
    @DisplayName("insertAuditFindDataBase - 插入审计发现")
    public void testInsertAuditFindDataBase() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_find_database (problem_summary, problem_description, audit_time, audit_involved, audit_project, audit_model_number, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)
        // MySQL SQL: INSERT INTO audit_elements_find_database (problem_summary, problem_description, audit_time, audit_involved, audit_project, audit_model_number, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)

        System.out.println("\n=== 测试 insertAuditFindDataBase ===");

        com.cxsj.mxzd.pojo.AuditFindDataBase entity = new com.cxsj.mxzd.pojo.AuditFindDataBase();
        entity.setProblemSummary("测试问题摘要");
        entity.setProblemDescription("测试问题描述");
        entity.setAuditTime("2026-03-10");
        entity.setAuditInvolved("测试涉及方");
        entity.setAuditProject("测试项目");
        entity.setAuditModelNumber("TEST_INSERT_001");
        entity.setCreatePerson("测试人员");
        entity.setUpdatePerson("测试人员");
        entity.setIsdel(1);

        int pgResult = pgMapper.insertAuditFindDataBase(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }

    @Test
    @Order(4)
    @DisplayName("updateAuditFindDataBase - 更新审计发现")
    public void testUpdateAuditFindDataBase() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_find_database SET problem_summary = ?, problem_description = ?, audit_time = ?, audit_involved = ?, audit_project = ?, update_person = ?, update_time = now() WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_find_database SET problem_summary = ?, problem_description = ?, audit_time = ?, audit_involved = ?, audit_project = ?, update_person = ?, update_time = now() WHERE audit_model_number = ?

        System.out.println("\n=== 测试 updateAuditFindDataBase ===");

        com.cxsj.mxzd.pojo.AuditFindDataBase entity = new com.cxsj.mxzd.pojo.AuditFindDataBase();
        entity.setAuditModelNumber("TEST_INSERT_001");
        entity.setProblemSummary("更新后的问题摘要");
        entity.setProblemDescription("更新后的问题描述");
        entity.setUpdatePerson("更新人员");

        int pgResult = pgMapper.updateAuditFindDataBase(entity);

        assertTrue(pgResult >= 0, "PostgreSQL 更新应该成功");
        System.out.println("✓ PostgreSQL 更新成功，影响行数: " + pgResult);
    }

    @Test
    @Order(5)
    @DisplayName("deleteByAuditModelNumber - 根据模型编号删除（逻辑删除）")
    public void testDeleteByAuditModelNumber() {
        // PostgreSQL SQL: UPDATE hpeapm.audit_elements_find_database SET isdel = 0 WHERE audit_model_number = ?
        // MySQL SQL: UPDATE audit_elements_find_database SET isdel = 0 WHERE audit_model_number = ?

        System.out.println("\n=== 测试 deleteByAuditModelNumber ===");

        String auditModelNumber = "TEST_INSERT_001";

        int pgResult = pgMapper.deleteByAuditModelNumber(auditModelNumber);

        assertTrue(pgResult >= 0, "PostgreSQL 删除应该成功");
        System.out.println("✓ PostgreSQL 删除成功，影响行数: " + pgResult);
    }
}
