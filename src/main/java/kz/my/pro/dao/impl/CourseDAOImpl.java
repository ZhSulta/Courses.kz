package kz.my.pro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import kz.my.pro.dao.CourseDAO;
import kz.my.pro.dao.UserDAO;
import kz.my.pro.entity.Courses;
import kz.my.pro.entity.Users;


public class CourseDAOImpl implements CourseDAO{
	
	
	private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {   
    	return sessionFactory;
        
    }
    public void setSessionFactory(SessionFactory sessionFactory) {        
    	this.sessionFactory = sessionFactory;
    }
	
	

	public void save(Courses course) {		
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		session.close();
	}
	public ArrayList<Courses> getAllCourses() {
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();
		Query query = session.createQuery("select c from Courses c");
		ArrayList<Courses> list = (ArrayList<Courses>) query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public Courses getCourse(long courseId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		return (Courses)session.get(Courses.class, courseId);
	}
	
}
