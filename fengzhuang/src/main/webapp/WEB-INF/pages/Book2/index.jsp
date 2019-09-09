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
<script type="text/javascript">
function del(id){
	if(confirm("删除？")){
		open("delete?id="+id,'_self');
	}
}

</script>

<form action="index" method="post">
	<input name="txt">
	<button type="submit">查询</button>
	<button type="button" onclick="window.open('add','_self');">新增</button>
</form> 
<table>
<tr><td>名称</td><td>性别</td><td>类型</td><td>功能</td></tr>
 <c:forEach items="${list}" var="row">
 <tr><td>${row.name}</td>
 <td>${row.sexname}</td>
 <td>${row.typename}</td>
 <td>
 <a href="javascript:del(${row.id})">删除</a> 
 <a href="edit?id=${row.id}">修改</a>
 </td>
 </tr>
 </c:forEach>
</table>

</body>
</html>