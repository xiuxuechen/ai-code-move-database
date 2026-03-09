package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditElementsParam;
import com.cxsj.mxzd.pojo.Map;
import com.cxsj.mxzd.pojo.ModelEvaluationExportVo;
import com.cxsj.mxzd.pojo.ModelEvaluationPojo;
import com.cxsj.mxzd.pojo.ParamData;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ModelEvaluationMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface ModelEvaluationMapper {

    /**
     * SELECT 操作: selectCountModel
     */
    List<ModelEvaluationPojo> selectCountModel();

    /**
     * SELECT 操作: selectWriteTime
     */
    String selectWriteTime(String param);

    /**
     * SELECT 操作: getModelEvaluationDataByAuditId
     */
    ModelEvaluationPojo getModelEvaluationDataByAuditId();

    /**
     * SELECT 操作: selectInfoAndStepByAuditModelNumber
     */
    List<AuditElementInfo> selectInfoAndStepByAuditModelNumber(AuditElementsParam param);

    /**
     * SELECT 操作: selectModelEvaluationList
     */
    List<AuditElementInfo> selectModelEvaluationList(ParamData param);

    /**
     * SELECT 操作: selectModelEvaluationListCount
     */
    Integer selectModelEvaluationListCount(Map param);

    /**
     * SELECT 操作: selectDModelEvaluationExportData
     */
    ModelEvaluationExportVo selectDModelEvaluationExportData(AuditElementsParam param);

    /**
     * SELECT 操作: selectByModelNumbers
     */
    Map selectByModelNumbers(AuditElementsParam param);

    /**
     * INSERT 操作: insertModelEvaluation
     */
    int insertModelEvaluation(AuditElementsParam param);

    /**
     * UPDATE 操作: updateModelEvaluation
     */
    int updateModelEvaluation();

    /**
     * UPDATE 操作: deleteModelEvaluation
     */
    int deleteModelEvaluation();

    /**
     * UPDATE 操作: updateModelOfflineType
     */
    int updateModelOfflineType(String param);

    /**
     * UPDATE 操作: updateModelNoOfflineType
     */
    int updateModelNoOfflineType(String param);

}
