<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	function login() {
		alert("this is login functionality ....");
		document.forms[0].action = "login.ser";
		document.forms[0].submit();
	}
	function signup() {
		document.forms[0].action = "signpage.ser";
		document.forms[0].submit();
	}
</script>
</head>
<body style="background-image: url('Images/flowers.jpg');">
	<%
		String str1 = (String) request.getAttribute("ff");
		if (str1 != null) {
			out.print(str1);
		}
	%>

	<h1 style="color: blue">LOGIN PAGE</h1>

	<%
		String str = (String) request.getAttribute("message");
		if (str != null) {
			out.print(str);
		}
	%>
	<form>
<fieldset>
<center>
Username::<input type="text" name="username"><br>
Password::<input type="password" name="password"><br>
<input type="button" value="Login" onclick="login()">
<input type="button" value="signup" onclick="signup()"><br>

<a href="forgot.ser">ForGot Password</a><br>
<a href="changepwd.ser">Change Password</a>

</center>
</fieldset>
</form>

</body>
</html>