package com.cxsj.mxzd.pojo;


import lombok.Data;


/**
 * 审批流程入参
 */
@Data
public class AuditFlowParam {

    /**
     * 流程id
     */
    private Object proId;


    /**
     * 下一节点审批人登录id
     */
    private Object nextLoginId;


    /**
     * 下一节点审批人姓名
     */
    private Object nextLoginName;


    /**
     * 下一节点审批人副账号
     */
    private Object nextDeputyAccountInfos;


    /**
     * 下一节点角色id
     */
    private Object nextRoleId;


    /**
     * 下一节点角色名称
     */
    private Object nextRoleName;


    /**
     * 审核意见
     */
    private Object verifyMemo;


    /**
     * 当前环节说明
     */
    private Object currentPhaseMemo;


    /**
     * 审批页面地址
     */
    private Object verifyUrl;


    /**
     * 审批页面地址(MOA)
     */
    private Object mobileVerifyUrl;


    /**
     * 设置相关路径和值
     * （跳转）
     */
    private Object reladatas;


}
