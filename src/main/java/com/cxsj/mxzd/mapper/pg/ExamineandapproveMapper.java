package com.cxsj.mxzd.mapper.pg;

import com.cxsj.mxzd.pojo.ExamHisEntuty;
import com.cxsj.mxzd.pojo.ExamineandapproveParam;
import com.cxsj.mxzd.pojo.PersonalCenter;
import com.cxsj.mxzd.pojo.SqlModelTypeParam;
import com.cxsj.mxzd.pojo.WorkItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ExamineandapproveMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface ExamineandapproveMapper {

    /**
     * SELECT 操作: selectNowExamineadapprove
     */
    String selectNowExamineadapprove(Map param);

    /**
     * SELECT 操作: getSqlUser
     */
    String getSqlUser();

    /**
     * SELECT 操作: selectWorkIdById
     */
    ExamHisEntuty selectWorkIdById(String param);

    /**
     * SELECT 操作: selectUserHisMsg
     */
    ExamHisEntuty selectUserHisMsg(Map param);

    /**
     * SELECT 操作: getModelCount
     */
    Integer getModelCount(String param);

    /**
     * SELECT 操作: selctSubmitUser
     */
    PersonalCenter selctSubmitUser(String param);

    /**
     * SELECT 操作: selectModelName
     */
    String selectModelName(String param);

    /**
     * SELECT 操作: selectDyModelName
     */
    String selectDyModelName(String param);

    /**
     * SELECT 操作: selectAuditExamineId
     */
    Map selectAuditExamineId();

    /**
     * SELECT 操作: selectDeputyMsg
     */
    Map selectDeputyMsg();

    /**
     * SELECT 操作: getSpDefaultMsg
     */
    Map getSpDefaultMsg();

    /**
     * SELECT 操作: getUnitSpDefaultMsg
     */
    Map getUnitSpDefaultMsg();

    /**
     * SELECT 操作: selectModelMsgByModelNubmer
     */
    Map selectModelMsgByModelNubmer(String param);

    /**
     * SELECT 操作: getModelMessage
     */
    Map getModelMessage(String param);

    /**
     * SELECT 操作: getExamUser
     */
    Map getExamUser();

    /**
     * SELECT 操作: getModelShangxianType
     */
    String getModelShangxianType();

    /**
     * SELECT 操作: selectModelJcMsg
     */
    Map selectModelJcMsg(String param);

    /**
     * SELECT 操作: selectExaminMsg
     */
    Map selectExaminMsg(String param);

    /**
     * SELECT 操作: selectDockPeopleMsg
     */
    Map selectDockPeopleMsg(String param);

    /**
     * SELECT 操作: selectModelId
     */
    String selectModelId(String param);

    /**
     * SELECT 操作: selectModelMessage
     */
    String selectModelMessage();

    /**
     * SELECT 操作: selectModelExminMsg
     */
    Map selectModelExminMsg(String param);

    /**
     * SELECT 操作: getModelTypeAndDept
     */
    Map getModelTypeAndDept(String param);

    /**
     * SELECT 操作: getModelTypeExam
     */
    String getModelTypeExam(String param);

    /**
     * SELECT 操作: selectSourceData
     */
    String selectSourceData(String param);

    /**
     * SELECT 操作: selectLoginUserMsg
     */
    Map selectLoginUserMsg(String param);

    /**
     * SELECT 操作: getIsSupperUser
     */
    Integer getIsSupperUser(PersonalCenter param);

    /**
     * INSERT 操作: insertModelMessage
     */
    int insertModelMessage(SqlModelTypeParam param);

    /**
     * INSERT 操作: insertSubmitMessage
     */
    int insertSubmitMessage(Map param);

    /**
     * INSERT 操作: insertsplMessageBf
     */
    int insertsplMessageBf(Map param);

    /**
     * INSERT 操作: insertModelChaoshi
     */
    int insertModelChaoshi(Map param);

    /**
     * INSERT 操作: insertWorkItem
     */
    int insertWorkItem(WorkItemEntity param);

    /**
     * UPDATE 操作: updateModelStatus
     */
    int updateModelStatus(SqlModelTypeParam param);

    /**
     * UPDATE 操作: UpdateReplyMessage
     */
    int UpdateReplyMessage(Map param);

    /**
     * UPDATE 操作: updateDyTypeByDyProId
     */
    int updateDyTypeByDyProId(String param);

    /**
     * UPDATE 操作: updateAuditModelShangxian
     */
    int updateAuditModelShangxian(String param);

    /**
     * UPDATE 操作: updateexamineandId
     */
    int updateexamineandId(ExamineandapproveParam param);

    /**
     * UPDATE 操作: updateMaintenDbType
     */
    int updateMaintenDbType(String param);

    /**
     * UPDATE 操作: updateModelMrSpUser
     */
    int updateModelMrSpUser(Map param);

    /**
     * UPDATE 操作: updateInsertWorkItem
     */
    int updateInsertWorkItem(WorkItemEntity param);

    /**
     * DELETE 操作: deleteModelYuanyou
     */
    int deleteModelYuanyou(String param);

    /**
     * DELETE 操作: delSplMaintenDb
     */
    int delSplMaintenDb(String param);

}
