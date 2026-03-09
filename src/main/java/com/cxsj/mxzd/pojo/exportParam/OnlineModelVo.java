package com.cxsj.mxzd.pojo.exportParam;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.cxsj.mxzd.interfaceSjys.CheckParamSjys;
import lombok.Data;

@Data
@ContentRowHeight(55)
@HeadRowHeight(40)
@ColumnWidth(30)
public class OnlineModelVo {
    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型编号
    private String auditModelNumber;
    //审计模型名称
    private String auditModelName;
    //审计模型业务逻辑
    private String auditModelBusinessLogic;
    private String auditBusinessLogic;
    //业务归属系统
    private String serviceOwnershipSystem;
    //模型所用数据源
    private String dataContentDescription;
    //数据起始时间
    private String accessTime;
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
    //模型代码(模型评估与已上线模型)
    private String modelCode;
    //所属系统(模型评估与已上线模型)
    private String subordinateToSystem;
    //归属专题
    private String ascriptionSpecial;
    //备注
    private String onlineRemarks;
    //录入人
    private String dockPeople;

    private String dockDepartment;


    //质量评级
    private String qualityRating;

    //运行方式
    private String runningMode;


    /**
     * 审计发现案例
     */
    //问题概要
    private String problemSummarySj;


    //问题详细描述
    private String problemDetailDescriptionSj;

    //审计期间
    private String auditPeriodSj;


    //涉及单位
    private String involvedUnitSj;

    //所属项目
    private String auditProjectSj;


    /**
     * 延伸发现案例
     */
    //问题概要
    private String problemSummaryYs;


    //问题详细描述
    private String problemDetailDescriptionYs;

    //审计期间
    private String auditPeriodYs;


    //涉及单位
    private String involvedUnitYs;

    //所属项目
    private String auditProjectYs;
}
