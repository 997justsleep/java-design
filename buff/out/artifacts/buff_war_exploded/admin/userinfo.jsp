<%@ page import="zxr.design.jsp.pub.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/10
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <h2>用户信息</h2>
    <%
        User user = (User) request.getAttribute("user");
    %>
    用户id：<%=user.getId()%><br/>
    用户名：<%=user.getUsername()%><br/>
    身份：<%=user.getAtrribute()%><br/>
    交易状态：<%=user.getSellstatus()%><br/>
    <%
        if("false".equals(user.getSellstatus())){
    %>
    <form action="/buff/admin/deal" method="post">
        <input type="hidden" name="userid" value="<%=user.getId()%>">
        <input type="hidden" name="status" value="<%=user.getSellstatus()%>">
        <button type="button" onclick="if (confirm('确定要允许该用户交易吗？')) { this.form.submit(); }">允许交易</button>
    </form>
    <%
    }else{
    %>
    <form action="/buff/admin/deal" method="post">
        <input type="hidden" name="userid" value="<%=user.getId()%>">
        <input type="hidden" name="status" value="<%=user.getSellstatus()%>">
        <button type="button" onclick="if (confirm('确定要禁止该用户交易吗？')) { this.form.submit(); }">禁止交易</button>
    </form>
    <%
        }
    %>
</body>
</html>
