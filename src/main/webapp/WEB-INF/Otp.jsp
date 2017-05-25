<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('Images/nat.jpg');">

Welcome to Mr/Ms::<%=session.getAttribute("key") %>


<form action="otpservlet.ser">

<fieldset>
<legend>OTP</legend>

<center>
Enter u r otp::<input type="text" name="otpuser"><br>
<input type="submit" value="SUBMIT"><br>

<a href="resendotp.ser">Resend OTP</a><br>

<%String str = (String)request.getAttribute("key");
if(str!=null){
	out.print(str);
}
%>

</center>

</fieldset>

</form>
</body>
</html>