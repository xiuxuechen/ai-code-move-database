package com.cxsj.mxzd.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 新增草稿入参
 */
@Data
public class DraftParam implements Serializable {


    /**
     * 与统一工作台绑定ID  业务表可以自行生成 或不生成  则自动生成 需与业务绑定
     */
    private String id;
    /**
     * 来源
     */
    private String sourcePlatform;

    /**
     * 标题
     */
    private String title;


    /**
     * 发起人登录id
     */
    private Object startUserId;


    /**
     * 发起人姓名
     */
    private Object startUserName;


    /**
     * 发起人副账号
     */
    private Object startDeputyAccountInfos;


    /**
     * 发起人省分id
     */
    private Object orgId;


    /**
     * 发起人省分名称
     */
    private Object orgName;


    /**
     * 发起人角色id
     */
    private String roleId;


    /**
     * 发起人角色名称
     */
    private String roleName;


    /**
     * 业务类型
     */
    private String busiType;


    /**
     * 流程定义名称
     */
    private String processDefName;


    /**
     * 修改页面地址
     */
    private String modifyUrl;


    /**
     * 发起人归属
     */
    private Object busiUnitCode;
}
