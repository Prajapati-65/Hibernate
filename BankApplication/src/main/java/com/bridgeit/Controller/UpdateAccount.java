package com.bridgeit.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.BankDAO.BankDAO;

//@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String accountId = req.getParameter("id");

		int pid = Integer.parseInt(accountId);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String accountnumber = req.getParameter("accountnumber");

		BankDAO.editRow(pid, name, email, city, accountnumber);
	}

}
