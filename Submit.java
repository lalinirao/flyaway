package com.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.model.Fare;
import com.model.Flight;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		CustomerDAO cust = new CustomerDAO();
		
		String travelClass = request.getParameter("travelclass");
		HttpSession session = request.getSession(false);
		Flight flight = (Flight)session.getAttribute("flightobject");
		Fare fare = cust.getFareRecord(flight.getFlightNumber(), travelClass);
		session.setAttribute("fareobject", fare);
		
		Integer customerId = (Integer)session.getAttribute("customerId");
		
		if(customerId == null) {
		rd = getServletContext().getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
		}else if(customerId != null) {
			rd = getServletContext().getRequestDispatcher("/confirmbooking.jsp");
	        rd.forward(request, response);
		}
	}

}
