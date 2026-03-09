package com.cxsj.mxzd.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * PostgreSQL 数据源配置（主数据源）
 */
@Configuration
@MapperScan(
    basePackages = "com.cxsj.mxzd.mapper.pg",
    sqlSessionFactoryRef = "postgresSqlSessionFactory"
)
public class PostgresDataSourceConfig {

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgresSqlSessionFactory")
    public SqlSessionFactory postgresSqlSessionFactory(
            @Qualifier("postgresDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/pg/*.xml")
        );
        return bean.getObject();
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public DataSourceTransactionManager postgresTransactionManager(
            @Qualifier("postgresDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "postgresSqlSessionTemplate")
    public SqlSessionTemplate postgresSqlSessionTemplate(
            @Qualifier("postgresSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
