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
            <th>市场</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Inventory> invenList = (List<Inventory>) request.getAttribute("invenList");
            if(invenList != null && !invenList.isEmpty()){
                for (int i = 0; i < invenList.size(); i++) {
                    Inventory inventory = invenList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=inventory.getGuntype()%></td>
            <td><%=inventory.getSkinname()%></td>
            <td>
                <a href="#">查看该皮肤市场</a>
            </td>
            <td>
                <a href="#" onclick="return confirm('确定要上架该物品吗？')">上架</a>
            </td>

        </tr>
        <%
            }
        }else{
        %>
        <tr>
            <td colspan="3">暂无数据</td>
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
        <a href="<%=request.getContextPath()%>/normal/pagingInventory?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/normal/pagingInventory?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/normal/pagingInventory?page=<%=currentPage + 1%>">下一页</a>
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
