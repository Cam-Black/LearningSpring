package com.qa.learningspring.student.controller;

import com.qa.learningspring.student.entity.Student;
import com.qa.learningspring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	private final StudentService service;
	
	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return this.service.listEntities();
	}
}