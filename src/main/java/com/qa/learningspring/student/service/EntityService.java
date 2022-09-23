package com.qa.learningspring.student.service;

import java.util.List;

public interface EntityService<T> {
	List<T> listEntities();
	
	T createEntity(T t);
}