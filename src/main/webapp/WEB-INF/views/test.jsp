<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
	<h2>你好</h2>
	<table>
	<tr><td>编号</td><td>姓名</td><td>密码</td>
	</tr>
	<c:forEach var="user" items="${users}">
	<tr><td>${user.id}</td><td>${user.name}</td><td>${user.password}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>
