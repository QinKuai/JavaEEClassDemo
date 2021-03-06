package com.qinkuai.webservice.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.qinkuai.core.dao.DataBaseCP;

/**
 * @author QinKuai
 * 创建时间：2020年3月26日
 * 描述：
 * springmvc的基本配置
 * Java代码配置
 * 等效于以前springmvc的xml配置
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.qinkuai.webservice.service", "com.qinkuai.webservice.aspect", "com.qinkuai.webservice.util"})
public class WebConfig implements WebMvcConfigurer{
	/**
	 * 描述：
	 * 配置HTML的视图解析器
	 * 必定要配置的Bean
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/webapp/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	/**
	 * 描述：
	 * 静态资源的处理
	 * 必定要配置的方法
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/**
	 * 描述：
	 * 解决返回的JSON中文乱码问题
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter httpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
		converters.add(httpMessageConverter);
		//WebMvcConfigurer.super.configureMessageConverters(converters);
	}
	
	/**
	 * 描述：
	 * 配置静态资源的访问路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/js/**").addResourceLocations("WEB-INF/webapp/js/");
		registry.addResourceHandler("/static/css/**").addResourceLocations("WEB-INF/webapp/css/");
		registry.addResourceHandler("/static/image/**").addResourceLocations("WEB-INF/webapp/image/");
		//WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	/**
	 * 描述：
	 * 配置校验Bean
	 * 启动Springmvc的校验机制
	 */
	@Override
	public Validator getValidator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(DataBaseCP.getConnectionPool());
	}
}
