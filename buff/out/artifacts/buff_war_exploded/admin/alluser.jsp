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
            <th>用户id</th>
            <th>用户名</th>
            <th>身份</th>
            <th>交易状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> userList = (List<User>) session.getAttribute("userList");
            if (userList!= null &&!userList.isEmpty()) {
                for (int i = 0; i < userList.size(); i++) {
                    User user1 = userList.get(i);
        %>
        <tr>
            <td><%=user1.getId()%></td>
            <td><%=user1.getUsername()%></td>
            <td><%=user1.getAtrribute()%></td>
            <td><%=user1.getSellstatus()%></td>
            <td>
                <form action="/buff/admin/querybyid" method="POST">
                    <input type="hidden" name="userid" value="<%= user1.getId() %>">
                    <button type="submit">设置交易状态</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">暂无用户数据</td>
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
        <form action="<%=request.getContextPath()%>/admin/pagingUser" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage - 1%>">
            <input type="submit" value="上一页">
        </form>
        <% } %>

        <%-- 页码 --%>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <form action="<%=request.getContextPath()%>/admin/pagingUser" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=i%>">
            <input type="submit" value="<%=i%>">
        </form>
        <% } %>
        <% } %>

        <%-- 下一页 --%>
        <% if (currentPage < totalPages) { %>
        <form action="<%=request.getContextPath()%>/admin/pagingUser" method="POST" style="display:inline;">
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
