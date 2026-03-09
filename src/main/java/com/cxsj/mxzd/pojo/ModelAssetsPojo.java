package com.cxsj.mxzd.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ModelAssetsPojo {
    private String primaryBusinessProcess;
    private String secondaryBusinessProcess;
    private String auditModelNumber;
    private String auditModelName;
    private String sourcesAuditPractice;
    private String auditPointNumber;
    private String auditPointName;
    private List<AssetsPojo> assets;
}
