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
 * 审计能力支撑下方数据资产管理返回实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSupportInfo {

  private String auditModelNumber;
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
  //数据支撑方(总部-省公司)
  private String dataSupporter;
  //是否使用数据资产的数据  1-使用  0-未使用
  private String isAcc;




}
