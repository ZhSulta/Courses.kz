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
@Table(name = "Wikies")
public class Wikies implements Serializable{
	private static final long serialVersionUID = 1L;

	private long wiki_id;
	private Courses course;
	private String topic;	
	private String title;
	private String text;
	private int position;	
	private Date publish_date;
	private Date modified_date;
	@Id	
	@GeneratedValue	
	@Column(name = "WIKI_ID")
	public long getWiki_id() {
		return wiki_id;
	}
	public void setWiki_id(long wiki_id) {
		this.wiki_id = wiki_id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
