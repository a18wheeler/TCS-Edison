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
<h3>To view channel details enter the Channel ID</h3>
<tr>
<td>Enter id </td>
<td><input type="text" name="readId"></td>
</tr>
<tr>
<td></td>
<td><input type="submit"></td>
<input type="hidden" name="register" value="read_channel">
</tr>
</table>

</form>
</fieldset>
</div>
</body>
</html>>