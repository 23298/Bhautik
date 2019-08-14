package com.Bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questiondetails1")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionid;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "examid")
	List<QuestionBean> QuestionBean;

	@Column(nullable = false)
	private String question;

	@Column(nullable = false)
	private String o1;

	@Column(nullable = false)
	private String o2;

	
	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public List<QuestionBean> getQuestionBean() {
		return QuestionBean;
	}

	public void setQuestionBean(List<QuestionBean> questionBean) {
		QuestionBean = questionBean;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getO1() {
		return o1;
	}

	public void setO1(String o1) {
		this.o1 = o1;
	}

	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}

	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}

	public String getO4() {
		return o4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setO4(String o4) {
		this.o4 = o4;
	}



	@Column(nullable = false)
	private String o3;

	@Column(nullable = false)
	private String o4;

	@Column(nullable = false)
	private String answer;

}
