/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditElementSheetPojo
 * Author:   DELL
 * Date:     2021/7/9 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

/**
 *@auther hmj
 *@date 2021/7/9 9:30
 *@version 1.0 综合查询
 */
@Data
@ContentRowHeight(55)
@HeadRowHeight(40)
@ColumnWidth(30)
public class AuditElementSheetPojo {

    //审计模型编号
    private String auditPointNumber;


    //审计点名称
    private String auditPointName;


    //审计模型编号
    private String auditModelNumber;


    //审计模型名称
    private String auditModelName;


    //来源
    private String informationSources;


    //备注
    private String remark;


    //问题概要
    private String problemSummary;



    //问题详细描述
    private String problemDescription;


    //审计期间
    private String auditTime;


    //涉及单位
    private String auditInvolved;



    //所属项目
    private  String auditProject;



    //审计关注点
    private String auditPoint;



    //预期审计发现
    private String auditProspectivePoint;


    //审计依据制度名称
    private  String auditSystemName;


    //审计依据制度内容
    private String auditSystemContent;



    //审计发现现场确认情况
    private String auditConfirmationFindings;


    //模型名称
    private String auditModelNameSend;



    //模型逻辑
    private String auditModelLogic;


    //对接人
    private String dockPeople;

    private String dockDepartment;
    
    //共享单位
    private String shareUnit;
    
    //二级库模型编码
    private String secondModelNumber;
    
    
    
    
}
