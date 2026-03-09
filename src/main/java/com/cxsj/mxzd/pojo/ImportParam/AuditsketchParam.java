package com.cxsj.mxzd.pojo.ImportParam;


import com.alibaba.excel.annotation.ExcelProperty;
import com.cxsj.mxzd.interfaceSjys.CheckParamSjys;
import com.cxsj.mxzd.pojo.AuditElementCaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditsketchParam {
    private Integer Indexes;

    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;

    //审计模型编号:
    @ExcelProperty(index = 0)
    private String auditModelNumber;

    //审计模型名称:
    @ExcelProperty(index = 1)
    @CheckParamSjys(isNotNull = true)
    private String auditModelName;

    //一级业务流程
    @ExcelProperty(index = 2)
    @CheckParamSjys(isNotNull = true)
    private String primaryBusinessProcess;
    //二级业务流程
    @ExcelProperty(index = 3)
    @CheckParamSjys(isNotNull = true)
    private String secondaryBusinessProcess;

    //审计模型业务逻辑
    @ExcelProperty(index = 4)
    @CheckParamSjys(isNotNull = true, maxLength = 1000, dockPeople = "dockPeople1")
    private String auditBusinessLogic;


    //审计模型执行逻辑
    @ExcelProperty(index = 5)
    @CheckParamSjys(isNotNull = true, maxLength = 1000, dockPeople = "dockPeople1")
    private String executionLogic;

    //预期风险/问题发现
    @ExcelProperty(index = 6)
    @CheckParamSjys(maxLength = 1000, dockPeople = "dockPeople1")
    private String expectedRisks;

    //预期数据需求
    @ExcelProperty(index = 7)
    @CheckParamSjys(maxLength = 1000, dockPeople = "dockPeople1")
    private String expectedDataRequirements;

    //预期数据覆盖单位需求
    @ExcelProperty(index = 8)
    private String expectedDataCoversUnitDemand;

    //预期数据需求涉及系统
    @ExcelProperty(index = 9)
    private String requirementsInvolveTheSystem;

    //规范要求
    @ExcelProperty(index = 10)
    private String codeRequirement;
    //文件名称
    @ExcelProperty(index = 11)
    private String fileName;
    //规范要求类型
    @ExcelProperty(index = 12)
    private String specificationRequirement;
    //文号
    @ExcelProperty(index = 13)
    private String referenceNumber;
    //发文日期
    @ExcelProperty(index = 14)
    @CheckParamSjys(isdateVal = true, defaultVal = "yyyy-mm-dd", dockPeople = "dockPeople1")
    private String dispatchTime;
    //开始时间
    @ExcelProperty(index = 15)
    @CheckParamSjys(isdateVal = true, defaultVal = "yyyy-mm-dd", dockPeople = "dockPeople1")
    private String startTime;

    @ExcelProperty(index = 16)
    private String standardBasis;

    //结束时间
    private String endTime;

    private String modelOwnerDepy;

    //模型负责人
    @ExcelProperty(index = 17)
    @CheckParamSjys(isNotNull = true, checkDept = "dockDepartment1", dockPeople = "dockPeople1")
    private String modelOwner;


    //对接人
    @ExcelProperty(index = 18)
    @CheckParamSjys(checkDept = "dockDepartment1", dockPeople = "dockPeople1")
    private String dockPeople1;

    //录入人部门
    @ExcelProperty(index = 19)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople1")
    private String dockDepartment1;
    //录入人电话
    @ExcelProperty(index = 20)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople1")
    private String dockPhone1;

    //来源
    @ExcelProperty(index = 21)
    @CheckParamSjys( dockPeople = "dockPeople2")
    private String informationSources;

    //备注
    @ExcelProperty(index = 22)
    @CheckParamSjys(maxLength = 1000, dockPeople = "dockPeople2", relyOn = "informationSources", relyOnValue = "其他")
    private String remark;


    //共享单位
    @ExcelProperty(index = 23)
    private String shareUnit;

    //二级库模型编码
    @ExcelProperty(index = 24)
    private String secondModelNumber;


    //问题概要
    private String problemSummary;

    //问题详细描述
    private String problemDescription;

    //审计期间
    private String auditTime;

    //涉及单位
    private String auditInvolved;

    //所属项目
    private String auditProject;

    //审计关注点
    private String auditPoint;


    //预期审计发现
    private String auditProspectivePoint;


    //审计依据制度名称
    private String auditSystemName;


    //审计依据制度内容
    private String auditSystemContent;


    //审计发现现场确认情况
    private String auditConfirmationFindings;


    //模型名称
    private String auditModelNameSend;


    //模型逻辑
    private String auditModelLogic;

    //对接人(信息来源)
    @ExcelProperty(index = 25)
    @CheckParamSjys(checkDept = "dockDepartment2", dockPeople = "dockPeople2")
    private String dockPeople2;

    //录入人部门
    @ExcelProperty(index = 26)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople2")
    private String dockDepartment2;
    //录入人电话
    @ExcelProperty(index = 27)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople2")
    private String dockPhone2;

    //-----------三、数据支撑能力

    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    @ExcelProperty(index = 28)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople")
    private String isAcc;

    //数据来源
    @ExcelProperty(index = 29)
    @CheckParamSjys(dockPeople = "dockPeople", relyOn = "isAcc", relyOnValue = "否", maxLengthNew = 19)
    private String dataSupporter;

    //对象中文名
    @ExcelProperty(index = 30)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople", relyOn = "isAcc", relyOnValue = "是")
    private String name;

    //对象英文名
    @ExcelProperty(index = 31)
    @CheckParamSjys(dockPeople = "dockPeople", relyOn = "isAcc", relyOnValue = "是")
    private String dataCode;

    //数据编码
    @ExcelProperty(index = 32)
    @CheckParamSjys(dockPeople = "dockPeople", relyOn = "isAcc", relyOnValue = "是")
    private String assetCode;

    //来源系统编码
    private String originalSystemcode;

    //来源系统
    @ExcelProperty(index = 33)
    @CheckParamSjys(dockPeople = "dockPeople")
    private String originalSystem;

    //接口编码
    private String interId;

    //接口名称
    @ExcelProperty(index = 34)
    @CheckParamSjys(dockPeople = "dockPeople")
    private String interName;

    //所属层
    private String objLevelCode;

    //业务分类
    private String busiType;

    //数据状态
    @ExcelProperty(index = 35)
    private String dataStatus;

    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    private String existingDataOfModelId;

    //备注
    @ExcelProperty(index = 36)
    private String remark1;

    //数据内容描述(数据接入需求)
    private String dataContentDescriptionXq;

    //涉及系统(数据接入需求)
    private String involvedSystem;


    private String scopeOfDataXq;

    //录入人
    @ExcelProperty(index = 37)
    @CheckParamSjys(checkDept = "dockDepartment3", dockPeople = "dockPeople")
    private String dockPeople;

    //录入人部门
    @ExcelProperty(index = 38)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople")
    private String dockDepartment3;
    //录入人电话
    @ExcelProperty(index = 39)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople")
    private String dockPhone3;

    //-----------四、审计模型部署
    //审计模型描述
    private String auditModelDescribe;
    //模型评估结果
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
    //模型代码(模型评估与已上线模型)
    @ExcelProperty(index = 40)
    @CheckParamSjys(isNotNull = true,relyOn = "progressTheDevelopment", relyOnValue = "已完成开发", dockPeople = "dockPeople3")
    private String modelCode;
    //模型状态
    @ExcelProperty(index = 41)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople3")

    private String modelState;

    //所属系统(模型评估与已上线模型)
    private String subordinateToSystem;

    @CheckParamSjys(isNotNull = false, dockPeople = "dockPeople3")
    private String isSyn;


    /**
     * 建模方式
     * 审计点超市/自助建模/省内自建
     */
    @ExcelProperty(index = 42)
    @CheckParamSjys(isNotNull = true, relyOn = "modelingMethod", relyOnValue = "审计点超市", dockPeople = "dockPeople3")
    private String modelingMethod;


    private String synUrl;


    //录入人
    @ExcelProperty(index = 43)
    @CheckParamSjys(checkDept = "dockDepartment4", dockPeople = "dockPeople3")
    private String dockPeople3;

    //录入人部门
    @ExcelProperty(index = 44)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople3")
    private String dockDepartment4;
    //录入人电话
    @ExcelProperty(index = 45)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople3")
    private String dockPhone4;


    //审计点超市、省内自建、自助建模-自建、自助建模-订购
    //审计模型业务逻辑
    private String auditModelBusinessLogic;

    //业务归属系统
    @ExcelProperty(index = 46)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", relyOnValue = "CRM系统,ERP系统,ERP系统、久其系统,合同系统,合同系统、一经,BOSS系统,CRM系统、一级营销,BOSS系统、CRM系统,BOSS系统、VC,CRM系统、VC系统,CRM系统、BOSS系统、VC,合同系统、供应链系统,报账平台,合同系统、报账平台,合同系统、ERP系统系统,供应链系统," +
            "OA系统,4A系统,合同系统、报账平台、资金支付系统,合同系统、SP局数据,供应链系统、报账平台,报账平台、合同系统、资金系统,报账平台、其他（主数据系统）,报账平台、资金系统,报账平台、主数据," +
            "报账平台、合同系统,CRM系统、综合资管,BOSS系统、ERP系统、CRM系统,ERP系统系统,供应链系统、合同管理系统,ES系统、合同管理系统,ES系统,供应链系统、ERP系统," +
            "合同管理系统、供应链系统、ES系统、报账系统,供应链系统、ERP系统、ES系统,其它", relyOn = "serviceOwnershipSystem")
    private String serviceOwnershipSystem;


    //模型运行频率
    @ExcelProperty(index = 47)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", relyOnValue = "日,月,季度,年,按需", relyOn = "modelRunningFrequency")
    private String modelRunningFrequency;


    //审计覆盖单位数量
    @ExcelProperty(index = 48)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", isInteger = true)
    private String numberUnitsCovered;


    //省公司覆盖数量
    @ExcelProperty(index = 49)
    @CheckParamSjys( dockPeople = "dockPeople4", isInteger = true)
    private String numberOfProvincial;


    //专业机构数量
    @ExcelProperty(index = 50)
    @CheckParamSjys( dockPeople = "dockPeople4", isInteger = true)
    private String numberProfessionalInstitutions;


    //是否已在系统固化
    private String whetherCuredSystem;


    //模型上线时间
    @ExcelProperty(index = 51)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", defaultVal = "yyyy-mm-dd")
    private String modelOnlineTime;


    //运行方式
    @ExcelProperty(index = 52)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", relyOnValue = "全自动,半自动,全/半自动", relyOn = "runningMode")
    private String runningMode;


    //审计实务来源
    @ExcelProperty(index = 53)
    @CheckParamSjys(dockPeople = "dockPeople4", relyOnValue = "风险提示,持续审计,智能审计,制度审计", relyOn = "sourcesAuditPractice")
    private String sourcesAuditPractice;


    //质量评级
    @ExcelProperty(index = 54)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4", relyOnValue = "一级,二级,三级", relyOn = "qualityRating")
    private String qualityRating;


    //归属专题
    @ExcelProperty(index = 55)
    @CheckParamSjys(dockPeople = "dockPeople4", relyOnValue = "流量管理违规,跨省窜卡,流量管理违规,宽带业务管理违规,物联网卡管理违规,终端套利," +
            "养卡套利,有价卡管理违规,员工异常业务操作,电子券管理违规,客户信息安全管理违规,资金支付管理违规,客户欠费,集团专线管理违规,其他", relyOn = "ascriptionSpecial")
    private String ascriptionSpecial;


    //备注
    @ExcelProperty(index = 56)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String onlineRemarks;


    /**
     * 审计发现案例
     */
    //问题概要
    @ExcelProperty(index = 57)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String problemSummarySj;


    //问题详细描述
    @ExcelProperty(index = 58)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String problemDetailDescriptionSj;

    //审计期间
    @ExcelProperty(index = 59)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String auditPeriodSj;


    //涉及单位
    @ExcelProperty(index = 60)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String involvedUnitSj;

    //所属项目
    @ExcelProperty(index = 61)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String auditProjectSj;


    /**
     * 延伸发现案例
     */
    //问题概要
    @ExcelProperty(index = 62)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String problemSummaryYs;


    //问题详细描述
    @ExcelProperty(index = 63)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String problemDetailDescriptionYs;

    //审计期间
    @ExcelProperty(index = 64)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String auditPeriodYs;


    //涉及单位
    @ExcelProperty(index = 65)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String involvedUnitYs;

    //所属项目
    @ExcelProperty(index = 66)
    @CheckParamSjys(dockPeople = "dockPeople4")
    private String auditProjectYs;


    //模型维护负责人
    @ExcelProperty(index = 67)
    @CheckParamSjys(checkDept = "dockPeople4Dock", dockPeople = "dockPeople4")
    private String dockPeople4;


    //对接人部门
    @ExcelProperty(index = 68)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4")
    private String dockPeople4Dock;


    //d对接人联系方式
    @ExcelProperty(index = 69)
    @CheckParamSjys(isNotNull = true, dockPeople = "dockPeople4")
    private String dockPeople4Phone;


    public void setAuditModelName(String auditModelName) {
        this.auditModelName = auditModelName;
        if (StringUtils.isNotBlank(auditModelName)) {
            this.auditPointName = auditModelName;
        }
    }


    /**
     * 审计发现案例字段是否都为空
     *
     * @return
     */
    public boolean areFieldsEmptySj() {
        return (problemSummarySj == null || problemSummarySj.trim().isEmpty()) &&
                (problemDetailDescriptionSj == null || problemDetailDescriptionSj.trim().isEmpty()) &&
                (auditPeriodSj == null || auditPeriodSj.trim().isEmpty()) &&
                (involvedUnitSj == null || involvedUnitSj.trim().isEmpty()) &&
                (auditProjectSj == null || auditProjectSj.trim().isEmpty());
    }


    public AuditElementCaseEntity createAuditElementCaseEntityIfNotEmptySj(List<AuditElementCaseEntity> caseEntities) {
        Integer num = countTypeOneEntities(caseEntities, 1);
        if (!areFieldsEmptySj()) {
            AuditElementCaseEntity entity = new AuditElementCaseEntity();
            entity.setProblemDetailDescription(problemDetailDescriptionSj);
            entity.setProblemSummary(problemSummarySj);
            entity.setAuditPeriod(auditPeriodSj);
            entity.setAuditModelNumber(auditModelNumber);
            entity.setInvolvedUnit(involvedUnitSj);
            entity.setAuditProject(auditProjectSj);
            entity.setType(1);
            entity.setOrder((num + 1));
            // 设置其他属性，如果有的话
            return entity;
        }
        return null;
    }


    public AuditElementCaseEntity createAuditElementCaseEntityIfNotEmptyYs(List<AuditElementCaseEntity> caseEntities) {
        Integer num = countTypeOneEntities(caseEntities, 2);
        if (!areFieldsEmptyYs()) {
            AuditElementCaseEntity entity = new AuditElementCaseEntity();
            entity.setProblemDetailDescription(problemDetailDescriptionYs);
            entity.setProblemSummary(problemSummaryYs);
            entity.setAuditPeriod(auditPeriodYs);
            entity.setInvolvedUnit(involvedUnitYs);
            entity.setAuditModelNumber(auditModelNumber);
            entity.setAuditProject(auditProjectYs);
            entity.setType(2);
            entity.setOrder((num + 1));
            return entity;
        }
        return null;
    }

    private boolean areFieldsEmptyYs() {
        return (problemSummaryYs == null || problemSummaryYs.trim().isEmpty()) &&
                (problemDetailDescriptionYs == null || problemDetailDescriptionYs.trim().isEmpty()) &&
                (auditPeriodYs == null || auditPeriodYs.trim().isEmpty()) &&
                (involvedUnitYs == null || involvedUnitYs.trim().isEmpty()) &&
                (auditProjectYs == null || auditProjectYs.trim().isEmpty());
    }



    public static Integer countTypeOneEntities(List<AuditElementCaseEntity> caseEntities, Integer type) {
        if (caseEntities == null) {
            return 0;
        }
        return Math.toIntExact(caseEntities.stream()
                .filter(Objects::nonNull)
                .filter(entity -> entity.getType() != null && entity.getType() == type)
                .count());
    }

}
