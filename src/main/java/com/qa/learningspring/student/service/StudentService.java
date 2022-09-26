package com.qa.learningspring.student.service;

import com.qa.learningspring.student.entity.Student;
import com.qa.learningspring.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Primary
public class StudentService implements EntityService<Student, Long, String> {
	
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
	
	@Override
	public boolean deleteEntity(Long id) {
		this.studRepo.deleteById(id);
		return !this.studRepo.existsById(id);
	}
	
	@Transactional
	@Override
	public Student updateEntity(Long id, String name, String email) {
		Student updated = studRepo.findById(id).orElseThrow(() -> new IllegalStateException("student does not exist!"));
		if (name != null && name.length() > 0 && !Objects.equals(updated.getName(), name)) {
			updated.setName(name);
		}
		
		if (email != null && !email.isEmpty() && !Objects.equals(updated.getEmail(), email)) {
			Optional<Student> studentOptional = studRepo.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email taken!");
			}
			updated.setEmail(email);
		}
		return updated;
	}
	
	@Override
	public Student replaceEntity(Student student) {
		return this.studRepo.save(student);
		
	}
}