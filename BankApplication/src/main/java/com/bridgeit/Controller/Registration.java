package com.bridgeit.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.BankDAO.UserDAO;
import com.bridgeit.BankDTO.UserDTO;

//@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final static  Logger logger = LoggerFactory.getLogger(Registration.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your registration is successful...." + "</br>");
		out.println(title);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String number = req.getParameter("mobilenumber");
		
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobilenumber(number);
		
		if(UserDAO.saveRegistration(user) > 0)
		{	
			logger.info("Registration");
			req.getRequestDispatcher("registrationform.jsp").include(req, resp);		
		}
		else
		{
			logger.warn("Registraion is not successful");
		}	
		resp.sendRedirect("login.jsp");
	}

}
