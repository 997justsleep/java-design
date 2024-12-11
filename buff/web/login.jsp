<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/4
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/buff/login" method="post">
    账号：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/><br/>
    <a href="regist.jsp">什么？！没有账号？点击此处注册</a>
</form>
</body>
</html>
