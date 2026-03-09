package com.cxsj.mxzd.pojo;


import lombok.Data;

import java.util.List;


/**
 * 发起待阅参数
 */
@Data
public class CreateNotificationParam {

    /**
     * 通知ID   为用户信息 每个元素为 统一用户副账号,待阅ID
     */
    private List<String> userList;


    /**
     * 通知内容
     */
    private String content;


    /**
     * 流程ID
     */
    private Object processInstId;




    /**
     * 待阅地址
     */
    private String detailUrl;
}
