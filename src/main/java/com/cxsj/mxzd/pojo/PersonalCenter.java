package com.cxsj.mxzd.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalCenter {
    //审计点编号
    private String auditPointNumber;
    //审计点名称
    private String auditPointName;
    //审计模型编号
    private String auditModelNumber;
    //审计模型名称
    private String auditModelName;
    //信息类型
    private String informationType;
    //录入完成的信息类型
    private String typeOfInformation;
    //状态
    private String status;
    //录入人
    private String dockPeople;
    //录入人电话
    private String dockPhone;
    //录入人部门
    private String dockDepartment;
    //填写日期
    private String writeTime;
    //继续录入的阶段
    private String continueToEnter;
    //继续编辑
    private String currentInput;
    //是否为导入
    private String isImport;

    //模型负责人
    private String modelOwner;


    private String modelOwnerDepy;

    private String defExamUser;

    private String defExamUserDept;

    private String def2ExamUser;

    private String def2ExamUserDepy;

    //模型共享审批人员
    private String shareUser;


    private String shareUserDepy;

    private String dockDeputyAccountNumber;


    private String onlineType;

}
