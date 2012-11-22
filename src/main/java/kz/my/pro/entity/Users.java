package kz.my.pro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class Users implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String username;
	private String pwd;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String location;
	private String photo;
	private Date birthday;
	private String aboutMe;
	private Set<MyCourses> myCourses;
	private Set<Courses> courses;
	private Set<Questions> questions;
	private Set<Answers> answers;
	private Set<Comments> comments;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@NotEmpty
	@Length(min=4,max=20)	
	@Column(name = "USERNAME", nullable = false, length = 20)	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Length(min=6, max=10)	
	@Column(name = "PASSWORD", nullable = false, length = 10)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@NotEmpty(message="Please select a gender")	
	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	@OneToMany(targetEntity=MyCourses.class, mappedBy="user",fetch = FetchType.LAZY)
	public Set<MyCourses> getMyCourses() {
		return myCourses;
	}
	public void setMyCourses(Set<MyCourses> myCourses) {
		this.myCourses = myCourses;
	}	
	@OneToMany(targetEntity=Courses.class, mappedBy="user",fetch = FetchType.LAZY)	
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	@OneToMany(targetEntity=Questions.class, mappedBy="user",fetch = FetchType.LAZY)
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	@OneToMany(targetEntity=Answers.class, mappedBy="user",fetch = FetchType.LAZY)
	public Set<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}
	@OneToMany(targetEntity=Comments.class, mappedBy="user",fetch = FetchType.LAZY)
	public Set<Comments> getComments() {
		return comments;
	}
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
}
