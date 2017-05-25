<%@page import="com.slokam.studentpojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('Images/but.jpg');">
<h2><%String str = (String)session.getAttribute("key");
if(str!=null){
	out.print(str);
} %></h2>
<fieldset>
<legend>Total Students</legend>
<%
ArrayList<studentpojo> po=(ArrayList<studentpojo>)request.getAttribute("book");
if(po!=null)
{
	%>
	<table border="2" style="color:red;">
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>AGE</th>
	<th>QUAL</th>
	<th>CELL</th>
	</tr>
	<%
	for(studentpojo s: po){
		%>
		<tr>
		<td><%=s.getId() %></td>
		<td><a href="GetStdById.ser?id=<%=s.getId() %>"><%=s.getName() %></a></td>
		<td><%=s.getAge() %></td>
		<td><%=s.getQuel() %></td>
		<td><%=s.getCell() %></td>
		</tr>
		<%
	}
	%>
</table>
	<%
}
%>
</fieldset>
<h3><a href="goback.ser">Go-Back</a></h3>
</body>
</html>