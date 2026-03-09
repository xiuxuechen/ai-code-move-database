package com.cxsj.mxzd.pojo.spl;

import lombok.Data;

import java.util.ArrayList;

/**
 * 批量审批 批量审阅实体
 * wzy
 * 2022.10.8  11:35
 */
@Data
public class ExamParam {
    /**
     * 操作类型  1-审批  2-审阅
     */
    private String czType;

    /**
     * 审批类型 1-通过 2-不通过
     */
    private String examResult;


    /**
     * 审批时间
     */
    private String examTime;

    /**
     * 审批ID集合
     */
    private ArrayList<Object> ids;


    /**
     * 说明
     */
    private String remarks;
}
