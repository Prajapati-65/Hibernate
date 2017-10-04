package com.bridgeit.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.BankDAO.BankDAO;


//@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inside delete servlet");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id =Integer.parseInt(req.getParameter("id"));
		
		
		System.out.println("delete servlet---id---"+id);
		BankDAO.deleteAccount(id);
		
	}
}




