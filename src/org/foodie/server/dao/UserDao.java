package org.foodie.server.dao;
/**
 * @author Danyang Li
 */

import javax.transaction.Transactional;

import org.foodie.server.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * 
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	public User findOneByEmail(String email);
}
  
