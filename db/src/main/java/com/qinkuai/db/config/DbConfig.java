package com.qinkuai.db.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author QinKuai 创建时间：2020年5月21日 描述：数据源相关配置
 */
@Configuration
@MapperScan("com.qinkuai.db.dao")
public class DbConfig {
	@Value("${spring.datasource.username}")
	private String dsUsername;
	@Value("${spring.datasource.password}")
	private String dsPassword;
	@Value("${spring.datasource.url}")
	private String dsURL;
	@Value("${spring.datasource.driver-class-name}")
	private String dsDriver;

	/**
	 * 配置数据源
	 */
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setUsername(dsUsername);
		hikariConfig.setPassword(dsPassword);
		hikariConfig.setJdbcUrl(dsURL);
		hikariConfig.setDriverClassName(dsDriver);
		return new HikariDataSource(hikariConfig);
	}

	/**
	 * 事务Bean
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * 配置Mybatis数据源及Mapper映射
	 */
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception{
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource());
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
//		
//		return sessionFactoryBean.getObject();
//	}
}
