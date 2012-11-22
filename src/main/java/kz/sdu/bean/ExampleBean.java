package kz.sdu.bean;

import org.springframework.stereotype.Controller;

@Controller
public class ExampleBean {
	
	public String login(){
		System.out.println("login");
		return "login";
	}
}
