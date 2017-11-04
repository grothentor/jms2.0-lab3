<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
  </head>
  <body>
  <div>
    <a target="_blank" href="/messages">Messages</a>
    <form action="lab3" method="post">
      <input type="hidden" name="service" value="sender"/>
      <p>
        Text: <input type="text" name="text" />
      </p>
      <p>
        <input type="submit" value="SEND"/>
      </p>
    </form>
  </div>
  <p>
    <c:if test="${error ne null}">
      ${error}
    </c:if>
  </p>
  </body>
</html>
