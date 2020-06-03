<%@ page import="web.service.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="web.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: SmartBook
  Date: 07.05.2020
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select</title>
</head>
<body>
<h2>CRUD</h2>
<form method="POST">
    <input type="text" name="name" placeholder="name"/>
    <input type="text" name="password" placeholder="password"/>
    <input type="text" name="age" placeholder="age"/>
    <input type="text" name="roles" placeholder="roles"/>
    <button type="submit" formaction="/admin/select">INSERT</button>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>age</th>
            <th>roles</th>
        </tr>
        <tbody>
        <!--   for (Todo todo: todos) {  -->
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                </td>


                <td>
                    <a href="/admin/update?id=${user.id}">Update</a>
                    <a href="/admin/delete?id=${user.id}">DELETE</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
<a href="/user">userINFO</a>
<a href="/logout">Logout</a>
</body>
</html>
