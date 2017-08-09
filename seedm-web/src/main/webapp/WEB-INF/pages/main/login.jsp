<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="登录页面">
  <meta name="keywords" content="login">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Amaze UI Examples</title>
  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">
  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="stylesheet" href="${pagecontext.request.contextPath}/seedm/resources/css/extend/amazeui.min.css">
  <link rel="stylesheet" href="${pagecontext.request.contextPath}/seedm/resources/css/login.css">
  <script src="${pagecontext.request.contextPath}/seedm/resources/js/extend/vue.min.js"></script>
  <script src="${pagecontext.request.contextPath}/seedm/resources/js/login.js"></script>
</head>
<body>
  <div class="header">
    <div class="am-g">
      <h1>Seed Manager</h1>
      <p>Integrated Development Environment<br/>代码编辑，代码生成，界面设计，调试，编译</p>
    </div>
    <hr />
  </div>
  <div id="loginForm" class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
      <form method="post" class="am-form" @submit.prevent>
        <div class="am-input-group">
          <span class="am-input-group-label"><i class="am-icon-user am-icon-fw"></i></span>
          <input type="text" class="am-form-field" placeholder="手机号码/用户ID/邮箱" v-model="account" />
        </div>

        <div class="am-input-group">
          <span class="am-input-group-label"><i class="am-icon-lock am-icon-fw"></i></span>
          <input type="text" class="am-form-field" placeholder="请输入密码" v-model="password" />
        </div>

        <label for="remember-me">
          <input id="remember-me" type="checkbox">记住密码
        </label>
        <br />
        <div class="am-cf">
          <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fl">
          <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fr" @click="login">
        </div>
      </form>
      <hr>
      <p>© 2017 Eugene's Mars Group, Inc. Licensed under MIT license.</p>
    </div>
  </div>
</body>
</html>
