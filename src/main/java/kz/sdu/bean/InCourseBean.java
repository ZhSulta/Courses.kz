package kz.sdu.bean;

import kz.my.pro.entity.Courses;
import kz.my.pro.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InCourseBean {
	
	private int courseId;
	@Autowired
	private CourseService courseService;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String toCourse(){	
		return "toCourse";
	}
}
