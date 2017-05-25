<%@page import="com.slokam.studentpojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="script/our.js"></script>
<script type="text/javascript">
function save() {
	alert("save success");
	document.forms[0].action="save.ser";
	document.forms[0].submit();
}
function sdelete() {
	alert("delete success");
	document.forms[0].action="delete.ser";
	document.forms[0].submit();
}
function update() {
	alert("update success");
	document.forms[0].action="update.ser";
	document.forms[0].submit();
}

function getall() {
	alert("getall success");
	document.forms[0].action="getall.ser";
	document.forms[0].submit();
}
</script>
</head>
<body style="background-image: url('Images/flowers.jpg');">
<%String stra = (String)session.getAttribute("key");
if(stra!=null){
	out.print(stra);
} %>

<%
String str = (String) request.getAttribute("message");
 if(str!=null)
	 out.print(str);
 studentpojo st=(studentpojo) request.getAttribute("object");
%>

<h1><a href="logout.ser">LOGOUT</a></h1>


 <form>
   <fieldset style="color: blue; font-style: italic; background-color: orange;" >
     <legend style="color: background; font-style: italic; font-size: xx-large;">Enter Student Data</legend>
     <center>
     Student Id :::<input type="text" name="id" value="<% if(st!=null){ out.print(st.getId());}%>"><br>
     Student Name :::<input type="text" name="name" value="<% if(st!=null){ out.print(st.getName());}%>"><br>
     Student Age :::::<input type="text" name="age"  value="<% if(st!=null){ out.print(st.getAge());}%>"><br>
     Student Quel ::::<input type="text" name="quel" value="<% if(st!=null){ out.print(st.getQuel());}%>"><br>
     Student Cell :::::<input type="text" name="cell"  value="<% if(st!=null){ out.print(st.getCell());}%>"><br>
    
     <input type="button" value="SaveData" onclick="save()">
     
     <input type="button" value="Delete" onclick="sdelete()">
     
     <input type="button" value="Update" onclick="update()">
     
     <input type="submit" value="GetAll" onclick="getall()">
     </center>

   </fieldset>
   <p style="color: green"></p>
 </form>
 
 <form action="get.ser">
 
 <%
 studentpojo std = (studentpojo) request.getAttribute("details");
 %>
   <fieldset style="color: maroon; font-style: italic; background-color: buttonhighlight;">
     <legend>GET NAME</legend>
     Enter Student Name:::<input type="text" name="getname">
     <input type="submit" value="GetDetailes">
     
     <table border="2">
     <tr>
     <th>Id</th>
     <th>Name</th>
     <th>Address</th>
      <th>Cell</th>
      </tr>
      <tr style="color: green;">
      <td><%if(std!=null){out.print(std.getId());} %></td>
       <td><%if(std!=null){out.print(std.getName());} %></td>
       <td><%if(std!=null){out.print(std.getAge());} %></td>
        <td><%if(std!=null){out.print(std.getQuel());} %></td>
         <td><%if(std!=null){out.print(std.getCell());} %></td>
         </tr>
     
     </table>
   </fieldset>
 
 </form>

</body>
</html>