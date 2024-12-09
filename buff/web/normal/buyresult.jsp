<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/9
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
    <%=
    request.getAttribute("result")
    %>
<a href="/buff/normal/market.jsp">返回</a>
</body>
</html>