package com.andersen.nadia.task3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.andersen.nadia.task3.entity.Person;
import com.andersen.nadia.task3.exception.ServiceException;
import com.andersen.nadia.task3.service.PersonService;
import com.andersen.nadia.task3.service.impl.PersonServiceImpl;

@WebServlet("/add")
public class SavePersonServlet extends HttpServlet {

	private PersonService personService = new PersonServiceImpl();
	private Logger logger = Logger.getRootLogger();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		
		try {
			personService.create(new Person(name));
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}
		
		response.sendRedirect("/andersen/all");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/page/add_person.jsp");
        requestDispatcher.forward(request, response);
    }
}
