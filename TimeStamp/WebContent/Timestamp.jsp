<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Timestamp Microservice</title>
</head>
<body>
	<form action="timestamp" method="get">
		<label>Input here: </label>
		<input type="text" name="timestamp">
		<select name="option">
			  <option value="unix">Unix Time</option>
			  <option value="dd/MM/yyyy">dd/MM/yyyy</option>
			  <option value="dd-MMM-yyyy">dd-MMM-yyyy</option>
			  <option value="dd MM yyyy">dd MM yyyy</option>
		</select>
		<input type="submit" value="Send">
	</form>
</body>
</html>