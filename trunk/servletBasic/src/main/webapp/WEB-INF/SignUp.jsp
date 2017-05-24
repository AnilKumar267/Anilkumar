<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String g=(String) request.getAttribute("msg");
if(g!=null){
	out.print(g);
}
%>

<form action="signup.ser">

Username::<input type="text" name="usrname"><br>
Password::<input type="text" name="pwd"><br>
Age::<input type="text" name="age"><br>
Location::<input type="text" name="location"><br>
Ph No.::<input type="text" name="phone"><br>

<input type="submit" value="SignUp">
</form>

<h1><a href="Login.jsp">Go Back</a></h1>

</body>
</html>