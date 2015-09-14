package org.foodie.server.service;

import org.foodie.server.dao.UserDao;
import org.foodie.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Danyang Li
 *
 */
@Component
public class UserServiceImp implements UserService {
	@Autowired
	  private UserDao userDao;

	@Override
	public String create(User newUser) {
		userDao.save(newUser);
		return null;
	}

	@Override
	public String remove(User removedUser) {
		userDao.delete(removedUser);
		return null;
	}

	@Override
	public String update(User updatedUser) {
		userDao.save(updatedUser);
		return null;
	}

	@Override
	public User query(String field) {
		userDao.findOneByEmail(field);
		return null;
	}
	
	

}
