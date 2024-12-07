<%@ page import="java.util.List" %>
<%@ page import="zxr.design.jsp.pub.pojo.Sell" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/5
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易</title>
</head>
<body>
    <h2>交易记录</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>卖家</th>
            <th>买家</th>
            <th>枪型</th>
            <th>皮肤名</th>
            <th>交易价格</th>

        </tr>
        </thead>
        <tbody>
        <%
            List<Sell> sellList = (List<Sell>) request.getAttribute("sellList");
            if(sellList != null && !sellList.isEmpty()){
                for (int i = 0; i < 10; i++) {
                    Sell sell = sellList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=sell.getFrom()%></td>
            <td><%=sell.getTo()%></td>
            <td><%=sell.getGuntype()%></td>
            <td><%=sell.getSkinname()%></td>
            <td><%=sell.getMoney()%></td>
        </tr>
        <%
                }
            }else{
        %>
        <tr>
            <td colspan="6">暂无交易数据</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <br />
    <%
        int currentPage = (int) request.getAttribute("currentPage");
        int totalPages = (int) request.getAttribute("totalPages");
    %>

    <div>
        <% if (currentPage > 1) { %>
        <a href="<%=request.getContextPath()%>/admin/pagingSell?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/admin/pagingSell?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/admin/pagingSell?page=<%=currentPage + 1%>">下一页</a>
        <% } %>
    </div>

    <form action="./adminMain.jsp" method="POST">
        <button type="submit">返回主页</button>
    </form>
    <br/>
    <br/>
    <form action="/buff/login.jsp" method="POST">
        <button type="submit">退出登录</button>
    </form>
</body>
</html>
