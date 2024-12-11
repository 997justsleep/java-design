<%@ page import="zxr.design.jsp.pub.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/5
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
</head>
    <%
        User user = (User)session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/buff/login.jsp"); // 如果没有 user 对象，跳转到登录页
            return;
        }
    %>
    <h1>你好<%=user.getUsername()%>   欢迎登录BUFF系统</h1>
    <h2>我的交易状态是：<%if("true".equals(user.getSellstatus())){%>
        可交易
        <%}else{%>
        不可交易
        <%}%></h2>

    <form action="/buff/normal/pagingInventory" method="POST">
        <input type="hidden" name="userid" value="<%= user.getId() %>">
        <input type="hidden" name="sellstatus" value="<%= user.getSellstatus() %>">
        <button type="submit">查看我的库存</button>
    </form>

    <form action="/buff/normal/pagingMarket" method="POST">
        <input type="hidden" name="userid" value="<%= user.getId() %>">
        <input type="hidden" name="sellstatus" value="<%= user.getSellstatus() %>">
        <button type="submit">查看市场</button>
    </form>
    <form action="/buff/normal/pagingEvaluation" method="POST">
        <input type="hidden" name="userid" value="<%= user.getId() %>">
        <input type="hidden" name="username" value="<%= user.getUsername() %>">
        <button type="submit">交易评价</button>
    </form>

    <form action="/buff/normal/pagingSell" method="POST">
        <input type="hidden" name="userid" value="<%= user.getId() %>">
        <input type="hidden" name="sellstatus" value="<%= user.getSellstatus() %>">
        <button type="submit">我的交易记录</button>
    </form>
    <br/>
    <br/>
    <br/>
    <form action="/buff/login.jsp" method="POST">
        <button type="submit">退出登录</button>
    </form>

</body>
</html>
