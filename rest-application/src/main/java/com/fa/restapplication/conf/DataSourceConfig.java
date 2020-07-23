package com.fa.restapplication.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@PropertySource("classpath:config.properties")
@Configuration
public class DataSourceConfig {
	
	@Autowired
    Environment env;

	

	@Bean(name="dataSource")
	public DataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("app.datasource.driver"));
		dataSource.setUrl(env.getProperty("app.datasource"));
		dataSource.setUsername(env.getProperty("app.database.user"));
		dataSource.setPassword(env.getProperty("app.database.password"));
		return dataSource;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
