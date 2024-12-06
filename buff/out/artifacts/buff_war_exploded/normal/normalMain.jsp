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
        User user = (User)request.getAttribute("user");
    %>
    <h1>你好<%=user.getUsername()%>   欢迎登录BUFF系统</h1>
    <h2>我的交易状态是：<%if("true".equals(user.getSellstatus())){%>
        可交易
        <%}else{%>
        不可交易
        <%}%></h2>
    <h2>我的库存</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>枪型</th>
            <th>皮肤</th>
            <th>查看该皮肤市场</th>
            <th>出售</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 1; i <= 10; i++) {
        %>
        <tr>
            <td><%=i%></td>
            <td>数据 <%=i%> - 1</td>
            <td>数据 <%=i%> - 2</td>
            <td>
                <a href="">查看市场</a>
            </td>
            <td>
                <a href="">上架</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <br />
    <form action="">
        <a href="normal/market.jsp">查看市场</a>|
        <a href="normal/sell.jsp">查看我的出售记录</a>
    </form>
</body>
</html>
