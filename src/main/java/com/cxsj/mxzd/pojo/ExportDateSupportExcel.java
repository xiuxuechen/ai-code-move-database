package com.cxsj.mxzd.pojo;


import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

/**
 * 数据支撑能力导出实体类
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(15)
public class ExportDateSupportExcel {


    //审计点编号

    private String auditPointNumber;
    //审计点名称

    private String auditPointName;
    //审计模型编号:

    private String auditModelNumber;

    //审计模型名称:

    private String auditModelName;
    //数据内容描述
    private String dataContentDescription;
    //数据范围
    private String scopeOfData;
    //数据归属域
    private String dataDomain;
    //数据接入来源
    private String dataAccessSource;
    //数据归属系统
    private String dataAttributionSystem;
    //数据接入时间
    private String dataAccessTime;
    //数据留存周期
    private String dataRetentionCycle;
    //是否结构化数据(1-是0-否)返回值是String入参是String
    private String structuredDataNot;

    //是否结构化数据(1-是0-否)返回值是String入参是String
    private String structuredDataNotId;

    //现有数据是否满足模型要求(1-是0-否-1部分满足)返回值是String入参是String
    private String existingDataOfModel;

    //现有数据是否满足模型要求(1-是0-否-1部分满足)
    private String existingDataOfModelId;

    //备注
    private String remark;

    //数据内容描述(数据接入需求)
    private String dataContentDescriptionXq;
    //涉及系统
    private String involvedSystem;
    //数据范围(数据接入需求)
    private String scopeOfDataXq;

    //数据支撑方
    private String dataSupporter;

    private Integer id;
    //数据编码
    private String assetCode;
    //对象英文名
    private String dataCode;
    //对象中文名
    private String name;
    //来源系统编码
    private String originalSystemcode;
    //来源系统
    private String originalSystem;
    //接口编码
    private String interId;
    //接口名称
    private String interName;
    //所属层
    private String objLevelCode;
    //业务分类
    private String busiType;
    //数据状态
    private String dataStatus;
    //是否使用数据资产的数据  1-使用  0-未使用
    private String isAcc;

    //数据接口名称
    private String dataInterfaceName;
    //录入人
    private String dockPeople;

    private String dockDepartment;
}
