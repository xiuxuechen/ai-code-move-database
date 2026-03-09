package com.cxsj.mxzd.pojo.pro;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * 模型基本信息数据  以及数据探索建模项目信息  以及模型界面配置 统计报表信息
 * @Author: wzy
 * @Date: 2023/3/07 20:13
 */
@Data
public class ModelBasisFacade {

    private int id;

    /**
     * 模型业务编码
     */
    @TableId
    private String modelNumber;

    /**
     * 一级流程
     */
    private String oneProcess;

    /**
     * 二级流程
     */
    private String twoProcess;


    /**
     * 一级流程ID
     */
    private String oneProcessId;

    /**
     * 二级流程ID
     */
    private List<String> twoProcessId;



    /**
     *审计点名称
     */
    @NotBlank(message = "审计模型名称不能为空！")
    @Size(max = 100,message = "审计模型名称最大长度为100！")
    private String autoPointName;

    /**
     *审计模型名称
     */
    @NotBlank(message = "审计点名称不能为空！")
    @Size(max = 100,message = "审计点名称最大长度为100！")
    private String autoModelName;

    /**
     *模型业务逻辑
     */
    @Size(max = 500,message = "模型业务逻辑最大长度为500！")
    private String auditModelBusinessLogic;


    /**
     * 模型执行逻辑
     */
    private String executionLogic;

    /**
     *数据所属系统
     */
    @Size(max = 100,message = "数据所属系统最大长度为100！")
    private String dataToSystem;


    /**
     * 预期审计发现
     */
    private String expectedAuditFind;


    private String businessArea;


    private String sourceDomain;


    /**
     * 建模方式
     * zj-自建      dg-订购
     */
    private String modelingType="zj";


    /**
     *建模人
     */
    private String autoPeople;

    /**
     *建模人部门
     */
    private String autoDept;


    private String mxzdModelUrl;



    private String mxzdModelNumber;

    /**
     * 深度分析云项目ID
     */
    private String projectId;


    /**
     * 深度分析云项目名称
     */
    private String projectName;


    /**
     * 统计报表ID
     */
    private String reportId;


    /**
     * 统计报表名称
     */
    private String reportName;

    /**
     * 模型状态   0-建设中 1-已经完成
     */
    private Integer modelType;



    /**
     * 建模步骤 1-模型基础信息  2-查看订购数据  3-数据探索建模 4-模型界面配置
     */
    private Integer modelingSteps;

    private String orderDataMsg;


    /**
     * 是否可以删除
     */
    private boolean canDel=true;


    private String modelCode;

}
