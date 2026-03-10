package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlModelEvaluationMapper;
import com.cxsj.mxzd.mapper.pg.PgModelEvaluationMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModelEvaluationMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 ModelEvaluation 相关操作
 */
@SpringBootTest
@DisplayName("ModelEvaluationMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModelEvaluationMapperTest {

    @Autowired
    private PgModelEvaluationMapper pgMapper;

    @Autowired
    private MysqlModelEvaluationMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 ModelEvaluationMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("ModelEvaluationMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectCountModel - 统计模型数量")
    public void testSelectCountModel() {
        // PostgreSQL SQL: SELECT COUNT(*) FROM hpeapm.audit_elements_model_evaluation WHERE isdel = 1
        // MySQL SQL: SELECT COUNT(*) FROM audit_elements_model_evaluation WHERE isdel = 1

        System.out.println("\n=== 测试 selectCountModel ===");

        List<com.cxsj.mxzd.pojo.ModelEvaluationPojo> pgResults = pgMapper.selectCountModel();
        List<com.cxsj.mxzd.pojo.ModelEvaluationPojo> mysqlResults = mysqlMapper.selectCountModel();

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(2)
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

    @Test
    @Order(3)
    @DisplayName("insertModelEvaluation - 插入模型评估")
    public void testInsertModelEvaluation() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_model_evaluation (audit_model_number, assessment_result, model_assessment_remarks, model_development_logic, stay_development_content, progress_the_development, expected_completion_time, conditions_still_lacking, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)
        // MySQL SQL: INSERT INTO audit_elements_model_evaluation (audit_model_number, assessment_result, model_assessment_remarks, model_development_logic, stay_development_content, progress_the_development, expected_completion_time, conditions_still_lacking, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)

        System.out.println("\n=== 测试 insertModelEvaluation ===");

        com.cxsj.mxzd.pojo.AuditElementsParam entity = new com.cxsj.mxzd.pojo.AuditElementsParam();
        entity.setAuditModelNumber("TEST_EVAL_001");

        int pgResult = pgMapper.insertModelEvaluation(entity);

        assertTrue(pgResult > 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
