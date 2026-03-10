package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.AuditElementInfo;
import com.cxsj.mxzd.pojo.AuditElementsParam;
import com.cxsj.mxzd.pojo.AuditElementsSystemParam;
import com.cxsj.mxzd.pojo.PersonalCenter;
import java.util.List;
import java.util.Map;

import com.cxsj.mxzd.pojo.exportParam.AuditModelDesignVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DataAuditPracticeFrameworkMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface PgDataAuditPracticeFrameworkMapper {

    /**
     * SELECT 操作: getUserMessage
     */
    Map getUserMessage(PersonalCenter param);

    /**
     * SELECT 操作: getDropdownboxNo1TableNew
     */
    Map getDropdownboxNo1TableNew(Map param);

    /**
     * SELECT 操作: selectPrvdBusinessCode
     */
    String selectPrvdBusinessCode(String param);

    /**
     * SELECT 操作: selectBusiUnitCode
     */
    String selectBusiUnitCode(AuditElementsParam param);

    /**
     * SELECT 操作: getDropdownboxMo2TableNew
     */
    Map getDropdownboxMo2TableNew(Map param);

    /**
     * SELECT 操作: getBusiness2Number
     */
    String getBusiness2Number(Map param);

    /**
     * SELECT 操作: getauditPointCount
     */
    String getauditPointCount(Map param);

    /**
     * SELECT 操作: getAuditModelNum
     */
    String getAuditModelNum(String param);

    /**
     * SELECT 操作: getauditElementsParam
     */
    String getauditElementsParam(AuditElementsParam param);

    /**
     * SELECT 操作: getAuditModelNo
     */
    String getAuditModelNo(AuditElementsParam param);

    /**
     * SELECT 操作: selectAuditElementInfo
     */
    List<AuditElementInfo> selectAuditElementInfo(String param);

    /**
     * SELECT 操作: getsystemMyssage
     */
    AuditElementsSystemParam getsystemMyssage(String param);

    /**
     * SELECT 操作: selectDataAuditPracticeFramework
     */
    List<AuditElementsParam> selectDataAuditPracticeFramework(Map param);

    /**
     * SELECT 操作: exportDataAuditPracticeFramework
     */
    AuditModelDesignVo exportDataAuditPracticeFramework(AuditElementsParam param);

    /**
     * SELECT 操作: SelectDataAuditPracticeById
     */
    Map SelectDataAuditPracticeById(String param);

    /**
     * SELECT 操作: selectDataAuditPracticeFrameworkCount
     */
    Integer selectDataAuditPracticeFrameworkCount(Map param);

    /**
     * SELECT 操作: selectMdodelCont
     */
    String selectMdodelCont(AuditElementsParam param);

    /**
     * SELECT 操作: getcodeRequirements
     */
    Map getcodeRequirements(String param);

    /**
     * SELECT 操作: getMessageBycodeRequirements
     */
    Map getMessageBycodeRequirements(String param);

    /**
     * INSERT 操作: insertsystemMessage
     */
    int insertsystemMessage(AuditElementsSystemParam param);

    /**
     * INSERT 操作: insertAllsystemMessage
     */
    int insertAllsystemMessage();

    /**
     * UPDATE 操作: updatesystemMessage
     */
    int updatesystemMessage(AuditElementsSystemParam param);

    /**
     * UPDATE 操作: updatesystemdeleteStaues
     */
    int updatesystemdeleteStaues(AuditElementsSystemParam param);

    /**
     * UPDATE 操作: updateAuditElementInfoDeleteStaues
     */
    int updateAuditElementInfoDeleteStaues(AuditElementInfo param);

}
