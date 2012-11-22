package kz.my.pro.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kz.my.pro.dao.impl.UserDAOImpl;
import kz.my.pro.entity.Users;
import kz.my.pro.service.UserService;


@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
	
	
	private UserDAOImpl userDAOImpl;
	
	

	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}



	public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}



	@Transactional(readOnly = false)
	public void addUser(Users user) {
		getUserDAOImpl().save(user);
	}


	@Transactional(readOnly = false)
	public void removeUser(Users user) {
		getUserDAOImpl().remove(user);
	}


	@Transactional(readOnly = false)
	public void updateUser(Users user) {
		getUserDAOImpl().update(user);
	}



	public Users getUser(Long id) {
		
		return getUserDAOImpl().getUser(id);
	}



	public List<Users> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}



	public Users getUser(String username, String password) {

		return getUserDAOImpl().getUser(username, password);
	}
}
