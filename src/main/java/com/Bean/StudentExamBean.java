package com.Bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Studentde")
public class StudentExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentexamid;
	
	private int examid;
	private int  questionid;
	private int studentid;
	
		
public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	/*	public QuestionBean getBean() {
		return bean;
	}

	public void setBean(QuestionBean bean) {
		this.bean = bean;
	}

	public studentBean getBean1() {
		return bean1;
	}

	public void setBean1(studentBean bean1) {
		this.bean1 = bean1;
	}

	public ExamBean getBean2() {
		return bean2;
	}

	public void setBean2(ExamBean bean2) {
		this.bean2 = bean2;
	}
*/
	public int getStudentexamid() {
		return studentexamid;
	}

	public void setStudentexamid(int studentexamid) {
		this.studentexamid = studentexamid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String answer;
	
	private String status;

	
	}
