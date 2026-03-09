package com.cxsj.mxzd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 对接统一工作台---发起流程实体类入参
 */
@Data
public class StartFlowParm implements Serializable {


    private String id;


    /**
     *来源
     */
    private Object   sourcePlatform ;

    /**
     *标题
     */
    private Object  title;



    /**
     * 发起人登录id
     */
    private Object startUserId;


    /**
     * 发起人姓名
     */
    private Object startUserName;


    /**
     * 发起人角色
     */
    private Object roleName;


    /**
     * 发起人副账号
     */
    private Object startDeputyAccountInfos;


    private String startDept;

    /**
     *业务类型
     */
    private Object  busiType;
    /**
     *下一节点审批人登录id
     */
    private Object  nextLoginId;
    /**
     *下一节点审批人姓名
     */
    private Object nextLoginName;
    /**
     *下一节点审批人副账号
     */
    private Object  nextDeputyAccountInfos;
    /**
     *流程定义名称
     */
    private Object   processDefName;


    /**
     *流程实例名称
     */
    private Object   processInstName;


    /**
     *下一节点省分id
     */
    private Object   nextOrgId;
    /**
     *下一节点省分名称
     */
    private Object    nextOrgName;
    /**
     *下一节点角色id
     */
    private Object    nextRoleId;
    /**
     *下一节点角色名称
     */
    private Object   nextRoleName ;
    /**
     *审核意见
     */
    private Object   verifyMemo ;
    /**
     *当前环节说明
     */
    private Object   currentPhaseMemo ;
    /**
     *审批页面地址
     */
    private Object   verifyUrl ;

    /**
     *详情页面地址
     */
    private Object   detailUrl ;


    /**
     *草稿id
     */
    private Object   draftId  ;


    /**
     *审批页面地址(MOA)
     */
    private Object   mobileVerifyUrl ;


    /**
     *详情页面地址(MOA)
     */
    private Object   mobileDetailUrl ;


}
