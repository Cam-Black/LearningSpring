package com.qa.learningspring.student;

import com.qa.learningspring.student.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Controller {
	@GetMapping
	public List<Student> getStudents() {
		return List.of(
				new Student(
						1L,
						"Cam",
						"camblack",
						LocalDate.of(1998, 3, 18),
						18));
	}
}
