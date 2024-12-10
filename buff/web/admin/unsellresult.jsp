<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/10
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下架结果</title>
</head>
<body>
<%=
request.getAttribute("result")
%>
<a href="/buff/admin/market.jsp">返回</a>
</body>
</html>
