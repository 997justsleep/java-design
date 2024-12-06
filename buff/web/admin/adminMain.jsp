<%@ page import="zxr.design.jsp.pub.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
</head>
    <body>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <h1>你好<%=user.getUsername()%>管理员   欢迎登录BUFF系统</h1>


    <form action="">
        <a href="admin/pagingUsers">查看用户</a> |
        <a href="admin/market.jsp">查看市场</a> |
        <a href="admin/sell.jsp">查看出售记录</a>
    </form>
    </body>
</html>