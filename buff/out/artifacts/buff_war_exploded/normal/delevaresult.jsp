<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/11
  Time: 16:33
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
<a href="/buff/normal/evaluation.jsp">返回</a>
</body>
</html>
