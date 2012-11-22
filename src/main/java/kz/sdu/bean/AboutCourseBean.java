package kz.sdu.bean;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kz.my.pro.entity.Courses;
import kz.my.pro.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AboutCourseBean {
	

	private Courses course;
	@ManagedProperty(value = "#{course_id}")	
	private long course_id;
	@Autowired
	private CourseService courseService;
	
	public long getCourse_id() {
		System.out.println(course_id);
		return course_id;
	}
	public void setCourse_id(long course_id) {
		System.out.println(course_id);
		this.course_id = course_id;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public Courses getCourse() {
		return course;				
	}
	public void setCourse(Courses course) {	
		this.course = course;
	}
	
	public String aboutCourse(ActionEvent event){
		String course_id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("course_id");
		System.out.println(course_id);
		setCourse(getCourseService().getCourse(Integer.parseInt(course_id)));
		return "aboutCourse";
	}
	
}
