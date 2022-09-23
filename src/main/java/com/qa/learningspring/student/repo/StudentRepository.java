package com.qa.learningspring.student.repo;

import com.qa.learningspring.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findStudentByEmail(String email);
}
