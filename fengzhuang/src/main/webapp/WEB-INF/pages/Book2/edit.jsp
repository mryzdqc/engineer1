<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:if test="${info==null}">
<form action="insert" method="post">
</c:if>
<c:if test="${info!=null}">
<form action="update" method="post">
<input type="hidden" name="id" value="${info.id}">
</c:if>
<input name="name" value="${info.name}">
<select name="sex">
	<c:forEach items="${sexs}" var="r" varStatus="v">
		<c:if test="${info.sex!=v.index}">
			<option value="${v.index}">${r}</option>
		</c:if>
		<c:if test="${info.sex==v.index}">
			<option value="${v.index}" selected="selected">${r}</option>
		</c:if>
		
	</c:forEach>
</select>

<select name="typeid">
	<c:forEach items="${typelist}" var="r" >
		<c:if test="${info.typeid!=r.id}">
			<option value="${r.id}">${r.name}</option>
		</c:if>
		<c:if test="${info.typeid==r.id}">
			<option value="${r.id}" selected="selected">${r.name}</option>
		</c:if>
		
	</c:forEach>
</select>
<input type="submit">
</form>
</body>
</html>