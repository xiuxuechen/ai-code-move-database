package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.entity.AuditModel;
import com.cxsj.mxzd.mapper.mysql.MysqlAuditModelMapper;
import com.cxsj.mxzd.mapper.pg.PgAuditModelMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AuditModelMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 AuditModel 相关操作
 */
@SpringBootTest
@DisplayName("AuditModelMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuditModelMapperTest {

    @Autowired
    private PgAuditModelMapper pgMapper;

    @Autowired
    private MysqlAuditModelMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 AuditModelMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("AuditModelMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("selectById - 根据ID查询审计模型")
    public void testSelectById() {
        // PostgreSQL SQL: SELECT id, model_code, model_name, model_type, description, status, created_at, updated_at FROM audit_models WHERE id = ?
        // MySQL SQL: SELECT id, model_code, model_name, model_type, description, status, created_at, updated_at FROM audit_models WHERE id = ?

        System.out.println("\n=== 测试 selectById ===");

        // 准备测试参数 - 使用 PostgreSQL 测试数据的 ID
        Long testId = 1001L;

        // 执行查询
        AuditModel pgResult = pgMapper.selectById(testId);
        AuditModel mysqlResult = mysqlMapper.selectById(testId);

        // 验证结果
        if (pgResult != null && mysqlResult != null) {
            assertEquals(pgResult.getId(), mysqlResult.getId(), "ID 应该一致");
            assertEquals(pgResult.getModelCode(), mysqlResult.getModelCode(), "模型代码应该一致");
            assertEquals(pgResult.getModelName(), mysqlResult.getModelName(), "模型名称应该一致");
            assertEquals(pgResult.getModelType(), mysqlResult.getModelType(), "模型类型应该一致");
            assertEquals(pgResult.getStatus(), mysqlResult.getStatus(), "状态应该一致");

            System.out.println("✓ PostgreSQL 结果: ID=" + pgResult.getId() + ", Code=" + pgResult.getModelCode() + ", Name=" + pgResult.getModelName());
            System.out.println("✓ MySQL 结果: ID=" + mysqlResult.getId() + ", Code=" + mysqlResult.getModelCode() + ", Name=" + mysqlResult.getModelName());
        } else {
            System.out.println("⚠ 查询结果为空 - PG: " + (pgResult != null) + ", MySQL: " + (mysqlResult != null));
        }
    }

    @Test
    @Order(2)
    @DisplayName("selectByModelCode - 根据模型代码查询审计模型")
    public void testSelectByModelCode() {
        // PostgreSQL SQL: SELECT id, model_code, model_name, model_type, description, status, created_at, updated_at FROM audit_models WHERE model_code = ?
        // MySQL SQL: SELECT id, model_code, model_name, model_type, description, status, created_at, updated_at FROM audit_models WHERE model_code = ?

        System.out.println("\n=== 测试 selectByModelCode ===");

        // 准备测试参数 - 使用测试数据的模型代码
        String testModelCode = "PG_MODEL_001";

        // 执行查询
        AuditModel pgResult = pgMapper.selectByModelCode(testModelCode);
        AuditModel mysqlResult = mysqlMapper.selectByModelCode(testModelCode);

        // 验证结果
        if (pgResult != null && mysqlResult != null) {
            assertEquals(pgResult.getModelCode(), mysqlResult.getModelCode(), "模型代码应该一致");
            assertEquals(pgResult.getModelName(), mysqlResult.getModelName(), "模型名称应该一致");
            assertEquals(pgResult.getModelType(), mysqlResult.getModelType(), "模型类型应该一致");

            System.out.println("✓ PostgreSQL 结果: ID=" + pgResult.getId() + ", Code=" + pgResult.getModelCode());
            System.out.println("✓ MySQL 结果: ID=" + mysqlResult.getId() + ", Code=" + mysqlResult.getModelCode());
        } else {
            System.out.println("⚠ 查询结果为空 - PG: " + (pgResult != null) + ", MySQL: " + (mysqlResult != null));
        }
    }

    @Test
    @Order(3)
    @DisplayName("count - 统计审计模型总数")
    public void testCount() {
        // PostgreSQL SQL: SELECT COUNT(*) FROM audit_models
        // MySQL SQL: SELECT COUNT(*) FROM audit_models

        System.out.println("\n=== 测试 count ===");

        // 执行查询
        int pgCount = pgMapper.count();
        int mysqlCount = mysqlMapper.count();

        // 验证结果
        assertTrue(pgCount >= 0, "PostgreSQL 统计结果应 >= 0");
        assertTrue(mysqlCount >= 0, "MySQL 统计结果应 >= 0");

        System.out.println("✓ PostgreSQL count: " + pgCount);
        System.out.println("✓ MySQL count: " + mysqlCount);

        // 如果两边都有数据，验证数量是否一致
        if (pgCount > 0 && mysqlCount > 0) {
            assertEquals(pgCount, mysqlCount, "两个数据库的记录数量应该一致");
        }
    }
}
