package com.bridgeit.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgeit.BankDAO.BankDAO;
import com.bridgeit.BankDTO.AccountDTO;

//@WebServlet("/AccountView")
public class AccountView extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(AccountView.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String city = req.getParameter("city");
		HttpSession session = req.getSession();
		String email =(String) session.getAttribute("email");
		int id = BankDAO.id(email);
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<h1>Account List</h1>");
		List<AccountDTO> list = BankDAO.getAllAccount(city,id);
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("citydetails.jsp");
		dispatcher.forward(req, resp);
		logger.info("Your account");
	}
}
