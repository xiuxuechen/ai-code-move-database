/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditFindDataBase
 * Author:   DELL
 * Date:     2021/7/6 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

import java.util.Date;

/**
 *@auther hmj
 *@date 2021/7/6 16:13
 *@version 1.0  发现库内容
 */



public class AuditFindDataBase  {

    private Integer id;
    //问题概要
    private String problemSummary;
    //问题详细描述
    private String problemDescription;
    //审计时间
    private String auditTime;
    //涉及单位
    private String auditInvolved;
    //所属项目
    private String auditProject;
    //模型编号
    private String auditModelNumber;
    //创建人
    private String createPerson;
    //创建时间
    private Date createTime;
    //修改人
    private String updatePerson;
    //修改时间
    private Date updateTime;
    //是否删除
    private Integer isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblemSummary() {
        return problemSummary;
    }

    public void setProblemSummary(String problemSummary) {
        this.problemSummary = problemSummary;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditInvolved() {
        return auditInvolved;
    }

    public void setAuditInvolved(String auditInvolved) {
        this.auditInvolved = auditInvolved;
    }

    public String getAuditProject() {
        return auditProject;
    }

    public void setAuditProject(String auditProject) {
        this.auditProject = auditProject;
    }

    public String getAuditModelNumber() {
        return auditModelNumber;
    }

    public void setAuditModelNumber(String auditModelNumber) {
        this.auditModelNumber = auditModelNumber;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
