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
    
    <title>add.jsp</title>
    

  </head>
<body>

<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">Add Employee</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">Save</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">Return</a>
</td>
</tr>
</table>
<br/>

<s:form id="saveForm" action="employee_save" method="post" namespace="/" theme="simple">
	<table border='0' cellpadding="0"  cellspacing="10">

		<tr>
	
		 <td>Name：</td>
		 <td><s:textfield  name="ename"/></td>
		 <td>Gender：</td>
		 <td><s:radio list="{'Male','Female'}" value="%{model.egender}" name="egender"/></td>
		 <!--
		 <td>Birth：</td>
		 <td><input type="date" name="ebirth" value="<s:date name="model.ebirth" format="yyyy-MM-dd"/>"></td>
		
		 <td>Birth：</td>
		 <td><s:date name="ebirth" format="yyyy-MM-dd"/></td>
		-->
		
		</tr>

		<tr>
		  <td>Username：</td>
		  <td><s:textfield name="username"/></td>
		  
		  <td>Password：</td>
		  <td><s:password  name="password" /></td>
		</tr>
		<tr>
		  <td>NO.：</td>
		  <td><s:textfield  name="eno"/></td>
		  
		  <td>Department：</td>
		  <td><s:select name="department.did" headerKey=""  headerValue="---SELECT---" list="list" listKey="did" listValue="dname"/></td>
		</tr>
	</table>
</s:form>

</body>
</html>
