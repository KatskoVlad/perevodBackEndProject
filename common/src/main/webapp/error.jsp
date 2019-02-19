<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 05.02.2019
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>An error has occurred.</h1>

<div style="color: #F00;">
    Error message: <%=exception.toString() %>
</div>
<br>
<div class="back-button"><p><a href="index.jsp">Back</a></p></div>
</body>
</html>
