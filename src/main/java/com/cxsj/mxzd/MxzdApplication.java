package com.cxsj.mxzd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * MXZD 审计系统主应用
 * 排除默认数据源自动配置，使用自定义双数据源配置
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MxzdApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MxzdApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ai-code-move-database启动成功");
    }
}
