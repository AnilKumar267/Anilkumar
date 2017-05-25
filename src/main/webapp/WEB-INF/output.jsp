<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="script/our.js"></script>
</head>
<body ng-app="call">
<%  
String name = (String) request.getAttribute("name");
 
String qule = (String) request.getAttribute("quli");
String cell = (String) request.getAttribute("cell");

%>
<fieldset style="background-color: aqua;">
<legend style="color: background;">Details</legend>

<table border="2">
  <tr style="color: red; font-style: italic;">
  <th>Id</th>
  <th>Name</th>
  <th>Age</th>
  <th>Qulification</th>
  <th>cell</th>
  </tr  >
  <tr style="color: background;" >
  <td><%=request.getAttribute("id") %></td>
  <td><%=name %></td>
  <td><%=request.getAttribute("age") %></td>
  <td><%=qule %></td>
  <td><%=cell %></td>
  </tr>

</table>

</fieldset>
<h2 style="color: green;;"><a href="input.jsp">GoBack</a></h2>
</body>
</html>