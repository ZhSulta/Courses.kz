package kz.my.pro.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "Answers")
public class Answers implements Serializable{
	private static final long serialVersionUID = 1L;

	private long answer_id;
	private Questions question;
	private Users user;
	private String text;
	private Date publish_date;
	private int votes;
	private Set<Comments> comments;
	
	@Id	
	@GeneratedValue	
	@Column(name = "ANSWER_ID")
	public long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(long answer_id) {
		this.answer_id = answer_id;
	}
	@ManyToOne(targetEntity = Questions.class)
	@JoinColumn(name = "QUESTION_ID")	
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "USER_ID")	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@OneToMany(targetEntity=Comments.class, mappedBy="answer",fetch = FetchType.LAZY)
	public Set<Comments> getComments() {
		return comments;
	}
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
}
