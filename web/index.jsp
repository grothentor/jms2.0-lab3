<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
  </head>
  <body>
  <div>
    <form action="lab3" method="post">
      <input type="hidden" name="service" value="sender"/>
      <p>
        Text: <input type="text" name="text" />
      </p>
      <p>
        <input type="submit" value="SEND"/>
      </p>
    </form>
    <form action="lab3" method="post">
      <input type="hidden" name="service" value="receiver"/>
      <p>
        <input type="submit" value="Receive" />
      </p>
    </form>
  </div>
  <p>
    <c:if test="${text ne null}">
      Receiver message: ${text}
    </c:if>
  </p>
  <p>
    <c:if test="${error ne null}">
      ${error}
    </c:if>
  </p>
  </body>
</html>
