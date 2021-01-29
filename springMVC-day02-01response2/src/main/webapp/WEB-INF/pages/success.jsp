<%--
  Created by IntelliJ IDEA.
  User: 14767
  Date: 2021/1/25
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>执行成功</h3>
    ${requestScope.user.username}
    ${requestScope.user.password}
    ${requestScope.user.age}
</body>
</html>
