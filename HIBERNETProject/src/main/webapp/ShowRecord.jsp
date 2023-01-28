<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>ID</td>
<td>NAME</td>
<td>ADDRESS</td>
<td>MOBILE</td>
</tr>
<c:forEach var="row" items="${list}">
<tr>
<td>${row.id}</td>
<td>${row.empname}</td>
<td>${row.empaddress}</td>
<td>${row.empmobile}</td>
</tr>
</c:forEach>
</table>
</body>
</html>