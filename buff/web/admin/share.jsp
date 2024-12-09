<%@ page import="zxr.design.jsp.pub.pojo.Share" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/7
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>玩家分享</title>
</head>
<body>
    <h2>玩家分享</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户id</th>
            <th>用户名</th>
            <th>时间</th>
            <th>内容</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Share> shareList = (List<Share>) request.getAttribute("shareList");
            if(shareList != null && !shareList.isEmpty()){
                for (int i = 0; i < 10; i++) {
                    Share share = shareList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=share.getUserid()%></td>
            <td><%=share.getUsername()%></td>
            <td><%=share.getTime()%></td>
            <td><%=share.getContent()%></td>
            <td>
                <a href="#" onclick="return confirm('确定要删除改分享？')">删除</a>
            </td>
        </tr>
        <%
            }
        }else{
        %>
        <tr>
            <td colspan="5">暂无交易数据</td>
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
        <a href="<%=request.getContextPath()%>/admin/pagingShare?page=<%=currentPage - 1%>">上一页</a>
        <% } %>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/admin/pagingShare?page=<%=i%>"><%=i%></a>
        <% } %>
        <% } %>
        <% if (currentPage < totalPages) { %>
        <a href="<%=request.getContextPath()%>/admin/pagingShare?page=<%=currentPage + 1%>">下一页</a>
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
