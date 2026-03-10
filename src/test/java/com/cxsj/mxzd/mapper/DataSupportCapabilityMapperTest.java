package com.cxsj.mxzd.mapper;

import com.cxsj.mxzd.mapper.mysql.MysqlDataSupportCapabilityMapper;
import com.cxsj.mxzd.mapper.pg.PgDataSupportCapabilityMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DataSupportCapabilityMapper 测试类
 * 测试 PostgreSQL 和 MySQL 双数据源的 DataSupportCapability 相关操作
 */
@SpringBootTest
@DisplayName("DataSupportCapabilityMapper 测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataSupportCapabilityMapperTest {

    @Autowired
    private PgDataSupportCapabilityMapper pgMapper;

    @Autowired
    private MysqlDataSupportCapabilityMapper mysqlMapper;

    @BeforeAll
    static void setup() {
        System.out.println("\n========================================");
        System.out.println("开始测试 DataSupportCapabilityMapper");
        System.out.println("========================================");
    }

    @AfterAll
    static void teardown() {
        System.out.println("\n========================================");
        System.out.println("DataSupportCapabilityMapper 测试完成");
        System.out.println("========================================");
    }

    @Test
    @Order(1)
    @DisplayName("getOrderModelMsgByModelNumber - 获取模型订单信息（复杂JOIN查询）")
    public void testGetOrderModelMsgByModelNumber() {
        // PostgreSQL SQL: SELECT t1.business1Name, t2.business2Name, t3.auditPointName, t4.modelName, t4.modelNumber FROM hpeapm.business_1 t1 JOIN hpeapm.business_2 t2 ON t1.id = t2.business1_id JOIN hpeapm.audit_point t3 ON t2.id = t3.business2_id JOIN hpeapm.audit_model t4 ON t3.id = t4.audit_point_id WHERE t4.model_number = ?
        // MySQL SQL: SELECT t1.business1Name, t2.business2Name, t3.auditPointName, t4.modelName, t4.modelNumber FROM business_1 t1 JOIN business_2 t2 ON t1.id = t2.business1_id JOIN audit_point t3 ON t2.id = t3.business2_id JOIN audit_model t4 ON t3.id = t4.audit_point_id WHERE t4.model_number = ?

        System.out.println("\n=== 测试 getOrderModelMsgByModelNumber ===");

        String modelNumber = "TEST_MODEL_001";

        com.cxsj.common.dto.ModelOrderParam pgResult = pgMapper.getOrderModelMsgByModelNumber(modelNumber);
        com.cxsj.common.dto.ModelOrderParam mysqlResult = mysqlMapper.getOrderModelMsgByModelNumber(modelNumber);

        System.out.println("✓ PostgreSQL 结果: " + (pgResult != null ? "有数据" : "无数据"));
        System.out.println("✓ MySQL 结果: " + (mysqlResult != null ? "有数据" : "无数据"));
    }

    @Test
    @Order(2)
    @DisplayName("selectSupportListCount - 统计支撑列表数量")
    public void testSelectSupportListCount() {
        // PostgreSQL SQL: SELECT COUNT(*) FROM hpeapm.audit_elements_data_support_v2 WHERE audit_model_number = ? AND isdel = 1
        // MySQL SQL: SELECT COUNT(*) FROM audit_elements_data_support_v2 WHERE audit_model_number = ? AND isdel = 1

        System.out.println("\n=== 测试 selectSupportListCount ===");

        com.cxsj.mxzd.pojo.AuditElementsParam param = new com.cxsj.mxzd.pojo.AuditElementsParam();
        param.setAuditModelNumber("TEST_MODEL_001");

        Integer pgCount = pgMapper.selectSupportListCount(param);
        Integer mysqlCount = mysqlMapper.selectSupportListCount(param);

        assertNotNull(pgCount, "PostgreSQL 统计结果不应为 null");
        assertNotNull(mysqlCount, "MySQL 统计结果不应为 null");

        System.out.println("✓ PostgreSQL count: " + pgCount);
        System.out.println("✓ MySQL count: " + mysqlCount);
    }
}
