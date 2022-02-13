package com.andersen.nadia.task3.dao;

import java.util.List;

import com.andersen.nadia.task3.entity.Person;
import com.andersen.nadia.task3.exception.DaoException;

public interface PersonDao {
	
	void create(Person person) throws DaoException;
	void update(Person person) throws DaoException;
	void delete(int id) throws DaoException;
	List<Person> getAll() throws DaoException;

}
