<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2022/3/17
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <title>首页</title>
</head>
<body>
<div class="container">

</div>

<script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"/>
<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"/>
</body>
</html>
