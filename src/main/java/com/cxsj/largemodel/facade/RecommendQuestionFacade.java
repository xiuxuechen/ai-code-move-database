package com.cxsj.largemodel.facade;

import lombok.Data;

/**
 * @author 王志宇
 * @className RecommendQuestionFacadee
 * @date 2024/8/21
 * @description TODO
 */
@Data
public class RecommendQuestionFacade {


    private String title;
    private String desc;
    private String logo;


    public RecommendQuestionFacade(String title, String desc, String logo) {
        this.title = title;
        this.desc = desc;
        this.logo = logo;
    }
}