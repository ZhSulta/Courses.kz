package kz.my.pro.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import kz.my.pro.dao.UserDAO;
import kz.my.pro.entity.Users;


public class UserDAOImpl implements UserDAO{
	
	
	private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
   
    	return sessionFactory;
        
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        
    	this.sessionFactory = sessionFactory;
    }
	
	

	public void save(Users user) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void update(Users user) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();	
	}
	
	public void remove(Users user) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Users> listUsers() {
		
		return null;
	}

	public Users getUser(Long id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		return (Users)session.get(Users.class, id);
	}



	public Users getUser(String username, String password) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Users u WHERE u.username = :username AND pwd = :password");
		query.setString("username", username);
		query.setString("password", password);
		Users user = null;
		if(query != null)
			user = (Users)query.uniqueResult();
		
		return user;
	}
}
