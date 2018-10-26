/**
 * 
 */
package com.users.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.model.Users;

/**
 * @author Venkatesan J
 *
 */

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public Users getUser( String username) {
		return userDao.get(username);
	}

}
