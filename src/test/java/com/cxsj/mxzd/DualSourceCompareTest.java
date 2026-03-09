package com.cxsj.mxzd;

import com.cxsj.mxzd.entity.AuditModel;
import com.cxsj.mxzd.mapper.mysql.AuditModelMapper as MysqlAuditModelMapper;
import com.cxsj.mxzd.mapper.pg.AuditModelMapper as PgAuditModelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 双数据源对比测试
 * 验证 PostgreSQL 和 MySQL 查询结果一致性
 */
@SpringBootTest
public class DualSourceCompareTest {

    @Autowired
    private PgAuditModelMapper pgMapper;

    @Autowired
    private MysqlAuditModelMapper mysqlMapper;

    @Test
    public void testCountConsistency() {
        int pgCount = pgMapper.count();
        int mysqlCount = mysqlMapper.count();

        System.out.println("PostgreSQL count: " + pgCount);
        System.out.println("MySQL count: " + mysqlCount);

        assertEquals(pgCount, mysqlCount, "记录总数应该一致");
    }

    @Test
    public void testSelectAllConsistency() {
        List<AuditModel> pgList = pgMapper.selectAll();
        List<AuditModel> mysqlList = mysqlMapper.selectAll();

        System.out.println("PostgreSQL records: " + pgList.size());
        System.out.println("MySQL records: " + mysqlList.size());

        assertEquals(pgList.size(), mysqlList.size(), "查询结果数量应该一致");

        // 逐条对比
        for (int i = 0; i < pgList.size(); i++) {
            AuditModel pgModel = pgList.get(i);
            AuditModel mysqlModel = mysqlList.get(i);

            assertEquals(pgModel.getId(), mysqlModel.getId(), "ID 应该一致");
            assertEquals(pgModel.getModelCode(), mysqlModel.getModelCode(), "模型代码应该一致");
            assertEquals(pgModel.getModelName(), mysqlModel.getModelName(), "模型名称应该一致");
            assertEquals(pgModel.getStatus(), mysqlModel.getStatus(), "状态应该一致");
        }
    }

    @Test
    public void testSelectByIdConsistency() {
        Long testId = 1L;

        AuditModel pgModel = pgMapper.selectById(testId);
        AuditModel mysqlModel = mysqlMapper.selectById(testId);

        assertNotNull(pgModel, "PostgreSQL 应该能查到记录");
        assertNotNull(mysqlModel, "MySQL 应该能查到记录");

        assertEquals(pgModel.getId(), mysqlModel.getId());
        assertEquals(pgModel.getModelCode(), mysqlModel.getModelCode());
        assertEquals(pgModel.getModelName(), mysqlModel.getModelName());
        assertEquals(pgModel.getStatus(), mysqlModel.getStatus());
    }

    @Test
    public void testSelectByStatusConsistency() {
        String testStatus = "active";

        List<AuditModel> pgList = pgMapper.selectByStatus(testStatus);
        List<AuditModel> mysqlList = mysqlMapper.selectByStatus(testStatus);

        System.out.println("PostgreSQL active records: " + pgList.size());
        System.out.println("MySQL active records: " + mysqlList.size());

        assertEquals(pgList.size(), mysqlList.size(), "按状态查询结果数量应该一致");
    }

}

