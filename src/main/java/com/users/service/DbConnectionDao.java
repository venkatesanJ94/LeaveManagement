/**
 * 
 */
package com.users.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.NonNull;

/**
 * @author MVIADMIN
 *
 */
public class DbConnectionDao {

	
	private DataSource srcDataSource;
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @NonNull
    @Qualifier("srcDataSource")
    private void setOnlineDataSource(DataSource ds) {
        srcDataSource = ds;
        jdbcTemplate = new JdbcTemplate(srcDataSource);
    }
}
