package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "result_id")
	private int result_id;
	@Column(name = "marks1")
	private int marks1;
	@Column(name = "marks2")
	private int marks2;
	@Column(name = "marks3")
	private int marks3;
	@Column(name = "marks4")
	private int marks4;
	
	private double total_mark;
	
	private double percentage;
	
	private String status;
	@OneToOne
	@JoinColumn
	 private Student student;
	@ManyToOne
	 private Class classes;
	@ManyToOne
	 private Subject subject;
	
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public int getMarks4() {
		return marks4;
	}
	public void setMarks4(int marks4) {
		this.marks4 = marks4;
	}
	public double getTotal_mark() {
		total_mark=marks1+marks2+marks3+marks4;
		return total_mark;
	}
	public double getPercentage() {
		//total_mark=marks1+marks2+marks3+marks4;
		double sub_total=total_mark/400;
		percentage=sub_total*100;
		System.out.println(percentage);
		return percentage;
	}
	
	
	public String getStatus() {
		if(percentage<=33) {
			status="Fail";
		}
		else {
			status="Pass";
		}
		return status;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
