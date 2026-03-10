package com.cxsj.common.dto;

import lombok.Data;
import java.util.List;

@Data
public class ModelOrderParam {
    private String business1Name;
    private String business2Name;
    private String auditPointName;
    private String modelName;
    private String modelNumber;
    private String auditBusinessLogic;
    private String executionLogic;
    private String dataToSystem;
    private String businessArea;
    private String sourceDomain;
    private String expectedAuditFind;
    private String modelCode;
    private String modelCodeFileId;
    private String autoDeputy;
    private String autoPeople;
    private String autoDeptId;
    private String autoDeptName;
    private List<DataAssetsParam> dataAssetsParams;
}
