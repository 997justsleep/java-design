<%@ page import="zxr.design.jsp.pub.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/6
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户</title>
</head>
    <body>
    <h2>用户数据</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>身份</th>
            <th>交易状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> userList = (List<User>) request.getAttribute("userList");
            if (userList!= null &&!userList.isEmpty()) {
                for (int i = 0; i < userList.size(); i++) {
                    User user1 = userList.get(i);
        %>
        <tr>
            <td><%=i + 1%></td>
            <td><%=user1.getUsername()%></td>
            <td><%=user1.getAtrribute()%></td>
            <td><%=user1.getSellstatus()%></td>
            <td>
                <a href="#" onclick="return confirm('确定要禁止该用户交易吗？')">禁止交易</a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">暂无用户数据</td>
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
        <a href="<%=request.getContextPath()%>/admin/pagingUsers?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/admin/pagingUsers?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/admin/pagingUsers?page=<%=currentPage + 1%>">下一页</a>
        <% } %>
    </div>
    </body>
</html>
