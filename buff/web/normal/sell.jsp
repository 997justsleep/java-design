<%@ page import="zxr.design.jsp.pub.pojo.Sell" %>
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
    <title>我的交易</title>
</head>
<body>
    <h2>我的交易记录</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>卖家</th>
            <th>买家</th>
            <th>枪型</th>
            <th>皮肤名</th>
            <th>交易价格</th>
            <th>操作</th>

        </tr>
        </thead>
        <tbody>
        <%
            List<Sell> sellList = (List<Sell>) session.getAttribute("sellList");
            String userid = (String)session.getAttribute("userid");
            int id = Integer.parseInt(userid);
            if(sellList != null && !sellList.isEmpty()){
                for (int i = 0; i < sellList.size(); i++) {
                    Sell sell = sellList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=sell.getFrom()%></td>
            <td><%=sell.getTo()%></td>
            <td><%=sell.getGuntype()%></td>
            <td><%=sell.getSkinname()%></td>
            <td><%=sell.getMoney()%></td>
            <td>
                <%
                    if(id == sell.getTo()){
                %>
                <form action="/buff/normal/addeva" method="POST">
                    <input type="hidden" name="sellid" value="<%= sell.getId() %>">
                    <input type="hidden" name="userid" value="<%= sell.getTo() %>">
                    <input type="text" name="content"/>
                    <button type="button" onclick="if (confirm('确定要添加评价吗？')) { this.form.submit(); }">添加评价</button>
                </form>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        }else{
        %>
        <tr>
            <td colspan="7">暂无交易数据</td>
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
        <form action="<%=request.getContextPath()%>/normal/pagingSell" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage - 1%>">
            <input type="submit" value="上一页">
        </form>
        <% } %>

        <%-- 页码 --%>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <form action="<%=request.getContextPath()%>/normal/pagingSell" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=i%>">
            <input type="submit" value="<%=i%>">
        </form>
        <% } %>
        <% } %>

        <%-- 下一页 --%>
        <% if (currentPage < totalPages) { %>
        <form action="<%=request.getContextPath()%>/normal/pagingSell" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage + 1%>">
            <input type="submit" value="下一页">
        </form>
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
