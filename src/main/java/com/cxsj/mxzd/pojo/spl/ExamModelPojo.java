package com.cxsj.mxzd.pojo.spl;

import lombok.Data;

import java.util.List;

@Data
public class ExamModelPojo extends ExamineandapproveParam{


    private String proId;

    /**
     * 用户信息-统一用户副账号
     */
    private String deputyAccountNumber;




    /**
     * 操作类型  1-待审批  2-待审阅
     */
    private String czType;


    private String dbType;


    /**
     * 数据归属部门
     */
    private String sjPrvd;

    /**
     * 待办待阅新增集合
     */
    private List<String> userList;

}
