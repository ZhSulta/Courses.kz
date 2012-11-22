package kz.my.pro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="COURSES")
public class Courses implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long course_id;
	private String name;
	private String university;
	private int duration;
	private String smallDescription;
	private String description;
	private String img;
	private String syllabus;
	private Date date;
	private Date startDate;
	private Users user;
	private Set<Announcements> announcements;
	private Set<Videos> videos;
	private Set<Questions> questions;
	private Set<Wikies> wikies;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id	
	@GeneratedValue	
	@Column(name = "COURSE_ID")
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getUniversity() {
		return university;
	}	
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getSmallDescription() {
		return smallDescription;
	}
	public void setSmallDescription(String smallDescription) {
		this.smallDescription = smallDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "USER_ID")		
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@OneToMany(targetEntity=Announcements.class, mappedBy="course",fetch = FetchType.LAZY)
	public Set<Announcements> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(Set<Announcements> announcements) {
		this.announcements = announcements;
	}
	@OneToMany(targetEntity=Videos.class, mappedBy="course",fetch = FetchType.LAZY)
	public Set<Videos> getVideos() {
		return videos;
	}
	public void setVideos(Set<Videos> videos) {
		this.videos = videos;
	}
	@OneToMany(targetEntity=Questions.class, mappedBy="course",fetch = FetchType.LAZY)
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	@OneToMany(targetEntity=Wikies.class, mappedBy="course",fetch = FetchType.LAZY)
	public Set<Wikies> getWikies() {
		return wikies;
	}
	public void setWikies(Set<Wikies> wikies) {
		this.wikies = wikies;
	}
}
