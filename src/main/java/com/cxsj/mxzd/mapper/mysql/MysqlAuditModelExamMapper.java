package com.cxsj.mxzd.mapper.mysql;

import com.cxsj.mxzd.pojo.spl.ExamModelPojo;
import com.cxsj.mxzd.pojo.spl.ExamParam;
import com.cxsj.mxzd.pojo.spl.ExamPojp;
import com.cxsj.mxzd.pojo.spl.ExamineandapproveParam;
import com.cxsj.mxzd.pojo.PersonalCenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * AuditModelExamMapper Mapper 接口
 * 自动生成 - 请勿手动修改
 */
@Mapper
public interface MysqlAuditModelExamMapper {

    /**
     * SELECT 操作: getModelPrvd
     */
    String getModelPrvd(String param);

    /**
     * SELECT 操作: getDyModelPrvd
     */
    String getDyModelPrvd(String param);

    /**
     * SELECT 操作: selectDockerPrvd
     */
    String selectDockerPrvd(PersonalCenter param);

    /**
     * SELECT 操作: selectUserDockerPrvd
     */
    String selectUserDockerPrvd(PersonalCenter param);

    /**
     * SELECT 操作: selecPrvd
     */
    Map selecPrvd(Map param);

    /**
     * SELECT 操作: selectUserMsg
     */
    Map selectUserMsg(PersonalCenter param);

    /**
     * SELECT 操作: selectModelSpUser
     */
    Map selectModelSpUser(Map param);

    /**
     * SELECT 操作: selectDefaultSpUser
     */
    String selectDefaultSpUser(String param);

    /**
     * SELECT 操作: selectOneDefaultSpUser
     */
    Map selectOneDefaultSpUser(String param);

    /**
     * SELECT 操作: getTwoReplyUserDepy
     */
    Map getTwoReplyUserDepy(String param);

    /**
     * SELECT 操作: selectDefultMsg
     */
    Map selectDefultMsg(String param);

    /**
     * SELECT 操作: selectDockerUserDeputy
     */
    String selectDockerUserDeputy(String param);

    /**
     * SELECT 操作: selectUserDeputyMsg
     */
    Map selectUserDeputyMsg(String param);

    /**
     * SELECT 操作: selectModelDyUser
     */
    String selectModelDyUser(Map param);

    /**
     * SELECT 操作: selectModelSubmetUser
     */
    String selectModelSubmetUser(ExamineandapproveParam param);

    /**
     * SELECT 操作: selectModelsExamMsg
     */
    ExamPojp selectModelsExamMsg(ExamParam param);

    /**
     * SELECT 操作: selectDbCount
     */
    Integer selectDbCount(ExamParam param);

    /**
     * SELECT 操作: selectYbProIds
     */
    String selectYbProIds(ExamParam param);

    /**
     * SELECT 操作: selectYbCount
     */
    Integer selectYbCount(ExamParam param);

    /**
     * INSERT 操作: insertDbMsg
     */
    int insertDbMsg(ExamModelPojo param);

    /**
     * INSERT 操作: insertsplMaintenDb
     */
    int insertsplMaintenDb(ExamModelPojo param);

    /**
     * INSERT 操作: insertDyMsg
     */
    int insertDyMsg(ExamModelPojo param);

    /**
     * UPDATE 操作: updateDbType
     */
    int updateDbType(Map param);

    /**
     * UPDATE 操作: updateDyType
     */
    int updateDyType(Map param);

    /**
     * UPDATE 操作: updateDbRemarks
     */
    int updateDbRemarks(ExamParam param);

    /**
     * UPDATE 操作: updateYbMsg
     */
    int updateYbMsg(ExamParam param);

}
