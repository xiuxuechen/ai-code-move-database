package com.cxsj.mxzd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok注解
 * 审计要素公共入参类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditElementIsNotEmpty {

    private String id;
    private String auditModelNumber;
    //备注
    private String remark;
    //是否满足
    private String existingDataOfModelId;

    private Integer isdel;

}
