package com.cxsj.mxzd.pojo.exportParam;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@ContentRowHeight(55)
@HeadRowHeight(40)
@ColumnWidth(30)
public class ModelEvaluationExportVo {
    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型编号
    private String auditModelNumber;
    //审计模型名称
    private String auditModelName;
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
    private String modelCode;
    //模型状态
    private String modelState;
    //建模方式
    private String modelingMethod;
    //所属系统(模型评估与已上线模型)
    private String subordinateToSystem;

    private String isSyn;
    private String synUrl;
    //录入人
    private String dockPeople;

    private String dockDepartment;

    //是否纳入总部模型库
    private String offModelLibrary;
}
