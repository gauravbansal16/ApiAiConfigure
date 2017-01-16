<%@ page import="JavaBeans.Entity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
Entity with name ${Entity.name} created<br />
<c:forEach items="${Entity.entries}" var="entry">
    <tr>
        <td>${entry.value}  :    </td>
        <c:forEach items="${entry.synonyms}" var="synonyms">
            <td>${synonyms}</td>
        </c:forEach>
    </tr>
    <br />
</c:forEach>
</body>
</html>
