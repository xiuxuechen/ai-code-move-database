package com.cxsj.mxzd.pojo;


import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.util.Map;

@Data
public class MaintenMsgParam {



    /**
     * 审计模型编号
     */

    private String auditModelNumber;


    /**
     * 是否上传到超市
     */
    @NotBlank(message = "isOnlineSup cannot be null")
    private String isOnlineSup;

    /**
     * 上线超市的url
     */
    private String onlineSupUrl;


    private String businessAre;




    /**
     * 来源域
     */
    private String sourceDomain;


    /**
     * 二级业务域
     */
    private String secondaryField;


    /**
     *该审计点的菜单ID(menuId)
     */
    private String  menuId;
    /**
     *该审计点的菜单ID(menuName)
     */
    private String  menuName;
    /**
     *模型评价跳转的code值（auditCode）
     */
    private String  auditCode;
    /**
     *模型评价跳转的code值（auditCode）
     */
    private String  cmwaExportPath;
    /**
     *持续审计文件类型（cmaca_fule_type）
     */
    private String  cmcaFileType;
    /**
     *持续审计专题编码（cmca_subject_id）
     */
    private String  cmcaSubjectId;
    /**
     *持续审计专题编码（cmca_subject_id）
     */
    private String  sourceCode;
    /**
     *版本标识（version
     */
    private String  version;
    /**
     *远程审计是否为我侧（belong_cmwa）  1-是   0-否
     */
    private String  belongCmwa;
    /**
     *下载按钮是否置灰（allow_down）   1-是   0-否
     */
    private String  allowDown;


    /**
     * 厂商标识
     */
    private String sourcePlatForm;


    /**
     * 三分类结果 1类：模型有效、2类：模型待优化、3类：模型拟下线
     */
    private String threeGroupResult;


    /**
     * 二级分类
     */
    private String subjectSecondClass;


}
