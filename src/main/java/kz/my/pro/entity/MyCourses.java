package kz.my.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MY_COURSES")
public class MyCourses{
	private long my_course_id;	
	private Users user;
	
	@Id	
	@GeneratedValue	
	@Column(name = "MY_COURSE_ID")
	public long getMy_course_id() {
		return my_course_id;
	}
	public void setMy_course_id(long my_course_id) {
		this.my_course_id = my_course_id;
	}
	
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "USER_ID")		
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
