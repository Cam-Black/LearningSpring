package com.qa.learningspring.student.service;

import com.qa.learningspring.student.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class StudentService implements EntityService<Student> {
	@Override
	public List<Student> listEntities() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1L, "Cam", "cblack", LocalDate.of(1998, 3, 18), 24));
		return students;
	}
}