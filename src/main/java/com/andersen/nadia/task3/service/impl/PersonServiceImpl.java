package com.andersen.nadia.task3.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.andersen.nadia.task3.dao.PersonDao;
import com.andersen.nadia.task3.dao.impl.PersonDaoImpl;
import com.andersen.nadia.task3.entity.Person;
import com.andersen.nadia.task3.exception.DaoException;
import com.andersen.nadia.task3.exception.ServiceException;
import com.andersen.nadia.task3.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao = new PersonDaoImpl();

	public void create(Person person) throws ServiceException {

		try {
			personDao.create(person);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public void update(Person person) throws ServiceException {

		try {
			personDao.update(person);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public void delete(int id) throws ServiceException {
		
		try {
			personDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public List<Person> getAll() throws ServiceException {
		
		List<Person> persons = new ArrayList();
		
		try {
			persons = personDao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return persons;
	}

}
