/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditFindDataBase
 * Author:   DELL
 * Date:     2021/7/6 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 审计能力支撑下方数据资产管理返回实体类-数据接入需求
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportInCutInfo {

    private Integer id;
    //support表的主键
    private Integer suppId;
    //cut表的主键
    private Integer cutId;
    //审计模型编号
    private String auditModelNumber;


}
