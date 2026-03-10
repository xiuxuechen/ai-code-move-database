package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.mxzd.entity.AuditModel;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditModelMapper Mapper 接口
 */
@Mapper
public interface MysqlAuditModelMapper {

    /**
     * 查询所有审计模型
     */
    List<AuditModel> selectAll();

    /**
     * 根据 ID 查询
     */
    AuditModel selectById(@Param("id") Long id);

    /**
     * 根据模型代码查询
     */
    AuditModel selectByModelCode(@Param("modelCode") String modelCode);

    /**
     * 根据状态查询
     */
    List<AuditModel> selectByStatus(@Param("status") String status);

    /**
     * 统计总数
     */
    int count();

}
