package com.cxsj.mxzd.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ModelEvaluateParam {
    //id
    private Integer id;
    //评价id
    private String evaluateId;
    //数据源评价分数
    private int dataSourceEvaluateScore;
    //数据源评价描述
    private String dataSourceEvaluateDescribe;
    //模型逻辑分数
    private int modelLogicScore;
    //模型逻辑分数描述
    private String modelLogicScoreDescribe;
    //规则依据评价分数
    private Integer accordingScore;

    //规则依据评价描述
    private String accordingScoreDescribe;
    //审计结果评价
    private int auditResultScore;
    //审计结果评价结果描述
    private String auditResultScoreDescribe;

    //模型评价分数
    private int modelAllEvaluateScore;
    //模型评价分数结论
    private String modelAllEvaluateScoreDescribe;
    //审计模型编号
    private String auditModelId;
    //审计模型名称
    private String auditModelName;
    //一级业务流程
    private String primaryBusinessProcess;
    //二级业务流程
    private String secondaryBusinessProcess;
    //审计实务来源
    private String sourcesOfAuditPractice;
    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型
    private String auditModel;
    //评价人
    private String appraiserPeople;
    //评价时间
    private String appraiserTime;

    //模型整体评价附件名称
    private String accessoryFileName;


    //审计实务来源
    private String source;
    //审计点名称
    private String auditpointNo;
    //审计模型名称
    private String modelNo;

    //附件类型，判断是哪一个评价的附件
    private String fileType;
    //数据源附件
    private String dataSourceFile;
    //模型逻辑附件
    private String modelLogicFile;
    //规则依据附件
    private String accordingFile;
    //审计结果附件
    private String auditResultFile;

    //国信审计点id
    private String boncAuditPoint;



    //国信审计点id
    private String dataSource;//数据源评价附件
    private String modelLogic;//模型逻辑
    private String accordingSource;//规则依据
    private String auditResult;//审计结果
    private String modelAll;//模型整体评价

    //用户名称
    private String userName;
    //用户身份标识
    private Integer userFlag;

    //当前页
    private Integer  curPage;
    //每页条数
    private Integer  pageSize;

    private Integer start;
    private Integer end;

    private String modelName;

    //审计库定义的参数名称：一级业务流程
    private String business1;
    //审计库定义的参数名称：二级业务流程
    private String business2;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //导出数据id集合
    private List<String> evaluateIdList;
    //定义是否全部导出
    private String downList;

    /**
     * 模型评价类型
     */
    private String evaluateType;
    /**
     * 模型评价子类型
     */
    private String evaluateChildType;


    /**
     * 适用范围评价分数
     */
    private int applicableScopeScore;

    /**
     * 适用范围评价描述
     */
    private String applicableScopeDescribe;

    /**
     * 适用范围评价附件
     */
    private String applicableScopeFile;


    /**
     * 业务价值评价分数
     */
    private int businessValueScore;
    /**
     * 业务价值评价描述
     */
    private String businessValueDescribe;
    /**
     * 业务价值评价附件
     */
    private String businessValueFile;


    /**
     * 附件上传时间
     */
    private String upFileTime;

    /**
     * 上传单位
     */
    private String provName;


    /**
     * 上传ID
     */
    private String provId;

    /**
     * 上传人
     */
    private String upPeople;

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件id集合
     */
    private List<Integer> idList;

    /**
     * 文件在ftp的路径
     */
    private String fileFtpPath;
}
