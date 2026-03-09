package com.cxsj.mxzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * MXZD 审计系统主应用
 * 排除默认数据源自动配置，使用自定义双数据源配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MxzdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MxzdApplication.class, args);
    }

}
