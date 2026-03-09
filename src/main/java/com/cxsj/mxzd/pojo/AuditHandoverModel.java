/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuditHandoverModel
 * Author:   DELL
 * Date:     2021/7/6 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cxsj.mxzd.pojo;

/**
 *@auther hmj
 *@date 2021/7/6 16:27
 *@version 1.0 审计模型来源信息
 */

import java.util.Date;
public class AuditHandoverModel {

    private Integer id;
    private String auditPoint;//审计点
    private String auditProspectivePoint;//预期审计发现
    private String auditSystemName;//'审计依据制度名称'
    private String auditSystemContent;//'审计依据制度内容'
    private String auditConfirmationFindings;//'审计发现现场确认情况'
    private String auditModelNameSend;//'模型名称'
    private String auditModelLogic;//'模型逻辑'
    private String auditModelNumber;//'模型编号'
    private String createPerson;//'创建人'
    private Date createTime;//'创建时间'
    private String updatePerson;//修改人
    private Date updateTime;//'更新时间'
    private Integer isdel;//是否删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuditPoint() {
        return auditPoint;
    }

    public void setAuditPoint(String auditPoint) {
        this.auditPoint = auditPoint;
    }

    public String getAuditProspectivePoint() {
        return auditProspectivePoint;
    }

    public void setAuditProspectivePoint(String auditProspectivePoint) {
        this.auditProspectivePoint = auditProspectivePoint;
    }

    public String getAuditSystemName() {
        return auditSystemName;
    }

    public void setAuditSystemName(String auditSystemName) {
        this.auditSystemName = auditSystemName;
    }

    public String getAuditSystemContent() {
        return auditSystemContent;
    }

    public void setAuditSystemContent(String auditSystemContent) {
        this.auditSystemContent = auditSystemContent;
    }

    public String getAuditConfirmationFindings() {
        return auditConfirmationFindings;
    }

    public void setAuditConfirmationFindings(String auditConfirmationFindings) {
        this.auditConfirmationFindings = auditConfirmationFindings;
    }

    public String getAuditModelName() {
        return auditModelNameSend;
    }

    public String getAuditModelNameSend() {
        return auditModelNameSend;
    }

    public void setAuditModelNameSend(String auditModelNameSend) {
        this.auditModelNameSend = auditModelNameSend;
    }

    public String getAuditModelLogic() {
        return auditModelLogic;
    }

    public void setAuditModelLogic(String auditModelLogic) {
        this.auditModelLogic = auditModelLogic;
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
