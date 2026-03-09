package com.cxsj.mxzd.pojo;

import lombok.Data;

//已上线审计模型
@Data
public class OnlineModelPojo {
    //编号
    private Integer id;
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
    //是否删除
    private String isDeleted;
    //审计模型编号
    private String auditModelNumber;
    //其他业务归属系统
    private String otherServiceOwnershipSystem;

}
