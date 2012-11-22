package kz.sdu.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import kz.my.pro.entity.Courses;
import kz.my.pro.entity.Users;
import kz.my.pro.service.CourseService;
import kz.my.pro.service.UserService;
import kz.sdu.utils.MessageUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.faces.application.FacesMessage;  
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.FileUploadEvent;  
import org.primefaces.model.UploadedFile; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sun.security.action.GetLongAction;

import com.sun.faces.util.MessageUtils;

@Controller
public class CourseBean {
 
	private String name;
	private String smallDescription;
	private String description;
	private String university;
	private int duration;
	private Date startDate;
	private String syllabus;	
	private String fileName = null;
	

	@Autowired
	private LoginBean loginBean;	
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	

	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public String getSmallDescription() {
		return smallDescription;
	}
	public void setSmallDescription(String smallDescription) {
		this.smallDescription = smallDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String destination="//home//sulta//images//";

    public void upload(FileUploadEvent event) {  
    	System.out.println("upload");
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  

    public void copyFile(String fileName, InputStream in) {
           try {        	  
        	   // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
                this.fileName = fileName;
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
	public String save(){
		Date date=new Date();
		Courses course = new Courses();		
		course.setName(getName());
		course.setDuration(getDuration());
		course.setImg(fileName);
		course.setSyllabus(getSyllabus());
		course.setUniversity(getUniversity());
		course.setSmallDescription(getSmallDescription());
		course.setDescription(getDescription());
		course.setDate(date);
		course.setStartDate(getStartDate());
		Users user = userService.getUser(loginBean.getUsername(), loginBean.getPassword());
		course.setUser(user);
		getCourseService().addCourse(course);	
		return "success";
	}

}
