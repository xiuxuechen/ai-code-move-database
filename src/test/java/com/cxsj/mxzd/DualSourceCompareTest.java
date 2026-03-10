package com.cxsj.mxzd;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditFindDataBase;
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
    private com.cxsj.mxzd.mapper.pg.PgAuditElementInfoMapper pgAuditElementInfoMapper;

    @Autowired
    private com.cxsj.mxzd.mapper.mysql.MysqlAuditElementInfoMapper mysqlAuditElementInfoMapper;

    @Autowired
    private com.cxsj.mxzd.mapper.pg.PgAuditFindDataBaseMapper pgAuditFindDataBaseMapper;

    @Autowired
    private com.cxsj.mxzd.mapper.mysql.MysqlAuditFindDataBaseMapper mysqlAuditFindDataBaseMapper;

    @Test
    public void testAuditElementInfoCount() {
        System.out.println("=== 测试 AuditElementInfo 记录数量 ===");

        List<AuditElementInfo> pgList = pgAuditElementInfoMapper.selectAuditElementInfo(new AuditElementInfo());
        List<AuditElementInfo> mysqlList = mysqlAuditElementInfoMapper.selectAuditElementInfo(new AuditElementInfo());

        System.out.println("PostgreSQL 记录数: " + pgList.size());
        System.out.println("MySQL 记录数: " + mysqlList.size());

        assertEquals(pgList.size(), mysqlList.size(), "AuditElementInfo 记录数量应该一致");
    }

    @Test
    public void testAuditFindDataBaseCount() {
        System.out.println("=== 测试 AuditFindDataBase 记录数量 ===");

        List<AuditFindDataBase> pgList = pgAuditFindDataBaseMapper.selectAuditFindDataBase(new AuditFindDataBase());
        List<AuditFindDataBase> mysqlList = mysqlAuditFindDataBaseMapper.selectAuditFindDataBase();

        System.out.println("PostgreSQL 记录数: " + pgList.size());
        System.out.println("MySQL 记录数: " + mysqlList.size());

        assertEquals(pgList.size(), mysqlList.size(), "AuditFindDataBase 记录数量应该一致");
    }

    @Test
    public void testAuditElementInfoDataConsistency() {
        System.out.println("=== 测试 AuditElementInfo 数据一致性 ===");

        List<AuditElementInfo> pgList = pgAuditElementInfoMapper.selectAuditElementInfo(new AuditElementInfo());
        List<AuditElementInfo> mysqlList = mysqlAuditElementInfoMapper.selectAuditElementInfo(new AuditElementInfo());

        if (pgList.isEmpty() || mysqlList.isEmpty()) {
            System.out.println("⚠️  数据为空，跳过一致性检查");
            return;
        }

        // 对比第一条记录
        AuditElementInfo pgFirst = pgList.get(0);
        AuditElementInfo mysqlFirst = mysqlList.get(0);

        System.out.println("PostgreSQL 第一条: ID=" + pgFirst.getId() + ", Name=" + pgFirst.getAuditPointName());
        System.out.println("MySQL 第一条: ID=" + mysqlFirst.getId() + ", Name=" + mysqlFirst.getAuditPointName());

        assertEquals(pgFirst.getId(), mysqlFirst.getId(), "ID 应该一致");
        assertEquals(pgFirst.getAuditPointName(), mysqlFirst.getAuditPointName(), "审计点名称应该一致");
    }

}
