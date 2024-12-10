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
    <title>市场</title>
</head>
<body>
<%
    String sellstatus = (String)session.getAttribute("sellstatus");
    String userid = (String)session.getAttribute("userid");
%>
<h2>市场情况</h2>
<h3>按枪型筛选</h3>
<form action="/buff/normal/selectMarket" method="post">
    枪型：<input type="text" name="guntype"/>
    皮肤：<input type="text" name="skinname"/>
    <input type="hidden" name="sellstatus" value="<%=sellstatus%>">
    <input type="hidden" name="userid" value="<%=userid%>">
    <input type="submit" value="筛选"/>
    <input type="reset" value="重置"/><br/>
</form>
<table border="1">
    <thead>
    <tr>
        <th>序号</th>
        <th>卖家</th>
        <th>枪型</th>
        <th>皮肤</th>
        <th>价格/元</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Market> marketList = (List<Market>) session.getAttribute("marketList");
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
            <form action="/buff/admin/unsell" method="POST">
                <input type="hidden" name="marketid" value="<%= market.getId() %>">
                <input type="hidden" name="marketfrom" value="<%= market.getFrom() %>">
                <input type="hidden" name="guntype" value="<%= market.getGuntype() %>">
                <input type="hidden" name="skinname" value="<%= market.getSkinname() %>">
                <input type="hidden" name="marketprice" value="<%= market.getPrice() %>">
                <button type="button" onclick="if (confirm('确定要下架该物品吗？')) { this.form.submit(); }">下架</button>
            </form>
        </td>
    </tr>
    <%
        }
    }else{
    %>
    <tr>
        <td colspan="6">暂无数据</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<br />
<%
    int currentPage = (int) session.getAttribute("currentPage");
    int totalPages = (int) session.getAttribute("totalPages");
%>
<div>
    <%-- 上一页 --%>
    <% if (currentPage > 1) { %>
    <form action="<%=request.getContextPath()%>/admin/pagingMarket" method="POST" style="display:inline;">
        <input type="hidden" name="page" value="<%=currentPage - 1%>">
        <input type="submit" value="上一页">
    </form>
    <% } %>

    <%-- 页码 --%>
    <% for (int i = 1; i <= totalPages; i++) { %>
    <% if (i == currentPage) { %>
    <span><%=i%></span>
    <% } else { %>
    <form action="<%=request.getContextPath()%>/admin/pagingMarket" method="POST" style="display:inline;">
        <input type="hidden" name="page" value="<%=i%>">
        <input type="submit" value="<%=i%>">
    </form>
    <% } %>
    <% } %>

    <%-- 下一页 --%>
    <% if (currentPage < totalPages) { %>
    <form action="<%=request.getContextPath()%>/admin/pagingMarket" method="POST" style="display:inline;">
        <input type="hidden" name="page" value="<%=currentPage + 1%>">
        <input type="submit" value="下一页">
    </form>
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
