package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.ExamineandapproveParam;
import com.cxsj.mxzd.pojo.MaintenMsgParam;
import com.cxsj.mxzd.pojo.Map;
import com.cxsj.mxzd.pojo.ModelBasisFacade;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * AuditOtherMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface AuditOtherMapper {

    /**
     * SELECT 操作: selectAuditCodeCount
     */
    Integer selectAuditCodeCount(MaintenMsgParam param);

    /**
     * SELECT 操作: selectModelNumberCount
     */
    Integer selectModelNumberCount(MaintenMsgParam param);

    /**
     * SELECT 操作: selectMaintenNoTxMsgByModelNumber
     */
    Integer selectMaintenNoTxMsgByModelNumber(String param);

    /**
     * SELECT 操作: selectMaintenMsg
     */
    MaintenMsgParam selectMaintenMsg(String param);

    /**
     * SELECT 操作: selectModelMsg
     */
    Map selectModelMsg(String param);

    /**
     * SELECT 操作: selectStatisticsTableModelCount
     */
    Integer selectStatisticsTableModelCount(MaintenMsgParam param);

    /**
     * SELECT 操作: selectBusiUnitCodeByName
     */
    String selectBusiUnitCodeByName(String param);

    /**
     * SELECT 操作: selectMaintenTbaleMsgCount
     */
    Integer selectMaintenTbaleMsgCount(String param);

    /**
     * SELECT 操作: selectMaintenMsgByTable
     */
    List<MaintenMsgParam> selectMaintenMsgByTable(String param);

    /**
     * SELECT 操作: selectMaintenMsgBySupTable
     */
    List<MaintenMsgParam> selectMaintenMsgBySupTable(String param);

    /**
     * INSERT 操作: insertModelChaoshi
     */
    int insertModelChaoshi(Map param);

    /**
     * INSERT 操作: insertBoncMenuMsg
     */
    int insertBoncMenuMsg(MaintenMsgParam param);

    /**
     * INSERT 操作: insertStatisticsTableModel
     */
    int insertStatisticsTableModel(Map param);

    /**
     * INSERT 操作: insertCompanyModelStatisticeTableMsg
     */
    int insertCompanyModelStatisticeTableMsg(Map param);

    /**
     * INSERT 操作: insertCompanyModelTableMsg
     */
    int insertCompanyModelTableMsg(Map param);

    /**
     * INSERT 操作: insertMaintenTbaleMsg
     */
    int insertMaintenTbaleMsg(MaintenMsgParam param);

    /**
     * UPDATE 操作: insertMaintenMsg
     */
    int insertMaintenMsg(MaintenMsgParam param);

    /**
     * UPDATE 操作: updateModelChaoshi
     */
    int updateModelChaoshi(Map param);

    /**
     * UPDATE 操作: updateDbType
     */
    int updateDbType(MaintenMsgParam param);

    /**
     * UPDATE 操作: updateStatisticsTableModel
     */
    int updateStatisticsTableModel(Map param);

    /**
     * UPDATE 操作: updateMxzdModelStep
     */
    int updateMxzdModelStep(String param);

    /**
     * UPDATE 操作: updateAuditElementInfo
     */
    int updateAuditElementInfo(ModelBasisFacade param);

    /**
     * UPDATE 操作: updateAuditModelType
     */
    int updateAuditModelType(String param);

    /**
     * UPDATE 操作: updateMaintenTbaleMsg
     */
    int updateMaintenTbaleMsg(MaintenMsgParam param);

    /**
     * UPDATE 操作: updateMaintenMsgStatus
     */
    int updateMaintenMsgStatus(String param);

    /**
     * DELETE 操作: delBoncMenuMsg
     */
    int delBoncMenuMsg(MaintenMsgParam param);

    /**
     * DELETE 操作: deleteModelChaoshiMsg
     */
    int deleteModelChaoshiMsg(String param);

    /**
     * DELETE 操作: deleteSupStatisticsMsg
     */
    int deleteSupStatisticsMsg(String param);

    /**
     * DELETE 操作: deleteCompanyModelMsgByModelNumber
     */
    int deleteCompanyModelMsgByModelNumber(String param);

    /**
     * DELETE 操作: deleteCompanyModelStaMsgByModelNumber
     */
    int deleteCompanyModelStaMsgByModelNumber(String param);

    /**
     * DELETE 操作: deleteAuditElementsDataCutIn
     */
    int deleteAuditElementsDataCutIn(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsDataSupportV2
     */
    int deleteAuditElementsDataSupportV2(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsFindDatabase
     */
    int deleteAuditElementsFindDatabase(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsHandoverModel
     */
    int deleteAuditElementsHandoverModel(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsInfo
     */
    int deleteAuditElementsInfo(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsModelEvaluation
     */
    int deleteAuditElementsModelEvaluation(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsOnlineModel
     */
    int deleteAuditElementsOnlineModel(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsOperationSteps
     */
    int deleteAuditElementsOperationSteps(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementCase
     */
    int deleteAuditElementCase(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditElementsSystem
     */
    int deleteAuditElementsSystem(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteAuditSuppInCut
     */
    int deleteAuditSuppInCut(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteSplBusinessExamine
     */
    int deleteSplBusinessExamine(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteSplModelType
     */
    int deleteSplModelType(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteSplBusinessDb
     */
    int deleteSplBusinessDb(ExamineandapproveParam param);

    /**
     * DELETE 操作: deleteSplBusinessDy
     */
    int deleteSplBusinessDy(ExamineandapproveParam param);

}
