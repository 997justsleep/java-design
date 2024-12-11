<%@ page import="zxr.design.jsp.pub.pojo.Evaluation" %>
<%@ page import="zxr.design.jsp.pub.pojo.Sell" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/11
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细信息</title>
</head>
<body>
    <table border="1">
        <thead>
        <tr>
            <th>评价id</th>
            <th>交易id</th>
            <th>卖家id</th>
            <th>买家id</th>
            <th>枪型</th>
            <th>皮肤名</th>
            <th>金额</th>
            <th>评价</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            Evaluation evaluation = (Evaluation)session.getAttribute("evaluation");
            Sell sell = (Sell)session.getAttribute("sell");
        %>
        <tr>
            <td><%=evaluation.getId()%></td>
            <td><%=sell.getId()%></td>
            <td><%=sell.getFrom()%></td>
            <td><%=sell.getTo()%></td>
            <td><%=sell.getGuntype()%></td>
            <td><%=sell.getSkinname()%></td>
            <td><%=sell.getMoney()%></td>
            <td><%=evaluation.getContent()%></td>
            <td>
                <form action="/buff/admin/deleva" method="POST">
                    <input type="hidden" name="evaid" value="<%= evaluation.getId() %>">
                    <input type="hidden" name="page" value="<%= session.getAttribute("page") %>">
                    <button type="button" onclick="if (confirm('确定要删除吗？')) { this.form.submit(); }">删除</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <br/>
    <br/>
    <br/>
    <form action="/buff/admin/evaluation.jsp" method="POST">
        <button type="submit">返回</button>
    </form>
</body>
</html>
