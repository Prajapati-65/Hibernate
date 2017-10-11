<%@page import="com.bridgeit.BankDTO.AccountDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		List<AccountDTO> list = (ArrayList<AccountDTO>) request.getAttribute("list");
	%>
	<table class="table table-hover">
		<form method="post">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>AccountNumber</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<%
		for (AccountDTO account : list) {
		%>
			<tr>
				<td><a class="name"><%=account.getName()%></a></td>
				<td><a class="email"><%=account.getEmail()%></a></td>
				<td><a class="accountnumber"><%=account.getAccountnumber()%></a></td>
				<td><button type="button" name="edit" onclick="return show('<%=account.getId()%>')" data-toggle="modal" data-target="#addModal"  class="btn btn-success">Edit</button></td>
				<td><button type="submit" onclick="return deleteAccount('<%=account.getId()%>')"  class="btn btn-success">Delete</button></td>
			</tr>		
		<%
			}
		%>
		</tbody>
		</form>
	</table>
</body>
</html>