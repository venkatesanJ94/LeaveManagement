/**
 * 
 */
package com.users.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Venkatesan J
 *
 */

@Configuration
@ComponentScan(basePackages = "com.users")
@PropertySource(value = {"classpath:config.properties"})
public class DataConnectionService {

	 @Autowired
	    private Environment env;
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("lm.db.driverClassName"));
	        dataSource.setUrl(env.getRequiredProperty("lm.db.url"));
	        dataSource.setUsername(env.getRequiredProperty("lm.db.username"));
	        dataSource.setPassword(env.getRequiredProperty("lm.db.password"));
	        return dataSource;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
	 
	
}
