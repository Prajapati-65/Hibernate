package com.bridgeit.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.BankDAO.BankDAO;
import com.bridgeit.BankDTO.AccountDTO;
import com.bridgeit.BankDTO.UserDTO;


//@WebServlet("/AddAccountDetails")
public class AddAccountDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String emailid=(String) session.getAttribute("email");
		int id = BankDAO.id(emailid);
		session.setAttribute("id", id);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your account is successful" + "</br>");
		out.println(title);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String accountnumber = req.getParameter("accountnumber");
		
		UserDTO  user = new UserDTO();
		user.setId((int)session.getAttribute("id"));
		
		AccountDTO account = new AccountDTO();
		account.setName(name);
		account.setEmail(email);
		account.setCity(city);
		account.setAccountnumber(accountnumber);
		account.setUser(user);
		BankDAO.saveAccountData(account);
		RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(req, resp);
		
	}
}
