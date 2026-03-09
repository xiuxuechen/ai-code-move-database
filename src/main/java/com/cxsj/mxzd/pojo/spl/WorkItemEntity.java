package com.cxsj.mxzd.pojo.spl;


import lombok.Data;

import java.util.Date;

@Data
public class WorkItemEntity {

    private String workId;

    private String examineId;

    private String roleName;

    private String deptName;

    private String opeType;

    private String opeUser;

    private String opeUserId;

    private Date opeTime=null;

    private String nextUserId;

    private String nextUser;

    private String reolyType;

    private String reolyRemarks;


}
