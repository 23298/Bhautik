package com.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Exam")
public class ExamBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int examid;
	
	@Column(nullable=false)
	private String title;
	
	public int getExamid() {
		return examid;
	}


	public void setExamid(int examid) {
		this.examid = examid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}


	public int getTotalmarks() {
		return totalmarks;
	}


	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getExamcode() {
		return examcode;
	}


	public void setExamcode(String examcode) {
		this.examcode = examcode;
	}


	@Column(nullable=false)
	private int date;
	
		

	@Column(nullable=false)
	private int totalmarks;

	@Column(nullable=false)
	private int duration;
	

	@Column(nullable=false)
	private String examcode;
}
