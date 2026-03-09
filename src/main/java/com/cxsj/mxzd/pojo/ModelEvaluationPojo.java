package com.cxsj.mxzd.pojo;

import lombok.Data;

//模型评估与开发实体类
@Data
public class ModelEvaluationPojo {
    //编号
    private Integer id;
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
    //是否删除
    private String isDeleted;

    //建模方式
    private String modelingMethod;

    private Boolean modelingMethodCanUpdate=true;



    //审计模型编号
    private String auditModelNumber;

    private String defExamUser;
}
