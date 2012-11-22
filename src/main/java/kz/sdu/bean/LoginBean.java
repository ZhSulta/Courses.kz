package kz.sdu.bean;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kz.my.pro.entity.*;
import kz.my.pro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginBean{
	private boolean login = false;
	private String username;
	private String password;
	
	@Autowired
	private UserService userService;
		
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
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
	
	public String login(){
		System.out.print("login");
		Users user = getUserService().getUser(getUsername(), getPassword());
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(user != null){
			session.setAttribute("user", user);
			setLogin(true);
			return "success";			
		}
		setLogin(false);
		return "fail";
	}
	public String logout() {				
	     return "main.xhtml";
	}
//    //managed properties for the login page, username/password/etc...
// 
//    // This is the action method called when the user clicks the "login" button
//    public String doLogin() throws IOException, ServletException
//    {
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
// 
//        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
//                 .getRequestDispatcher("/j_spring_security_check");
// 
//        dispatcher.forward((ServletRequest) context.getRequest(),
//                (ServletResponse) context.getResponse());
// 
//        FacesContext.getCurrentInstance().responseComplete();
//        // It's OK to return null here because Faces is just going to exit.
//        return null;
//    }
}