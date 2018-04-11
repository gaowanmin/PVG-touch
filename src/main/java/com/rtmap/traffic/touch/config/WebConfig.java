package com.rtmap.traffic.touch.config;

import com.rtmap.traffic.touch.filter.PvgLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * webConfig
 * @author xuhailong
 * @Date 2017/3/13
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置日志filter
     */
    @Bean
    public FilterRegistrationBean registerPvgLogFilter() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new PvgLogFilter());

        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/flt/*");
        urlPatterns.add("/airportService/*");
        urlPatterns.add("/monitor/*");
        urlPatterns.add("/question/*");
        urlPatterns.add("/traffic/*");
        urlPatterns.add("/weather/*");

        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);

        return registrationBean;
    }

    /**
     * 配置跨域访问
     */
    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowCredentials(true);
            }
        };
    }

}
