package com.qinkuai.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author QinKuai
 * 创建时间：2020年5月21日
 * 描述：
 * 配置Spring相关Bean
 */
@Configuration
@PropertySource("classpath:application.properties")
@Import(DbConfig.class)
public class RootConfig {

}
