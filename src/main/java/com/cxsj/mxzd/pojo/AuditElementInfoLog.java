/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditElementInfoLog
 * Author:   DELL
 * Date:     2021/7/8 10:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *@auther hmj 日志记录
 *@date 2021/7/8 10:05
 *@version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditElementInfoLog {

    private Integer id;
    private String auditPointNumber;//审计点编号
    private String auditPointName;//审计点名称
    private String auditModelNumber;//审计模型编号
    private String auditModelName;//审计模型名称
    private String auditModelDescribe;//审计模型描述
    private String informationSupplement;//信息补充状态(1-审计模型设计2-审计模型来源信息3-数据支撑能力4-模型评估与开发5-已上线审计模型)
    private String informationSources;//来源信息
    private String findRemark;//备注
    private String auditBusinessLogic;//审计点业务逻辑
    private String auditModelBusinessLogic;//审计模型业务逻辑
    private String primaryBusinessProcess;//一级业务流程
    private String expectedRisks;//预期风险/问题发现
    private String expectedDataRequirements;//预期数据需求
    private String expectedDataCoversUnitDemand;//预期数据覆盖单位需求
    private String requirementsInvolveTheSystem;//预期数据需求涉及系统
    private String subordinateToSystem;//所属系统(模型评估与已上线模型)
    private String modelCode;//模型代码(模型评估与已上线模型)
    private String secondaryBusinessProcess;//二级业务流程
    //录入人
    private String dockPeople;
    //录入人电话
    private String dockPhone;

    //填写日期
    private String writeTime;
    //录入人部门
    private String dockDepartment;
    //信息类型
    private String informationType;
    //规范要求
    private String codeRequirement;

    //文件名称
    private String fileName;
    //规范要求类型
    private String specificationRequirement;
    //文号
    private String referenceNumber;
    //发文日期
    private String dispatchTime;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    private String auditPoint;//审计点
    private String auditProspectivePoint;//预期审计发现
    private String auditSystemName;//'审计依据制度名称'
    private String auditSystemContent;//'审计依据制度内容'
    private String auditConfirmationFindings;//'审计发现现场确认情况'
    private String auditModelNameSend;//'模型名称'
    private String auditModelLogic;//'模型逻辑'
    //问题概要
    private String problemSummary;
    //问题详细描述
    private String problemDescription;
    //审计时间
    private String auditTime;
    //涉及单位
    private String auditInvolved;
    //模型评估备注
    private String modelAssessmentRemarks;
    //所属项目
    private String auditProject;
    private String dataContentDescription;
    //数据范围
    private String scopeOfData;
    //数据归属域
    private String dataDomain;
    //数据接入来源
    private String dataAccessSource;
    //数据归属系统
    private String dataAttributionSystem;
    //数据接入时间
    private String accessTime;
    //数据留存周期
    private String dataRetentionCycle;
    //是否结构化数据(1-是0-否)
    private String structuredDataNot;
    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    private String existingDataOfModel;
    //备注
    private String remark;

    //数据内容描述(数据接入需求)
    private String dataContentDescriptionXq;
    //涉及系统
    private String involvedSystem;
    //数据范围(数据接入需求)
    private String scopeOfDataXq;
    //评估结果
    private String assessmentResult;
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
    //业务归属系统
    private String serviceOwnershipSystem;
    //模型所用数据源
    private String dataSourceUsedModel;
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

    //是否删除
    private String operationLog;
    //操作人
    private String createPerson;
    //操作时间
    private Date createDate;
    //操作人部门
    private String organ;
    //操作人电话
    private String phone;
















}
