package kz.my.pro.service;

import java.util.List;

import kz.my.pro.entity.Users;

public interface UserService {
	
	
	public void addUser(Users user);
	public void removeUser(Users user);
	public void updateUser(Users user);
	public Users getUser(Long id);
	public Users getUser(String username, String password);
	public List<Users> listUsers();
	
}
