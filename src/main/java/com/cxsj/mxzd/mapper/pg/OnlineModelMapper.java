package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementCaseEntity;
import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditElementsParam;
import com.cxsj.mxzd.pojo.Map;
import com.cxsj.mxzd.pojo.OnlineModelPojo;
import com.cxsj.mxzd.pojo.OnlineModelVo;
import com.cxsj.mxzd.pojo.ParamData;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * OnlineModelMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface OnlineModelMapper {

    /**
     * SELECT 操作: selectWriteTime
     */
    String selectWriteTime(String param);

    /**
     * SELECT 操作: selectOnlineDataByAuditModelNumber
     */
    List<AuditElementInfo> selectOnlineDataByAuditModelNumber(AuditElementsParam param);

    /**
     * SELECT 操作: getOnlineModelDataByAuditId
     */
    OnlineModelPojo getOnlineModelDataByAuditId();

    /**
     * SELECT 操作: selectOnlineModelList
     */
    AuditElementInfo selectOnlineModelList(ParamData param);

    /**
     * SELECT 操作: selectOnlineModelListCount
     */
    Integer selectOnlineModelListCount(Map param);

    /**
     * SELECT 操作: selectOnlineModelData
     */
    OnlineModelVo selectOnlineModelData(AuditElementsParam param);

    /**
     * SELECT 操作: selectCaseMsgByAuditModelNumber
     */
    List<AuditElementCaseEntity> selectCaseMsgByAuditModelNumber(Map param);

    /**
     * INSERT 操作: insertOnlineModel
     */
    int insertOnlineModel();

    /**
     * INSERT 操作: insertOnlineModelCase
     */
    int insertOnlineModelCase(Map param);

    /**
     * UPDATE 操作: updateOnlineModel
     */
    int updateOnlineModel();

    /**
     * UPDATE 操作: deleteOnlineModel
     */
    int deleteOnlineModel();

    /**
     * UPDATE 操作: updateOnlineModelCaseDateType
     */
    int updateOnlineModelCaseDateType(Map param);

}
