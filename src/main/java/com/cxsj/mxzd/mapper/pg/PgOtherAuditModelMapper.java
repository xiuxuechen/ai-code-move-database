package com.cxsj.mxzd.mapper.pg;

import java.util.List;
import java.util.Map;

import com.cxsj.largemodel.facade.AuditElementInfoBaseFacade;
import com.cxsj.largemodel.facade.ModelKmFacade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * OtherAuditModelMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface PgOtherAuditModelMapper {

    /**
     * SELECT 操作: selectModelSysMsg
     */
    Map selectModelSysMsg(Map param);

    /**
     * SELECT 操作: selectUpdateModelNoList
     */
    Map selectUpdateModelNoList();

    /**
     * SELECT 操作: selectUpdateModelNumberMsg
     */
    Map selectUpdateModelNumberMsg();

    /**
     * SELECT 操作: updateModelNumber
     */
    List<Object> updateModelNumber(Map param);

    /**
     * SELECT 操作: selectMxzdModelMsg
     */
    ModelKmFacade selectMxzdModelMsg();

    /**
     * SELECT 操作: selectMxzdModelMsgTest
     */
    ModelKmFacade selectMxzdModelMsgTest();

    /**
     * SELECT 操作: selectModelCaseMsgTest
     */
    ModelKmFacade selectModelCaseMsgTest();

    /**
     * SELECT 操作: selectModelCaseMsg
     */
    ModelKmFacade selectModelCaseMsg();

    /**
     * SELECT 操作: selectLargeKmBaseEntity
     */
    AuditElementInfoBaseFacade selectLargeKmBaseEntity();

    /**
     * SELECT 操作: selectLargeKmBaseEntityTest
     */
    AuditElementInfoBaseFacade selectLargeKmBaseEntityTest();

    /**
     * UPDATE 操作: updateaudit_elements_data_cut_in
     */
    int updateaudit_elements_data_cut_in(Map param);

    /**
     * UPDATE 操作: updateaudit_supp_in_cut
     */
    int updateaudit_supp_in_cut(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_data_support_v2
     */
    int updateaudit_elements_data_support_v2(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_find_database
     */
    int updateaudit_elements_find_database(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_handover_model
     */
    int updateaudit_elements_handover_model(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_info
     */
    int updateaudit_elements_info(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_info_log
     */
    int updateaudit_elements_info_log(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_model_evaluation
     */
    int updateaudit_elements_model_evaluation(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_online_model
     */
    int updateaudit_elements_online_model(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_operation_steps
     */
    int updateaudit_elements_operation_steps(Map param);

    /**
     * UPDATE 操作: updateaudit_elements_system
     */
    int updateaudit_elements_system(Map param);

    /**
     * UPDATE 操作: updatespl_business_examine
     */
    int updatespl_business_examine(Map param);

    /**
     * UPDATE 操作: updatespl_model_type
     */
    int updatespl_model_type(Map param);

    /**
     * UPDATE 操作: updatespl_business_db
     */
    int updatespl_business_db(Map param);

    /**
     * UPDATE 操作: updatespl_business_dy
     */
    int updatespl_business_dy(Map param);

    /**
     * UPDATE 操作: updateUnitModelProType
     */
    int updateUnitModelProType(Map param);

    /**
     * UPDATE 操作: updateModelOtherMsg
     */
    int updateModelOtherMsg(Map param);

    /**
     * UPDATE 操作: bfTable
     */
    int bfTable(Map param);

    /**
     * DELETE 操作: dropTableBf
     */
    int dropTableBf();

}
