<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 2017/10/24
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>学校管理</title>
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/extend/amazeui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/orgnm/schoolm.css">
    <script src="${pageContext.request.contextPath}/resources/js/extend/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/extend/amazeui/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/extend/knockout-3.4.2.js"></script>
    <%--<script src="../../js/home.js"></script>--%>
</head>
<body>
<div class="am-panel am-panel-primary">
    <header class="am-panel-hd">
        <h3 class="am-panel-title">XXX学期</h3>
    </header>
    <div class="am-panel-bd">
        面板内容
    </div>
</div>

<hr />

<div class="am-panel am-panel-default">
    <header class="am-panel-hd">
        <h3 class="am-panel-title">历史学期</h3>
    </header>
    <div class="am-panel-bd">
        <ul class="am-avg-lg-6 am-thumbnails">
            <li>
                <div class="am-thumbnail">
                    <img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" />
                    <h3 class="am-thumbnail-caption">图片标题 #1</h3>
                </div>
            </li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
            <li><img class="am-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg" /></li>
        </ul>
    </div>
</div>
</body>
</html>
