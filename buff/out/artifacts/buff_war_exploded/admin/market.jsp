<%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/5
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>市场</title>
</head>
<body>
    <h2>市场情况</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>卖家</th>
            <th>枪型</th>
            <th>皮肤</th>
            <th>价格</th>
            <th>操作</th>

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
            <td>数据 <%=i%> - 3</td>
            <td>数据 <%=i%> - 4</td>
            <td>
                <a href="" onclick="return a()">下架</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <a href="./adminMain.jsp">返回主页</a>
</body>
</html>
