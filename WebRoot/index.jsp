<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta charset="utf-8">
<title>Please Login</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
<!--[if IE 6]>

<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
</head>

<body bgcolor="#FFCC99">
<div >
	<div >
		<div >
			
			<h3 style="text-align:center;" class="welcome_title">Please Login</h3>
		</div>
	</div>
</div>
<s:form action="employee_login" method="post" namespace="/" theme="simple">
<br><br><br><br><br><br><br><br><br><br>
<div class="loginBox">

	<div class="login_cont" style="text-align:center;">
		<div class="login">
			<label >Username</label>
			<input type="text" name="username" class="login_input"/>
			<br/>
			<label >Password</label>
			<input type="password" name="password" class="login_input"/>
			<br/>
			<input type="submit" value="Login" class="login_btn"/>
			<h4><s:actionerror/></h4>
		</div>
		
	</div>
	
</div>
</s:form>



</body>
</html>