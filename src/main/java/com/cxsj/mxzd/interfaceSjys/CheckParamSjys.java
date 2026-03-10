package com.cxsj.mxzd.interfaceSjys;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckParamSjys {
    /**
     * 规定时间格式
     *
     * @return
     */
    boolean isdateVal() default false;



    String defaultVal() default "";

    /**
     * 必填
     * @return
     */
    boolean isNotNull() default false;


    /**
     * 必须为数字类型
     * @return
     */
    boolean isInteger() default true;

    /**
     * 依赖于前面字段
     * @return
     */
    String relyOn() default "";

    /**
     * 取值空间
     * @return
     */
    String relyOnValue() default "";

    /**
     * 节点对接人所对应的字段（除了模型基础信息模型名称，审计点名称 一级二级业务流程之外其余使用此注解必添加属性）
     * @return
     */
    String dockPeople() default "";

    int maxLength() default 0;


    int maxLengthNew() default 0;


    //多个字段都为空  则校验为失效
    String allIsNull() default "";


    String checkDept() default "";





}