package com.cxsj.largemodel.facade;

import lombok.Data;

/**
 * 制度库对接智能顾问知识库入参
 */
@Data
public class InstitutionalKnowlEdgebaseFacade {


    private String kmId;


    public Integer index;

    /**
     * 制度Id
     */
    private String insId;


    /**
     * 制度名称
     */
    private String insName;


    /**
     * 制度文件名称
     */
    private String insFileName;


    /**
     * 制度文件类别
     */
    private String insFileType;


    /**
     * 制度文件ftp路径
     */
    private String insFileFtpPath;


    /**
     * 制度径文件本地路
     */
    private String insFileDicPath;


    private Integer externalId;



    /**
     * 制度归属部门Id
     */
    private String insDeptId;


    /**
     * 制度归属部门名称
     */
    private String insDeptName;


    /**
     * 数据权限
     */
    private String dataAuthority;
}
