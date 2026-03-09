package com.cxsj.largemodel.facade;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王志宇
 * @date 2024/4/19
 * @description TODO
 */
@Data
public class KmTreeFacade {

    private String kmId;


    private String kmName;

    //是否选择
    private Boolean isChoice = false;


    private List<KmTreeFacade> childKmList;




}