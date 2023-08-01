<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>

  </head>
  
<body>
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size:24px; color:#666"> Department Management</td>
		</tr>
		<tr>
			<td align="right" > <a href="${pageContext.request.contextPath}/department_saveUI.action">Add</a></td>
		</tr>
	</table>
	
	<br/>
	
	<table >
	<thead>
	   <tr><th width="450">Department Name</th><th  width="450">Edit</th><th  width="450">Delete</th></tr>
	</thead>
	<tbody>
		
		<s:iterator value="list" var="d">
			<tr>
				<td align="center"><s:property value="#d.dname"/></td>
				<td align="center"><a href="${pageContext.request.contextPath }/department_edit.action?did=<s:property value="#d.did"/>"/>EDIT</a></td>
				<td align="center"><a href="${pageContext.request.contextPath }/department_delete.action?did=<s:property value="#d.did"/>"/>DELETE</a></td>
	
			</tr>
		</s:iterator>
	
	</tbody>
	</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span><s:property value="currPage"/>/<s:property value="totalPage"/>th page</span>&nbsp;&nbsp;
   <span>total records：<s:property value="totalCount"/>&nbsp;&nbsp;per page:<s:property value="pageSize"/></span>&nbsp;&nbsp;
   <span>
   <s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=1">[first]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">[previous]</a>&nbsp;&nbsp;
   </s:if>
   
   <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">[next]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">[end]</a>&nbsp;&nbsp;
   </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>
