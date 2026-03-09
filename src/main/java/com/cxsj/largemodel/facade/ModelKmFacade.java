package com.cxsj.largemodel.facade;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author wzy
 * @describe 模型库实体类
 * @data 2025/3/10-16:02
 */
@Data
public class ModelKmFacade {

    // 审计模型设计 - 模型基础信息
    @ExcelProperty(value = "审计模型编号")
    private String auditModelNumber;

    @ExcelProperty(value = "审计模型名称")
    private String auditModelName;

    @ExcelProperty(value = "一级业务流程")
    private String primaryBusinessProcess;

    @ExcelProperty(value = "二级业务流程")
    private String secondaryBusinessProcess;

    @ExcelProperty(value = "审计模型执行逻辑")
    private String auditModelExecutionLogic;

    private String writeTime;

    // 数据支撑能力 - 数据资产数据与模型是一对多关联
    @ExcelProperty(value = "对象中文名称")
    private String dataAssetObjectNameCN;

    @ExcelProperty(value = "对象英文名称")
    private String dataAssetObjectNameEN;

    @ExcelProperty(value = "数据编码")
    private String dataAssetCode;

    @ExcelProperty(value = "数据状态")
    private String dataAssetStatus;

    @ExcelProperty(value = "来源系统")
    private String dataAssetSourceSystem;

    @ExcelProperty(value = "接口名称")
    private String dataAssetInterfaceName;

    // 数据支撑能力 - 非数据资产数据与模型是一对多关联
    @ExcelProperty(value = "数据来源")
    private String nonDataAssetDataSource;



    @ExcelProperty(value = "对象中文名称")
    private String nonDataAssetObjectNameCN;

    @ExcelProperty(value = "对象英文名称")
    private String nonDataAssetObjectNameEN;

    @ExcelProperty(value = "数据编码")
    private String nonDataAssetCode;

    @ExcelProperty(value = "数据状态")
    private String nonDataAssetStatus;

    @ExcelProperty(value = "来源系统")
    private String nonDataAssetSourceSystem;

    @ExcelProperty(value = "接口名称")
    private String nonDataAssetInterfaceName;

    // 审计模型部署 - 模型部署信息与模型是一对一关联
    @ExcelProperty(value = "模型状态")
    private String deploymentModelState;

    @ExcelProperty(value = "模型代码")
    private String deploymentModelCode;

    @ExcelProperty(value = "填写时间")
    private String deploymentModelCodeFileId;

    @ExcelProperty(value = "模型状态")
    private String deploymentModelingMethod;

    // 审计模型部署 - 模型线索信息与模型是一对多关联
    @ExcelProperty(value = "模型代码")
    private String clueModelSupportParty;

    @ExcelProperty(value = "审计周期")
    private String clueAuditCycle;

    @ExcelProperty(value = "每月告警时间")
    private String clueMonthlyAlarmTime;

    @ExcelProperty(value = "审计月")
    private String clueAuditMonth;

    @ExcelProperty(value = "数据月")
    private String clueDataMonth;

    @ExcelProperty(value = "审计线索编码")
    private String clueAuditCode;

    @ExcelProperty(value = "审计线索名称")
    private String clueAuditName;

    @ExcelProperty(value = "线索类型")
    private String clueType;

    @ExcelProperty(value = "审计线索单位")
    private String clueAuditUnit;

    @ExcelProperty(value = "被审计单位编码")
    private String clueAuditedUnitCode;

    @ExcelProperty(value = "被审计单位")
    private String clueAuditedUnit;

    @ExcelProperty(value = "线索量")
    private String clueQuantity;

    @ExcelProperty(value = "线索量占比")
    private String clueQuantityRatio;

    @ExcelProperty(value = "线索量排名")
    private String clueQuantityRank;
}