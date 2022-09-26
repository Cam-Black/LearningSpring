package com.qa.learningspring.student.service;

import com.qa.learningspring.student.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

public interface EntityService<T, U, V> {
	List<T> listEntities();
	
	T createEntity(T t);
	
	boolean deleteEntity(Long id);
	
	T replaceEntity(T t);
	
	T updateEntity(U t1, V t2, V t3);
}