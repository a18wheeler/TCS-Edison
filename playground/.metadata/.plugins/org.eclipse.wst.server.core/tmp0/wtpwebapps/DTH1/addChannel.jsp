<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add channel</title>
</head>
<body>
<div align="center">
<form action="DTHServlet" method="get">
<fieldset style="width:700px;height:550px">
<table>
<h2>Add Channel</h2>
<tr>
<td>
Set top Box ID
</td>
<td>
<input type ="text" name="stbID">
</td>
</tr>
<tr>
<td>
Channel ID
</td>
<td>
<input type ="text" name="cID">
</td>
</tr>
<tr>
<td>
Channel Name
</td>
<td>
<input type ="text" name="cName">
</td>
</tr>
<tr>
<td>
Channel Band
</td>
<td>
<input type ="text" name="cBand">
</td>
</tr>
<tr>
<td>
Video Carrier Frequency
</td>
<td>
<input type ="text" name="vFrequency">
</td>
</tr>
<tr>
<td>
Audio Carrier Frequencey
</td>
<td>
<input type ="text" name="aFrequency">
</td>
</tr>
<tr>
<td>
Channel Charge Type
</td>
<td>
<input type ="text" name="cCtype">
</td>
</tr>
<tr>
<td>
Channel Transmission Type
</td>
<td>
<input type ="text" name="ctType">
</td>
</tr>
<tr>
<td>
Channel charge
</td>
<td>
<input type ="text" name="cCharge">
</td>
</tr>
<td>
<input type ="submit" name="submit">
<input type="hidden" name="register" value="create_channel">
<input type ="reset" name="reset">
</td>
</tr>
<tr>
<td></td>
<td>
<a href="readSetupbox.jsp">View Channels</a>
</td>
</tr>
<tr>
<td></td>
<td>
<a href="updateSetupbox.jsp">Delete Channels</a>
</td>
</tr>
<tr><td></td>
<td>
<a href="deleteSetupbox.jsp">Update Channels</a></td>

</table>
</fieldset>
</form>
</div>
</body>
</body>
</html>