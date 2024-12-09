<%@ page import="zxr.design.jsp.pub.pojo.Inventory" %><%--
  Created by IntelliJ IDEA.
  User: 50434
  Date: 2024/12/8
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上架</title>
</head>
<body>
    <h2>上架皮肤</h2>
    <%
        Inventory inventory = (Inventory) request.getAttribute("inventory");
    %>
    枪型：<%=inventory.getGuntype()%>
    皮肤：<%=inventory.getSkinname()%>
    在售：<%=inventory.getSelling()%>
    <%
        if("false".equals(inventory.getSelling())){
    %>
    <form action="/buff/normal/sellskin" method="post">
        <input type="hidden" name="type" value="sell">
        <input type="hidden" name="id" value="<%=inventory.getId()%>">
        <input type="hidden" name="from" value="<%=inventory.getBelong()%>">
        <input type="hidden" name="guntype" value="<%=inventory.getGuntype()%>">
        <input type="hidden" name="skin" value="<%=inventory.getSkinname()%>">
        价格：<input type="text" name="price"/><br/>
        <input type="submit" value="上架"/>
    </form>
    <%
        }else{
    %>
    <form action="/buff/normal/sellskin" method="post">
        <input type="hidden" name="type" value="unsell">
        <input type="hidden" name="id" value="<%=inventory.getId()%>">
        <input type="hidden" name="from" value="<%=inventory.getBelong()%>">
        <input type="hidden" name="guntype" value="<%=inventory.getGuntype()%>">
        <input type="hidden" name="skin" value="<%=inventory.getSkinname()%>">
        <input type="submit" value="下架"/>
    </form>
    <%
        }
    %>
</body>
</html>
