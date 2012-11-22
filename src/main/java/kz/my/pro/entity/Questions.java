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
@Table(name = "Questions")
public class Questions implements Serializable{
	private static final long serialVersionUID = 1L;

	private long question_id;
	private Courses course;
	private Users user;
	private String title;
	private String text;
	private String tags;
	private int votes_number;
	private int answers_number;
	private int views_number;
	private Date publish_date;
	private Set<Answers> answers;
	
	@Id	
	@GeneratedValue	
	@Column(name = "QUESTION_ID")
	public long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}
	@ManyToOne(targetEntity = Courses.class)
	@JoinColumn(name = "COURSE_ID")	
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "USER_ID")	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getVotes_number() {
		return votes_number;
	}
	public void setVotes_number(int votes_number) {
		this.votes_number = votes_number;
	}
	public int getAnswers_number() {
		return answers_number;
	}
	public void setAnswers_number(int answers_number) {
		this.answers_number = answers_number;
	}
	public int getViews_number() {
		return views_number;
	}
	public void setViews_number(int views_number) {
		this.views_number = views_number;
	}
	@OneToMany(targetEntity=Answers.class, mappedBy="question",fetch = FetchType.LAZY)	
	public Set<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
