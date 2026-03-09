package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.mxzd.pojo.AuditModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditModelMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface AuditModelMapper {

    /**
     * SELECT 操作: selectAll
     */
    List<AuditModel> selectAll();

    /**
     * SELECT 操作: selectById
     */
    List<AuditModel> selectById();

    /**
     * SELECT 操作: selectByModelCode
     */
    List<AuditModel> selectByModelCode();

    /**
     * SELECT 操作: selectByStatus
     */
    List<AuditModel> selectByStatus();

    /**
     * SELECT 操作: count
     */
    int count();

}
