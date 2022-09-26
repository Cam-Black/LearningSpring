package com.qa.learningspring.student.controller;

import com.qa.learningspring.student.entity.Student;
import com.qa.learningspring.student.repo.StudentRepository;
import com.qa.learningspring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	private final StudentService service;
	private final StudentRepository repo;
	
	@Autowired
	public StudentController(StudentService service, StudentRepository repo) {
		this.service = service;
		this.repo = repo;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return this.service.listEntities();
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return this.service.createEntity(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteStudent(@PathVariable("id") Long id) {
		return this.service.deleteEntity(id);
	}
	
	@PutMapping("/replace/{id}")
	public Student replaceStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student updated = this.repo.findById(id).orElse(null);
		assert updated != null;
		if (student.getName() != null && !student.getName().equals(updated.getName())) {
			updated.setName(student.getName());
		}
		if (student.getEmail() != null && !student.getEmail().equals(updated.getEmail())) {
			updated.setEmail(student.getEmail());
		}
		if (student.getDob() != null && !student.getDob().equals(updated.getDob())) {
			updated.setDob(student.getDob());
		}
		return this.service.replaceEntity(updated);
	}
	
	@PatchMapping("/update/{id}")
	public Student updateStudent(@PathVariable("id") Long id,
	                             @RequestParam(required = false) String name,
	                             @RequestParam(required = false) String email) {
		return this.service.updateEntity(id, name, email);
	}
}