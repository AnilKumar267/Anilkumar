<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="forgotjsp.ser">
Enter User Name::<input type="text" name="user"><br>
<%
String gg = (String)request.getAttribute("pogo");
if(gg!=null){
	out.print(gg);
}
%><br>
<input type="submit" value="SUBMIT">
</form>

<h1><a href="Login.jsp">Go Back</a></h1>

</body>
</html>