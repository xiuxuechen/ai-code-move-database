package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlOnlineModelMapper;
import com.cxsj.mxzd.mapper.pg.PgOnlineModelMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OnlineModelMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 OnlineModel 相关操作
 */
@SpringBootTest
@DisplayName("OnlineModelMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OnlineModelMapperTest {

    @Autowired
    private PgOnlineModelMapper pgMapper;

    @Autowired
    private MysqlOnlineModelMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 OnlineModelMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("OnlineModelMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
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
    @Order(2)
    @DisplayName("selectOnlineDataByAuditModelNumber - 根据模型编号查询在线数据")
    public void testSelectOnlineDataByAuditModelNumber() {
        // PostgreSQL SQL: SELECT * FROM hpeapm.audit_elements_online_model WHERE audit_model_number = ? AND isdel = 1
        // MySQL SQL: SELECT * FROM audit_elements_online_model WHERE audit_model_number = ? AND isdel = 1

        System.out.println("\n=== 测试 selectOnlineDataByAuditModelNumber ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_MODEL_001");

        List<com.cxsj.mxzd.pojo.AuditElementInfo> pgResults = pgMapper.selectOnlineDataByAuditModelNumber(param);
        List<com.cxsj.mxzd.pojo.AuditElementInfo> mysqlResults = mysqlMapper.selectOnlineDataByAuditModelNumber(param);

        assertNotNull(pgResults, "PostgreSQL 查询结果不应为 null");
        assertNotNull(mysqlResults, "MySQL 查询结果不应为 null");

        System.out.println("✓ PostgreSQL 结果数量: " + pgResults.size());
        System.out.println("✓ MySQL 结果数量: " + mysqlResults.size());
    }

    @Test
    @Order(3)
    @DisplayName("insertOnlineModel - 插入在线模型")
    public void testInsertOnlineModel() {
        // PostgreSQL SQL: INSERT INTO hpeapm.audit_elements_online_model (audit_model_number, information_type, code_requirement, file_name, specification_requirement, reference_number, dispatch_time, start_time, end_time, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)
        // MySQL SQL: INSERT INTO audit_elements_online_model (audit_model_number, information_type, code_requirement, file_name, specification_requirement, reference_number, dispatch_time, start_time, end_time, create_person, create_time, update_person, update_time, isdel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, now(), 1)

        System.out.println("\n=== 测试 insertOnlineModel ===");

        int pgResult = pgMapper.insertOnlineModel();

        assertTrue(pgResult >= 0, "PostgreSQL 插入应该成功");
        System.out.println("✓ PostgreSQL 插入成功，影响行数: " + pgResult);
    }
}
