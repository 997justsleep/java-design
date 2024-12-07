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

    <form action="/buff/admin/pagingUser" method="POST">
        <input type="hidden" name="username" value="<%= user.getUsername() %>">
        <button type="submit">查看用户</button>
    </form>
    <form action="/buff/admin/pagingMarket" method="POST">
        <input type="hidden" name="username" value="<%= user.getUsername() %>">
        <button type="submit">查看市场</button>
    </form>
    <form action="/buff/admin/pagingSell" method="POST">
        <input type="hidden" name="username" value="<%= user.getUsername() %>">
        <button type="submit">查看出售记录</button>
    </form>
    <form action="/buff/admin/pagingShare" method="POST">
        <input type="hidden" name="username" value="<%= user.getUsername() %>">
        <button type="submit">玩家秀</button>
    </form>
    <br/>
    <br/>
    <form action="/buff/login.jsp" method="POST">
        <button type="submit">退出登录</button>
    </form>
    </body>
</html>