/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditElementInfo
 * Author:   DELL
 * Date:     2021/7/7 9:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @auther hmj 基础数据实体
 * @date 2021/7/7 9:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditElementInfo {
    private Integer id;
    private String auditPointNumber;//审计点编号
    private String auditPointName;//审计点名称
    private String auditModelNumber;//审计模型编号
    private String auditModelName;//审计模型名称
    private String auditModelDescribe;//审计模型描述
    private String informationSupplement;//信息补充状态(1-审计模型设计2-审计模型来源信息3-数据支撑能力4-模型评估与开发5-已上线审计模型)
    private String informationSources;//来源信息
    //共享单位
    private String shareUnit;

    //二级库模型编码
    private String secondModelNumber;


    private String shareUnitName;


    private String secondModelName;

    private String remark;//备注
    //模型负责人
    private String modelOwner;
    private String modelOwnerDepy;
    private Boolean modelOwnerCanUpdate = true;
    private String auditBusinessLogic;//审计点业务逻辑
    private String executionLogic;  //审计点执行逻辑
    private String auditModelBusinessLogic;//审计模型业务逻辑
    private String primaryBusinessProcess;//一级业务流程
    private String expectedRisks;//预期风险/问题发现
    private String expectedDataRequirements;//预期数据需求
    private String expectedDataCoversUnitDemand;//预期数据覆盖单位需求
    private String otherExpectedDataCoversUnitDemand;//其他预期数据覆盖单位需求
    private String requirementsInvolveTheSystem;//预期数据需求涉及系统
    private String otherRequirementsInvolveTheSystem;
    private String subordinateToSystem;//所属系统(模型评估与已上线模型)
    private String modelCode;//模型代码(模型评估与已上线模型)
    private Boolean modelCodeCanUpdate = true;
    private String secondaryBusinessProcess;//二级业务流程
    private String supportRemark;//数据支撑备注

    private String businessArea;


    private String sourceDomain;
    //对接人
    private String dockPeople;
    //对接电话
    private String dockPhone;
    //录入日期
    private String writeTime;
    //录入部门
    private String dockDepartment;
    //数据内容描述
    private String dataContentDescription;
    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    private String existingDataOfModelId;
    //数据起始时间
    private String accessTime;
    private Date createTime;

    /*模型评估与开发独有部分入参字段 start ---------**/
    //评估结果
    private String assessmentResult;
    //模型评估备注
    private String modelAssessmentRemarks;
    //部分开发修正后的模型逻辑
    private String modelDevelopmentLogic;
    //后续待开发内容
    private String stayDevelopmentContent;
    //开发进度
    private String progressTheDevelopment;
    //预期完成时间
    private String expectedCompletionTime;
    //尚欠缺条件情况
    private String conditionsStillLacking;
    //模型开发备注
    private String modelDevelopmentRemarks;
    //模型状态
    private String modelState;

    //建模方式
    private String modelingMethod;

    private Boolean modelingMethodCanUpdate = true;

    //删除状态
    private String isDeleted;

    private String[] ids;

    private String code;
    /*模型评估与开发独有部分入参字段  end---------**/

    /*已上线审计模型独有部分入参字段 start ---------**/
    //业务归属系统
    private String serviceOwnershipSystem;
    //数据起始时间
    private String dataStartTime;
    //模型运行频率
    private String modelRunningFrequency;
    //审计覆盖单位数量
    private String numberUnitsCovered;
    //省公司覆盖数量
    private String numberOfProvincial;
    //专业机构数量
    private String numberProfessionalInstitutions;
    //是否已在系统固化
    private String whetherCuredSystem;
    //模型上线时间
    private String modelOnlineTime;
    //审计实务来源
    private String sourcesAuditPractice;
    //归属专题
    private String ascriptionSpecial;
    //备注
    private String onlineRemarks;
    /*已上线审计模型独有部分入参字段 end ---------**/


    //为了创建集合返回（来源数据信息，可不用,做空返回）
    private String auditPoint;
    private String auditProspectivePoint;
    private String auditSystemName;
    private String auditSystemContent;
    private String auditConfirmationFindings;
    private String auditModelNameSend;
    private String auditModelLogic;
    private String typeOfInformation;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date detailedTime;

    private List<AuditFindDataBase> auditFindDataBases;

    private String returnMessage;

    private String isOnline;

    private String canSubmit;

    private String isSyn;
    private String synUrl;
    private Boolean synUrlCanUpdate = true;
    private String defExamUser;

    private String defExamUserName;

    private String dataName;

    private String def2ExamUserName;

    private String def2ExamUser;

    //模型共享审批人员
    private String shareUser;


    private String shareUserDepy;

    //是否纳入总部模型库
    private String offModelLibrary;

    //模型代码id
    private Integer modelCodeFileId;


    public boolean canUploadModelCodeFile = true;

    //质量评级
    private String qualityRating;

    private Boolean qualityRatingShow = true;


    private String runningMode;


    //是否共享
    private String isShare;


    //状态
    private String offModelLibAndShareType;


    private String modelCodeFilePath;

    private String modelCodeFileName;

    //审计发现案例
    private List<AuditElementCaseEntity> caseSjs;

    //延伸发现案例
    private List<AuditElementCaseEntity> caseYss;


    private String offline;



    private Boolean canDownCode = false;


}
