package com.rtmap.traffic.touch.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhailong
 * @Date 2017/3/9
 */
@Configuration
@EnableConfigurationProperties(value = JDBCProperties.class)
public class DataSourceConfiguration {

    @Resource
    JDBCProperties jdbcProperties;

    @Bean
    public DataSource getDataSource(Slf4jLogFilter slf4jLogFilter){
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(jdbcProperties.getDriver());
        druidDataSource.setUrl(jdbcProperties.getUrl());
        druidDataSource.setUsername(jdbcProperties.getUsername());
        druidDataSource.setPassword(jdbcProperties.getPassword());

        /**配置初始化大小、最小、最大*/
        druidDataSource.setInitialSize(jdbcProperties.getInitialSize());
        druidDataSource.setMinIdle(jdbcProperties.getMinIdle());
        druidDataSource.setMaxActive(jdbcProperties.getMaxActive());

        /**配置获取连接等待超时的时间*/
        druidDataSource.setMaxWait(30000);

        /**配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒*/
        druidDataSource.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());

        /**配置一个连接在池中最小生存的时间，单位是毫秒*/
        druidDataSource.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(jdbcProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(jdbcProperties.isTestOnReturn());

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(slf4jLogFilter);
        druidDataSource.setProxyFilters(filters);

        return druidDataSource;
    }

    @Bean
    public Slf4jLogFilter slf4jLogFilter(){
        Slf4jLogFilter filter = new Slf4jLogFilter();
        filter.setStatementExecutableSqlLogEnable(true);
        return filter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
