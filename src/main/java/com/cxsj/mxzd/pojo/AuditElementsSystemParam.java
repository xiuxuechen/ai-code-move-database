package com.cxsj.mxzd.pojo;

import lombok.Data;

/**
 * 制度库等信息
 */
@Data
public class AuditElementsSystemParam {
    //模型编号
    private String auditModelNumber;
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

}
