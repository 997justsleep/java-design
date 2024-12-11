<%@ page import="zxr.design.jsp.pub.pojo.Evaluation" %>
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
    <title>评价</title>
</head>
<body>
    <h2>评价</h2>
    <table border="1">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户id</th>
            <th>交易id</th>
            <th>内容</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Evaluation> evaluationList = (List<Evaluation>) session.getAttribute("evaluationList");
            if(evaluationList != null && !evaluationList.isEmpty()){
                for (int i = 0; i < evaluationList.size(); i++) {
                    Evaluation evaluation = evaluationList.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=evaluation.getUserid()%></td>
            <td><%=evaluation.getSellid()%></td>
            <td><%=evaluation.getContent()%></td>
            <td>
                <form action="/buff/admin/evaconnsell" method="POST">
                    <input type="hidden" name="evaid" value="<%= evaluation.getId() %>">
                    <input type="hidden" name="userid" value="<%= evaluation.getUserid()%>">
                    <input type="hidden" name="sellid" value="<%= evaluation.getSellid() %>">
                    <input type="hidden" name="content" value="<%= evaluation.getContent() %>">
                    <button type="submit">查看详细交易信息</button>
                </form>
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
        int currentPage = (int) session.getAttribute("currentPage");
        int totalPages = (int) session.getAttribute("totalPages");
    %>

    <div>
        <%-- 上一页 --%>
        <% if (currentPage > 1) { %>
        <form action="<%=request.getContextPath()%>/admin/pagingEvaluation" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=currentPage - 1%>">
            <input type="submit" value="上一页">
        </form>
        <% } %>

        <%-- 页码 --%>
        <% for (int i = 1; i <= totalPages; i++) { %>
        <% if (i == currentPage) { %>
        <span><%=i%></span>
        <% } else { %>
        <form action="<%=request.getContextPath()%>/admin/pagingEvaluation" method="POST" style="display:inline;">
            <input type="hidden" name="page" value="<%=i%>">
            <input type="submit" value="<%=i%>">
        </form>
        <% } %>
        <% } %>

        <%-- 下一页 --%>
        <% if (currentPage < totalPages) { %>
        <form action="<%=request.getContextPath()%>/admin/pagingEvaluation" method="POST" style="display:inline;">
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
