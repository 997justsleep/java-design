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
    <a href="/buff/normal/inventory.jsp">查看我的库存</a>|
    <a href="/buff/normal/market.jsp">查看市场</a>|
    <a href="/buff/normal/share.jsp">查看玩家分享</a>|
    <a href="/buff/normal/sell.jsp">查看我的出售记录</a>

</body>
</html>
