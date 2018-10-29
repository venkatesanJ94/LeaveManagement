/**
 * 
 */
package com.users.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.users.model.Users;

/**
 * @author Venkatesan J
 *
 */
@Repository
@Qualifier("userDao")
public class UserDao {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
	 public Users get(String username) {
		 Users user = (Users) jdbcTemplate.queryForObject("select * from users where username = ? ",
	            new Object[] { username }, new BeanPropertyRowMapper<Users>(Users.class));
	 
	        return user;
	    }
	 
	 public int insert(String username, String password, String emailID) {
		 int status= jdbcTemplate.update("INSERT INTO USERS(USERNAME,PASSWORD,USERLEVEL,EMAILID) VALUES(?,?,?,?) ",
	            new Object[] { username, password,"U",emailID});
	 
	        return status;
	    }

}
