package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.PersonalCenter;
import java.util.List;
import java.util.Map;

import com.cxsj.mxzd.pojo.spl.HisExamineEntuty;
import com.cxsj.mxzd.pojo.spl.SqlModelTypeParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * PersonalCenterMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface PersonalCenterMapper {

    /**
     * SELECT 操作: getAuditPointNameList
     */
    Map getAuditPointNameList();

    /**
     * SELECT 操作: selectPersonalMessage
     */
    List<SqlModelTypeParam> selectPersonalMessage(Map param);

    /**
     * SELECT 操作: selectPersonalMessageCount
     */
    Integer selectPersonalMessageCount(Map param);

    /**
     * SELECT 操作: selectDbMsg
     */
    SqlModelTypeParam selectDbMsg(Map param);

    /**
     * SELECT 操作: selectDbMsgCount
     */
    Integer selectDbMsgCount(Map param);

    /**
     * SELECT 操作: selectMaintenDbMsg
     */
    SqlModelTypeParam selectMaintenDbMsg(Map param);

    /**
     * SELECT 操作: selectMainTenDbCount
     */
    Integer selectMainTenDbCount(Map param);

    /**
     * SELECT 操作: selectDyMsg
     */
    List<HisExamineEntuty> selectDyMsg(Map param);

    /**
     * SELECT 操作: selectDyMsgCount
     */
    Integer selectDyMsgCount(Map param);

    /**
     * SELECT 操作: selectInformationExistence
     */
    Integer selectInformationExistence(PersonalCenter param);

    /**
     * SELECT 操作: selectBeststatus
     */
    String selectBeststatus(PersonalCenter param);

    /**
     * SELECT 操作: getWriteTimeByAuditModelNumber
     */
    PersonalCenter getWriteTimeByAuditModelNumber(String param);

    /**
     * SELECT 操作: selectStatusCount
     */
    Integer selectStatusCount(Map param);

    /**
     * SELECT 操作: selectCenterCount
     */
    String selectCenterCount(PersonalCenter param);

    /**
     * SELECT 操作: selectUser
     */
    String selectUser();

    /**
     * SELECT 操作: getUserModel
     */
    PersonalCenter getUserModel();

    /**
     * SELECT 操作: selectMaintenPointNames
     */
    Map selectMaintenPointNames();

    /**
     * SELECT 操作: selectMaintenmodelNames
     */
    Map selectMaintenmodelNames();

    /**
     * INSERT 操作: insertPersonalCenterMessage
     */
    int insertPersonalCenterMessage(PersonalCenter param);

    /**
     * UPDATE 操作: updatePersonalCenterStatue
     */
    int updatePersonalCenterStatue(PersonalCenter param);

    /**
     * UPDATE 操作: updatePersonalCenterMessage
     */
    int updatePersonalCenterMessage(PersonalCenter param);

    /**
     * UPDATE 操作: updateMessage
     */
    int updateMessage(PersonalCenter param);

    /**
     * UPDATE 操作: updatePersonalCenterDeleteStatus
     */
    int updatePersonalCenterDeleteStatus(PersonalCenter param);

    /**
     * UPDATE 操作: updatePersonalCenterdeleteStatusJd
     */
    int updatePersonalCenterdeleteStatusJd(PersonalCenter param);

    /**
     * UPDATE 操作: updateEndUpdateTime
     */
    int updateEndUpdateTime(PersonalCenter param);

    /**
     * UPDATE 操作: deleteModelMessageSp
     */
    int deleteModelMessageSp(String param);

    /**
     * DELETE 操作: deleteInfoMessage
     */
    int deleteInfoMessage(PersonalCenter param);

}
