package kz.my.pro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kz.my.pro.dao.impl.CourseDAOImpl;
import kz.my.pro.dao.impl.UserDAOImpl;
import kz.my.pro.entity.Courses;
import kz.my.pro.entity.Users;
import kz.my.pro.service.CourseService;
import kz.my.pro.service.UserService;


@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService{
	
	
	private CourseDAOImpl courseDAOImpl;
	
	public CourseDAOImpl getCourseDAOImpl() {
		return courseDAOImpl;
	}
	public void setCourseDAOImpl(CourseDAOImpl courseDAOImpl) {
		this.courseDAOImpl = courseDAOImpl;
	}
	@Transactional(readOnly = false)
	public void addCourse(Courses course){
		getCourseDAOImpl().save(course);
	}
	public ArrayList<Courses> getAllCourses() {
		return getCourseDAOImpl().getAllCourses();
	}
	public Courses getCourse(long courseId) {
		return getCourseDAOImpl().getCourse(courseId);		
	}
	

}
