package kz.sdu.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kz.my.pro.entity.Users;
import kz.my.pro.service.UserService;

@SessionScoped
@ManagedBean
@Controller
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Date bithDate;
	private String gender;
	private String firstName;
	private String lastName;
	private String email;
	
	@Autowired
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBithDate() {
		return bithDate;
	}
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String save(){
		Users u = new Users();
		
		u.setFirstName(getFirstName());
		u.setLastName(getLastName());
		u.setBirthday(getBithDate());		
		u.setGender(getGender());
		u.setUsername(getUsername());
		u.setPwd(getPassword());
		u.setEmail(getEmail());
		
		getUserService().addUser(u);
		
		return "success";
	}
}

