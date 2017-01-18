<%@ page import="JavaBeans.Entity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%--
  Created by IntelliJ IDEA.
  User: Gaurav
  Date: 14/01/17
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Entity Created</title>
</head>
<body>
Entity with name ${sessionScope.Entity.name} created<br />
<c:forEach items="${sessionScope.Entity.entries}" var="entry">
    <tr>
        <td>${entry.value}  :    </td>
        <c:forEach items="${entry.synonyms}" var="synonyms">
            <td>${synonyms}</td>
        </c:forEach>
    </tr>
    <br />
</c:forEach>

<form action="success" method="post">
    <input type = "hidden" name = "entry" value = '${sessionScope.Entity}' >
    <input type="submit" value="Submit">
</form>
<form action="." method="post">
    <input action="action" type="button" value="Back" onclick="history.go(-1);" />
</form>
</body>
</html>
