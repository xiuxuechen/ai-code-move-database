package com.cxsj.mxzd.pojo;


import lombok.Data;


@Data
public class SendBackParam {



    private Object proId;


    /**
     * 业务类型
     */
    private Object busiType;


    /**
     * 详情页地址
     */
    private Object detailUrl;


    /**
     * 详情页面地址(MOA)
     */
    private Object mobileDetailUrl;





}
