<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<body>
<table border="0" width="600px">
	<tr>
	<td align="center" style="font-size:24px; color:#666">Edit Department</td>
	</tr>

</table>
<br/>
<br>
<s:form id="saveForm" action="department_update" method="post" namespace="/" theme="simple">
	<s:hidden name="did" value="%{model.did}"/>
	<table style="font-size::16px">
		<tr>
		  <td>Department Name：</td>
		  <td><s:textfield name="dname" value="%{model.dname}"/></td>
		</tr>
		<tr>
		  <td>Department Intro：</td>
		  <td></td>
		</tr>
		<tr>
		  <td width="10%"></td>
		  <td>
		     <s:textarea rows="5" cols="40" name="dintro" value="%{model.dintro}"/>
		  </td>
		</tr>
		<tr>
			<td align="right" > 
				<a href="javascript:document.getElementById('saveForm').submit()">Save</a> &nbsp;&nbsp;
				<a href="javascript:history.go(-1)">Return</a>
			</td>
		</tr>
	</table>
</s:form>
</body>
</html>
