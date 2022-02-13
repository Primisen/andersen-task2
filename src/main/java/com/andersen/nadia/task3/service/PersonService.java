package com.andersen.nadia.task3.service;

import java.util.List;

import com.andersen.nadia.task3.entity.Person;
import com.andersen.nadia.task3.exception.ServiceException;

public interface PersonService {
	
	void create(Person person) throws ServiceException;
	void update(Person person) throws ServiceException;
	void delete(int id) throws ServiceException;
	List<Person> getAll() throws ServiceException;
	
}
