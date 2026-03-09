package com.cxsj.mxzd.pojo.spl;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HisExamineEntuty {


    /**
     * 审批编号
     */
    private String examinID;


    /**
     *  //审计点编号
     */
    private String auditPointNumber;

    /**
     * //审计点名称
     */
    private String auditPointName;

    /**
     * //审计模型编号
     */
    private String auditModelNumber;

    /**
     * //审计模型名称
     */
    private String auditModelName;



    /**
     *  //录入完成的信息类型
     */
    private String typeOfInformation;


    /**
     *  //录入人
     */
    private String dockPeople;


    /**
     *  //录入人统一用户副账号
     */
    private String dockDeputy;
    /**
     *录入人部门
     */
    private String deckDept;

    /**
     *   //填写日期
     */
    private String writeTime;


    /**
     * //1.未提交(草稿)  2.新增审核  3.修改审核  4.删除审核        5.删除审核通过  6.删除审核未通过  7.上线审核通过(已经上线)
     *      // 8.模型已经修改  9.修改审批未通过   10.上线审核未通过
     *      //当前模型的状态
     */
    private String auditModelType;


    /**
     *  //审批人
     */
    private String examineUser;



    /**
     * //是否为审批条目    0-录入事项   1-待办事项   2-待阅事项
     */
    private String isExamine;



    /**
     *   //查看详情按钮
     */
    private String isXq;

    /**
     *  //备注
     */
    private String remarks;



    //审批类型
    private String  examineType;


    private String examineResult;

    /**
     *  提交备注
     */
    private String submitRemarks;


    List<ExamHisEntuty> HisList;


    private List<Map<String,Object>> miList;
}
