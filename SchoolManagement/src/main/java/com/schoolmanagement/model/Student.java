package com.schoolmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends Stakeholder{
	private int studentId;
	private int parentContactNumber;
	private String grade;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Column(name="prtConNbr")
	public int getParentContactNumber() {
		return parentContactNumber;
	}
	public void setParentContactNumber(int parentContactNumber) {
		this.parentContactNumber = parentContactNumber;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
