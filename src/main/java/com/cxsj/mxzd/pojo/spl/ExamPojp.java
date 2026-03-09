package com.cxsj.mxzd.pojo.spl;

import lombok.Data;


/**
 * 审批状态表实体类
 */
@Data
public class ExamPojp {

    private String dbId;
    /**
     * 审批ID
     */
    private String examId;

    /**
     * 审计模型编号
     */
    private String auditModelNumber;

    /**
     * 提交人
     */
    private String submitUser;

    /**
     * 提交人统一用户副账号
     */
    private String submitUserDepy;

    /**
     * 提交时间
     */
    private String writeTime;

    /**
     * 提交备注
     */
    private String submitRemarks;


    private String workId;

    /**
     * 审批人
     */
    private String examineUser;

    /**
     * 审批人统一用户副账号
     */
    private String examineUserDepy;

    /**
     * 审批人部门
     */
    private String examineUserDept;

    /**
     * 审批时间
     */
    private String examineTime;

    /**
     * 审批类型1代表上线审核，2代表修改审核，3代表删除审批
     */
    private String examineType;

    /**
     * 审批结构   1代表审批通过，0代表审批未通过
     */
    private String examineResult;


    private String examineCategory;


    private String nowCategoty;


    private String onlineShare;


    private String inclusionZb;
}
