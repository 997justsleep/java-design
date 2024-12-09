<%@ page import="zxr.design.jsp.pub.pojo.Inventory" %>
<%@ page import="java.util.List" %><%--
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
            <th>在售</th>
            <th>市场</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            String userid = (String)session.getAttribute("userid");
            int currentPage = (int) session.getAttribute("currentPage");
            int totalPages = (int) session.getAttribute("totalPages");
        %>
        <%
            List<Inventory> invenList = (List<Inventory>) session.getAttribute("invenList");
            String sellstatus = (String)session.getAttribute("sellstatus");
            if(invenList != null && !invenList.isEmpty()){
                for (int i = 0; i < invenList.size(); i++) {
                    Inventory inventory = invenList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=inventory.getGuntype()%></td>
            <td><%=inventory.getSkinname()%></td>
            <td><%=inventory.getSelling()%></td>
            <td>
                <form action="/buff/normal/queryMarket" method="POST">
                    <input type="hidden" name="id" value="<%= inventory.getId() %>">
                    <input type="hidden" name="guntype" value="<%= inventory.getGuntype() %>">
                    <input type="hidden" name="skinname" value="<%= inventory.getSkinname() %>">
                    <input type="hidden" name="sellstatus" value="<%= inventory.getSelling() %>">
                    <button type="submit">查看该皮肤市场</button>
                </form>
            </td>
            <td>
                <%
                    if("true".equals(sellstatus)){
                %>
                <form action="/buff/normal/queryByid" method="POST">
                    <input type="hidden" name="id" value="<%= inventory.getId() %>">
                    <button type="submit">设置上架状态</button>
                </form>
                <%
                    }else{
                %>
                已被管理员禁止交易
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
            <td colspan="5">暂无数据</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br />
    <div>
        <%-- 上一页 --%>
        <% if (currentPage > 1) { %>
        <form action="<%=request.getContextPath()%>/normal/pagingInventory" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage - 1%>">
            <input type="hidden" name="userid" value="<%=userid%>">
            <input type="hidden" name="sellstatus" value="<%=sellstatus%>">
            <input type="submit" value="上一页">
        </form>
        <% } %>

        <%-- 页码 --%>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <form action="<%=request.getContextPath()%>/normal/pagingInventory" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=i%>">
            <input type="hidden" name="userid" value="<%=userid%>">
            <input type="hidden" name="sellstatus" value="<%=sellstatus%>">
            <input type="submit" value="<%=i%>">
        </form>
        <% } %>
        <% } %>

        <%-- 下一页 --%>
        <% if (currentPage < totalPages) { %>
        <form action="<%=request.getContextPath()%>/normal/pagingInventory" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage + 1%>">
            <input type="hidden" name="userid" value="<%=userid%>">
            <input type="hidden" name="sellstatus" value="<%=sellstatus%>">
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
