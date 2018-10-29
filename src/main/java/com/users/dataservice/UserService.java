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

	public boolean insertUser(String username, String password, String emailID) {
		int status=userDao.insert(username, password, emailID);
		if(status == 0) {
			return false;
		}
		return true;
	}
}
