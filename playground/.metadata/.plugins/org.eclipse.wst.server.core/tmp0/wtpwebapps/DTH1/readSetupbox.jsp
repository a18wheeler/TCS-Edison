<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<fieldset style="width:500px;height:260px">
<form action="DTHServlet" method="get">
<table>
<h3>To view set up box details select one option of below</h3>
<tr>
<td>Enter id </td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td></td>
<td><input type="submit"></td> 
</tr>
</table>
<input type="hidden" name="register" value="select">
</form>
<h3>OR</h3>
<form action="DTHServlet" method="get">
<input type="submit" value="Show all details"/>
<input type="hidden" name="register" value="select1">
<table>
<tr>
<td></td>
<td>
<a href="index.jsp">Insert setupbox</a>
</td>
</tr>
<tr>
<td></td>
<td>
<a href="updateSetUpBox.jsp">Update setupbox</a>
</td>
</tr>
<tr><td></td>
<td>
<a href="deleteSetupbox.jsp">Delete setupbox</a></td>
</tr>
</table>
<br>
</form>
</fieldset>
</div>
</body>
</html>
