package com.cxsj.mxzd.pojo;

import lombok.Data;



/**
 * 退回到发起人
 */
@Data
public class SendStartParam {


    private Object proId;

    private String workId;

    private String nowCategory;

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
     * 下一节点角色id
     */
    private Object nextRoleId;

    /**
     * 下一节点角色名称
     */
    private Object nextRoleName;


    /**
     * 审批页面地址(MOA)
     */
    private Object mobileVerifyUrl;

}

