package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfoLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditElementInfoLogMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface PgAuditElementInfoLogMapper {

    /**
     * INSERT 操作: insertInfoLog
     */
    int insertInfoLog(AuditElementInfoLog param);

}
