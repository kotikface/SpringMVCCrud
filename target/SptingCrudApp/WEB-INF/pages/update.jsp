
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: SmartBook
  Date: 07.05.2020
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="POST">
    <h2> Update user </h2>

    <input type="text" name="id" hidden  value='${userById.id}'/>
    <input type="text" name="name"   value='${userById.name}'/>
    <input type="text" name="password"   value='${userById.password}'/>
    <input type="text" name="age"  value='${userById.age}'/>
    <input type="text" name="roles" value=${userById.roles}>
    <button type="submit" formaction="/admin/update">UPDATE</button>
</form>
</body>
</html>