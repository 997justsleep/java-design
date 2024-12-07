<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/7
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的库存</title>
</head>
<body>
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
    <a href="./normalMain.jsp">返回主页</a>
</body>
</html>
