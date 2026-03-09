package com.cxsj.mxzd.pojo.pro;



import lombok.Data;

import java.util.List;

/**
 * 模型列表下拉框数据
 * @Author: wzy
 * @Date: 2023/3/07 20:13
 */
@Data
public class AutoModelMsgParam {


    private String source;


    /**
     * 模型基本信息  深度分析云项目信息  模型界面配置信息
     */
    private ModelBasisFacade modelBasisMsg;


    /**
     * 订购数据信息集合
     */
    private List<ModelOrderngDataFacade> autoOrderngDataMsg;



}
