<%@ page import="java.util.List" %>
<%@ page import="zxr.design.jsp.pub.pojo.Market" %><%--
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
            List<Market> marketList = (List<Market>) request.getAttribute("marketList");
            if(marketList != null && !marketList.isEmpty()){
                for (int i = 0; i < marketList.size(); i++) {
                    Market market = marketList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=market.getFrom()%></td>
            <td><%=market.getGuntype()%></td>
            <td><%=market.getSkinname()%></td>
            <td><%=market.getPrice()%></td>
            <td>
                <a href="#" onclick="return confirm('确定要下架该物品吗？')">下架</a>
            </td>
        </tr>
        <%
                }
            }else{
        %>
        <tr>
            <td colspan="5">暂无数据</td>
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
        <a href="<%=request.getContextPath()%>/admin/pagingMarket?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/admin/pagingMarket?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/admin/pagingMarket?page=<%=currentPage + 1%>">下一页</a>
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
