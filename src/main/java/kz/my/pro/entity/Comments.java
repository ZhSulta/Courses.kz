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
@Table(name = "Comments")
public class Comments implements Serializable{
	private static final long serialVersionUID = 1L;

	private long comment_id;
	private Answers answer;
	private Users user;
	private String text;
	private Date date;
	@Id	
	@GeneratedValue	
	@Column(name = "COMMENT_ID")
	public long getComment_id() {
		return comment_id;
	}
	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}
	@ManyToOne(targetEntity = Answers.class)
	@JoinColumn(name = "ANSWER_ID")	
	public Answers getAnswer() {
		return answer;
	}
	public void setAnswer(Answers answer) {
		this.answer = answer;
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
