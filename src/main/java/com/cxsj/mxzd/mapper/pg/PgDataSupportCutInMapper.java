package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementsParam;
import com.cxsj.mxzd.pojo.DataCutInfo;
import com.cxsj.mxzd.pojo.SupportInCutInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DataSupportCutInMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface PgDataSupportCutInMapper {

    /**
     * SELECT 操作: getSupportCutIn
     */
    DataCutInfo getSupportCutIn(AuditElementsParam param);

    /**
     * INSERT 操作: insertAuditCutInDataBase
     */
    int insertAuditCutInDataBase(DataCutInfo param);

    /**
     * INSERT 操作: insertSupportInCut
     */
    int insertSupportInCut(SupportInCutInfo param);

    /**
     * UPDATE 操作: updateAuditCutInDataBase
     */
    int updateAuditCutInDataBase(AuditElementsParam param);

    /**
     * UPDATE 操作: updateAuditCutInDeleteStatus
     */
    int updateAuditCutInDeleteStatus(AuditElementsParam param);

    /**
     * UPDATE 操作: updateSupportInCut
     */
    int updateSupportInCut(DataCutInfo param);

    /**
     * DELETE 操作: deleteAuditSuppInCut
     */
    int deleteAuditSuppInCut(AuditElementsParam param);

}
