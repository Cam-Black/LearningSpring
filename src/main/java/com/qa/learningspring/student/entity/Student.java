package com.qa.learningspring.student.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	private String name;
	private String email;
	private Integer age;
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	public Student() {
	}
	
	public Student(Long studentId, String name, String email, LocalDate dob, Integer age) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dob = dob;
	}
	
	public Student(String name, String email, LocalDate dob, Integer age) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.dob = dob;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", age=" + age +
				", dob=" + dob +
				'}';
	}
}