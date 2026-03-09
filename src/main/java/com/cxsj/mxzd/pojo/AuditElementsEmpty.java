package com.cxsj.mxzd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * lombok注解
 * 审计要素公共入参类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditElementsEmpty {

    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型编号:
    private String auditModelNumber;

    //审计模型名称:
    private String auditModelName;

    //备注
    private String remark;
    private String existingDataOfModel;

    private String dockPeople;
    
    private String isOnline;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date detailedTime;

    //数据支撑能力数据资产管理
    private List<DataSupportInfo> dataSupportInfo;
    //数据能力支撑-数据接入需求
    private List<DataCutInfo> dataCutInfo;

    //录入完成信息类型
    private String typeOfInformation;
    //录入人部门
    private String dockDepartment;
}
