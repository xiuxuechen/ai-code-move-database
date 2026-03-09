package com.cxsj.mxzd.pojo.exportParam;


import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@ContentRowHeight(55)
@HeadRowHeight(40)
@ColumnWidth(30)
public class AuditModelDesignVo {


    //审计点编号

    private String auditPointNumber;
    //审计点名称

    private String auditPointName;
    //审计模型编号:

    private String auditModelNumber;

    //审计模型名称:

    private String auditModelName;

    //一级业务流程

    private String primaryBusinessProcess;
    //二级业务流程

    private String secondaryBusinessProcess;

    //审计点业务逻辑

    private String auditBusinessLogic;


    private String executionLogic;  //审计点执行逻辑

    //预期风险/问题发现

    private String expectedRisks;

    //预期数据需求

    private String expectedDataRequirements;

    //预期数据覆盖单位需求

    private String expectedDataCoversUnitDemand;

    //预期数据需求涉及系统

    private String requirementsInvolveTheSystem;

    //模型负责人
    private String modelOwner;


    private String modelOwnerDepy;


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


    //规范依据
    private String standardBasis;

    //录入人

    private String dockPeople;

    private String dockDepartment;
}
