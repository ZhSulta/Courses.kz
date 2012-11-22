package kz.my.pro.service;


import java.util.ArrayList;

import kz.my.pro.entity.Courses;


public interface CourseService {
	
	
	public void addCourse(Courses course);
	public ArrayList<Courses> getAllCourses();
	public Courses getCourse(long courseId);
}
