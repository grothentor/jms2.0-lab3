<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<div>
    <a target="_blank" href="/lab3">Send message</a>
</div>
<p style="color: red;">
    <c:if test="${error ne null}">
        ${error}
    </c:if>
</p>
<c:forEach items="${messages}" var="message">
    <p>
        ${message}
    </p>
</c:forEach>
</body>
</html>
