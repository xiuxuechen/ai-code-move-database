package com.cxsj.largemodel.facade;

import lombok.Data;

/**
 * @author wzy
 * @describe todo
 * @data 2025/3/13-15:13
 */
@Data
public class AuditElementInfoBaseFacade {

    // 模型基础信息
    private String auditModelNumber; // 审计模型编号
    private String auditModelName; // 审计模型名称
    private String primaryBusinessProcess; // 一级业务流程
    private String secondaryBusinessProcess; // 二级业务流程
    private String auditBusinessLogic; // 审计模型业务逻辑
    private String expectedRisks; // 预期风险

    // 模型类型信息
    private String writeTime; // 填写时间
    private String modelOwner; // 责任人
    private String dockDept; // 对接人部门

    // 元素信息
    private String codeRequirement; // 规范要求
    private String fileName; // 文件名称
    private String specificationRequirement; // 规范要求类型
    private String referenceNumber; // 文号
    private String dispatchTime; // 发文时间
    private String startTime; // 开始时间
    private String standardBasis; // 规范依据

    // 在线模型信息
    private String numberUnitsCovered; // 审计覆盖单位数量
    private String numberProfessionalInstitutions; // 专业机构数量
    private String numberOfProvincial; // 省公司数量
    private String modelOnlineTime; // 模型上线时间
    private String serviceOwnershipSystem; // 业务归属系统
    private String modelRunningFrequency; // 模型运行频率
    private String runningMode; // 运行方式
    private String qualityRating; // 质量评级
    private String sourcesAuditPractice; // 审计实务来源
    private String ascriptionSpecial; // 归属专题
    private String onlineRemarks; // 备注

    // 模型类型信息（补充）
    private String defExamUserDept; // 审批人

    // 审计发现案例信息
    private String problemSummary; // 问题概要
    private String problemDetailDescription; // 问题详细描述
    private String auditPeriod; // 审计期间
    private String involvedUnit; // 涉及单位
    private String auditProject; // 所属项目

    // 延伸发现案例信息
    private String ysProblemSummary; // 问题概要
    private String ysProblemDetailDescription; // 问题详细描述
    private String ysAuditPeriod; // 审计期间
    private String ysInvolvedUnit; // 涉及单位
    private String ysAuditProject; // 所属项目
}
