package kz.my.pro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Announcements")
public class Announcements implements Serializable{	
	private static final long serialVersionUID = 1L;	
	private long announcement_id;
	private Courses course;
	private String topic;
	private String text;
	private Date date;
	@Id	
	@GeneratedValue	
	@Column(name = "ANNOUNCEMENT_ID")
	public long getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(long announcement_id) {
		this.announcement_id = announcement_id;
	}
	@ManyToOne(targetEntity = Courses.class)
	@JoinColumn(name = "COURSE_ID")	
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
