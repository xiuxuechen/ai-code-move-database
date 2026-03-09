package com.cxsj.sup.entity.process;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wzy
 * @describe todo
 * @data 2025/6/16-11:45
 */
@Data
public class ProBringOneEntity {

    private Integer id;

    private String proId;


    private String modelNumber;


    private String doesInvolveDigitalNumber;


    private String digitalNumber;


    private String operationUnit;


    private Integer evaluationTableId;

    //文件名
    private String evaluationTableFileName;


    //文件下载路径
    private String evaluationTableFilePath;

    private String evaluationTableFileShowPath;


    private String applyReason;

    private String status;

    private String createUser;

    private LocalDateTime createTime;

    private String updateUser;

    private LocalDateTime updateTime;
}
