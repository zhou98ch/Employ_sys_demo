<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px}
</style>
</head>

<body bgcolor="#FFCCCC">
<div class="div1">
<font size="10">WELCOME!  <s:property value="#session.currentEmployee.ename" /> </font>
</div>
</body>
</html>
 