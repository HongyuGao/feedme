package org.foodie.server.service;

import org.foodie.server.dao.UserDao;
import org.foodie.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public void create(User newUser) {
		userDao.save(newUser);
	}

	@Override
	public void remove(User removedUser) {
		userDao.delete(removedUser);
	}

	@Override
	public void update(User updatedUser) {
		userDao.save(updatedUser);
	}

	@Override
	public User query(String email) {
		return userDao.findOneByEmail(email);
	}
	
	

}
