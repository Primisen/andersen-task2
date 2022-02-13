package com.andersen.nadia.task3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.andersen.nadia.task3.exception.ServiceException;
import com.andersen.nadia.task3.service.PersonService;
import com.andersen.nadia.task3.service.impl.PersonServiceImpl;

@WebServlet("/all")
public class GetAllPersonsServlet extends HttpServlet {

	private PersonService personService = new PersonServiceImpl();
	private Logger logger = Logger.getRootLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("persons", personService.getAll());
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/page/get_all_persons.jsp");
		requestDispatcher.forward(request, response);

	}

}
