package com.andersen.nadia.task3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andersen.nadia.task3.dao.PersonDao;
import com.andersen.nadia.task3.entity.Person;
import com.andersen.nadia.task3.exception.DaoException;
import com.andersen.nadia.task3.util.ConnectorToDB;

public class PersonDaoImpl implements PersonDao {

	private static final String CREATE = "insert into person (name) values (?)";
	private static final String UPDATE = "update person set name=? where id=?";
	private static final String DELETE = "delete from person where id=?";
	private static final String GET_ALL = "select * from person";

	public void create(Person person) throws DaoException {

		Connection connection = ConnectorToDB.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(CREATE)) {

			ps.setString(1, person.getName());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

	public void update(Person person) throws DaoException {
		
		Connection connection = ConnectorToDB.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {

			ps.setString(1, person.getName());
			ps.setInt(2, person.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

	public void delete(int id) throws DaoException {
		
		Connection connection = ConnectorToDB.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(DELETE)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

	public List<Person> getAll() throws DaoException {

		List<Person> persons = new ArrayList<>();

		Connection connection = ConnectorToDB.getConnection();

		try (Statement s = connection.createStatement(); 
			 ResultSet rs = s.executeQuery(GET_ALL)) {
			
			while(rs.next()) {
				
				Person person = new Person(rs.getInt("id"), rs.getString("name"));
				persons.add(person);
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

		return persons;
	}

}
