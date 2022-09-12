package com.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/confirmbooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session != null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/payment.jsp");
			rd.forward(request, response);

		}else {
			request.setAttribute("Error", "Error Occured while confirming ticket");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmbooking.jsp");
			rd.forward(request, response);
		}

	}

}

