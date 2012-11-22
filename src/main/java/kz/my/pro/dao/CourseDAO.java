package kz.my.pro.dao;

import java.util.ArrayList;
import kz.my.pro.entity.Courses;

public interface CourseDAO {
	
	public void save(Courses course);
	public ArrayList<Courses> getAllCourses();
	public Courses getCourse(long courseId);
}
