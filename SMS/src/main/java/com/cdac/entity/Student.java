package com.cdac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	
	@Column(name = "fName", nullable=false)
	private String fName;
	@Column(name = "lName")
	private String lName;
	@Column(name = "DOB", nullable=false)
	private String DOB;
	@Column(name = "email",nullable=false,unique=true)
	private String email;
	@Column(name = " password",nullable=false)
	private String password;
	@Column(name = "father",nullable=false)
	private String father;
	@Column(name = "mother",nullable=false)
	private String mother;
	@Column(name = "gender",nullable=false)
	private String gender;
	@Column(name = "Address",nullable=false)
	private String address;
	@Column(nullable=false)
	private String contactNo;
	@Column(name = "Date_of_Submission",nullable=false)
	private String date_of_Submission;
	@Column(name = "fee_status",nullable=false)
	private String fee_status;
	public void setFather(String father) {
		this.father = father;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDate_of_Submission(String date_of_Submission) {
		this.date_of_Submission = date_of_Submission;
	}

	public void setFee_status(String fee_status) {
		this.fee_status = fee_status;
	}

	 
	 @OneToOne 	
	 private Result result;
	 
	 @ManyToOne
	private Class classes;
	 
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Student() {
		super();
	}
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	public String getFee_status() {
		return fee_status;
	}
	public void setfee_status(String fee_status) {
		this.fee_status = fee_status;
	}
	public String getDate_of_Submission() {
		return date_of_Submission;
	}
	public void setdate_of_Submission(String date_of_Submission) {
		this.date_of_Submission = date_of_Submission;
	}

	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFather() {
		return father;
	}
	public void setfather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setmother(String mother) {
		this.mother = mother;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}
	
}
