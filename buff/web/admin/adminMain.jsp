<%@ page import="zxr.design.jsp.pub.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
</head>
    <body>
    <%
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/buff/login.jsp"); // 如果没有 user 对象，跳转到登录页
            return;
        }
    %>
    <h1>管理员<%=user.getUsername()%>,你好  欢迎登录BUFF系统</h1>
    <a href="/buff/admin/pagingUsers">查看用户</a> |
    <a href="/buff/admin/market.jsp">查看市场</a> |
    <a href="/buff/admin/sell.jsp">查看出售记录</a>|
    <a href="/buff/admin/share.jsp">查看玩家分享</a>

    </body>
</html>