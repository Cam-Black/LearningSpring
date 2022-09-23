package com.qa.learningspring.student.controller;

import com.qa.learningspring.student.entity.Student;
import com.qa.learningspring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return this.service.createEntity(student);
	}
}