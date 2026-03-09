package com.cxsj.mxzd.pojo;

import lombok.Data;

/**
 * packageName com.cxsj.mxzd.pojo
 *
 * @author 王志宇
 * @className AuditElementCaseEntity (此处以class为例)
 * @date 2024/5/29
 * @description TODO
 */
@Data
public class AuditElementCaseEntity {

    private Integer id;

    private String auditModelNumber;

    //问题详细描述
    private String problemDetailDescription;

    //问题概要
    private String problemSummary;


    private String auditPeriod;

    private String involvedUnit;

    private String auditProject;

    //审计发现案例-1 延伸发现案例--2
    private Integer type;

    private Integer order;


}