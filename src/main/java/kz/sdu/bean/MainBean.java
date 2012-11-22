package kz.sdu.bean;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kz.my.pro.entity.Courses;
import kz.my.pro.service.CourseService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainBean {
	
	@Autowired
	private CourseService courseService;
	private ArrayList<Courses> allCourses;
	@Autowired
	private AboutCourseBean aboutCourseBean;

	public AboutCourseBean getAboutCourseBean() {
		return aboutCourseBean;
	}
	public void setAboutCourseBean(AboutCourseBean aboutCourseBean) {
		this.aboutCourseBean = aboutCourseBean;
	}
	public ArrayList<Courses> getAllCourses() {
		allCourses = getCourseService().getAllCourses();		
		return allCourses;
	}
	public void setAllCourses(ArrayList<Courses> allCourses) {
		this.allCourses = allCourses;
	}
	public CourseService getCourseService() {
		return courseService;
	}	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	private long courseId;
	
	public long getCourseId() {
		System.out.println("getCourseId"+courseId);
		return courseId;
	}
	public void setCourseId(long courseId) {
		System.out.println("setCourseId"+courseId);
		this.courseId = courseId;
	}
}
