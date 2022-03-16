<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2022/3/17
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:forward page="/emps"/>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--上面3个meta标签必须放在最前面--%>
<%--    web路径问题
    不以/开始的是相对路径，以当前资源的路径为基准，容易出现问题
    以/开始的是绝对路径，以服务器根路径为基准，推荐使用
    --%>
    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<%--    引入Bootstrap的CSS资源--%>
    <link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet"/>

    <title>首页</title>
</head>
<body>

<h1>Hello World</h1>
<%--jQuery (Bootstrap)的所有JavaScript插件都依赖jQuery,所有要放前面--%>
<script src="${App_PATH}/static/js/jquery-1.12.4.min.js"/>
<%--加载 Bootstrap 的所有 JavaScript 插件。可以根据需要只加载单个插件。 --%>
<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"/>

</body>
</html>
