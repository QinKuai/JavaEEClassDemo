package com.qinkuai.webservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author QinKuai
 * 创建时间：2020年3月26日
 * 描述：
 * 等效于spring的xml配置
 */
@Configuration
@ComponentScan(excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
	
}
