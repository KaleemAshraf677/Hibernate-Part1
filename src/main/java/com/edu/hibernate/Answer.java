package com.edu.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
     
	@Id
	@Column(name="answer_id")
	private int answerID;
	private String answer;
	
	@OneToOne(mappedBy="answer",cascade= CascadeType.ALL)   //this cascade type perform all the operations like delete,save,merge, whatever we need to store in our database
	private Question question;
	
	
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
