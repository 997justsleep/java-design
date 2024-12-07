<%@ page import="zxr.design.jsp.pub.pojo.Market" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/5
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            <th>追踪</th>
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
                <a href="#" onclick="return confirm('确定要购买该物品吗？')">购买</a>
            </td>
            <td>
                <a href="#">查看该用户其他上架物品</a>
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
        <a href="<%=request.getContextPath()%>/normal/pagingMarket?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/normal/pagingMarket?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/normal/pagingMarket?page=<%=currentPage + 1%>">下一页</a>
        <% } %>
    </div>

    <form action="./normalMain.jsp" method="POST">
        <button type="submit">返回主页</button>
    </form>
    <br/>
    <br/>
    <form action="/buff/login.jsp" method="POST">
        <button type="submit">退出登录</button>
    </form>
</body>
</html>
