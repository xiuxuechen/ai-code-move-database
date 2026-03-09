package com.cxsj.mxzd.pojo.pro;


import lombok.Data;

/**
 * 订购数据
 * @Author: wzy
 * @Date: 2023/3/07 20:13
 */
@Data
public class ModelOrderngDataFacade {


    /**
     *对象英文名称
     */
    private String englishName;

    /**
     *对象中文名称
     */
    private String chineseName;

    /**
     *数据名称
     */
    private String dataName;

    /**
     *数据编码
     */
    private String assetcode;

    /**
     *接口编码
     */
    private String interid;


    /**
     * 接口名称
     */
    private String innerName;

    /**
     *申请状态
     */
    private String applicationStatus;
}
