package com.cxsj.mxzd.entity;

import lombok.Data;
import java.util.Date;

/**
 * 审计模型实体类
 */
@Data
public class AuditModel {
    private Long id;
    private String modelCode;
    private String modelName;
    private String modelType;
    private String description;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
