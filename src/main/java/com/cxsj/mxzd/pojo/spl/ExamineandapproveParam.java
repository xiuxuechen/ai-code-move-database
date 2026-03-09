package com.cxsj.mxzd.pojo.spl;


import lombok.Data;

@Data
public class ExamineandapproveParam {

    private String auditModelNumber;

    private String examinID;


    private String workId;

    private String examineId;

    private String source;

    private String dyId;

    private String dbId;

    private String sptype;   //三种审批方式：  1.新增       2.修改  3.删除


    private String remarks;      // 计模型若走审批则需要添加备注信息

    private String result;       //审批结果 ，修改或者删除，  1代表确认审批通过   0代表为未通过


    private String time;  //提交时间

    private  String[] auditModelNumbers=new String[]{};

    private String defExamUser;

    private String def2ExamUserDepy;


    private String isOnlineAndShare;

    private String examineCategory;

    private String inclusionZb;

    private String onlineType;


}
