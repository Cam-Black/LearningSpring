package com.qa.learningspring.student.service;

import com.qa.learningspring.student.entity.Student;
import com.qa.learningspring.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StudentService implements EntityService<Student> {
	
	private final StudentRepository studRepo;
	
	@Autowired
	public StudentService(StudentRepository studRepo) {
		this.studRepo = studRepo;
	}
	
	@Override
	public List<Student> listEntities() {
		return this.studRepo.findAll();
	}
	
	@Override
	public Student createEntity(Student student) {
		Optional<Student> opStud = studRepo.findStudentByEmail(student.getEmail());
		if (opStud.isPresent()) {
			throw new IllegalStateException("Email taken!");
		}
		return this.studRepo.save(student);
	}
}