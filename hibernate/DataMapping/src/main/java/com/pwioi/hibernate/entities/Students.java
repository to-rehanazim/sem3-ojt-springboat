package com.pwioi.hibernate.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENT_MASTER")
public class Students {
	
	
	@Id
	@GeneratedValue
	private int studentId;
	
	@Column(name= "STUDENT_NAME")
	private String name;
	
	private LocalDate admissionDate;

	public Students(int studentId, String name, LocalDate admissionDate) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.admissionDate = admissionDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", admissionDate=" + admissionDate + "]";
	}
	
	

}