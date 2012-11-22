package kz.my.pro.dao;

import java.util.List;

import kz.my.pro.entity.Users;

public interface UserDAO {
	
	public void save(Users user);
	public void update(Users user);
	public void remove(Users user);
	public List<Users> listUsers();
	public Users getUser(Long id);
	public Users getUser(String username, String password);
}
