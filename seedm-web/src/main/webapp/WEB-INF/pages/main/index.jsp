<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit" />
    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>Amaze UI Examples</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/extend/easyui/metro/easyui.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/extend/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/extend/base.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" />
    <script src="${pageContext.request.contextPath}/resources/js/extend/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/extend/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/extend/amazeui/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/extend/knockout-3.4.2.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
</head>
<body class="easyui-layout">
<!-- 页头 -->
<div id="header" data-options="region:'north',border:false" class="header am-topbar am-topbar-inverse am-margin-0">
    <div class="am-topbar-brand">
        <strong>AC Milan</strong> <small>后台管理</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a href="javascript:;"><span class="am-icon-users"></span> 超级管理员 </a></li>
            <li><a href="javascript:;" data-bind="click:logout"><span class="am-icon-sign-out"></span> 注销 </a></li>
        </ul>
    </div>
</div>
<!-- 导航 -->
<div id="nav" data-options="region:'west',split:true" class="nav">
    <section data-am-widget="accordion" class="am-accordion am-accordion-gapped am-margin-0" data-am-accordion='{}'>
        <dl class="am-accordion-item">
            <dt class="am-accordion-title theme">
                机构管理
            </dt>
            <dd class="am-accordion-bd am-collapse am-in">
                <!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
                <div class="am-accordion-content am-padding-0">
                    <ul class="am-list am-list-border am-margin-0">
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, 'http://www.csdn.net')"><i class="am-icon-home am-icon-fw"></i>学校管理</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, 'main/school')"><i class="am-icon-home am-icon-fw"></i>学期管理</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, '../school/schoolm.html')"><i class="am-icon-home am-icon-fw"></i>教师管理</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, '../school/schoolm.html')"><i class="am-icon-home am-icon-fw"></i>学生管理</a>
                        </li>
                    </ul>
                </div>
            </dd>
        </dl>
        <dl class="am-accordion-item">
            <dt class="am-accordion-title theme">
                设备管理
            </dt>
            <dd class="am-accordion-bd am-collapse">
                <!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
                <div class="am-accordion-content am-padding-0">
                    <ul class="am-list am-list-border am-margin-0">
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, 'http://www.csdn.net')"><i class="am-icon-home am-icon-fw"></i>新增设备</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, '../school/schoolm.html')"><i class="am-icon-home am-icon-fw"></i>设备分组维护</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, '../school/schoolm.html')"><i class="am-icon-home am-icon-fw"></i>机构设备维护</a>
                        </li>
                    </ul>
                </div>
            </dd>
        </dl>
        <dl class="am-accordion-item">
            <dt class="am-accordion-title theme">
                系统管理
            </dt>
            <dd class="am-accordion-bd am-collapse">
                <!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
                <div class="am-accordion-content am-padding-0">
                    <ul class="am-list am-list-border am-margin-0">
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, 'http://www.csdn.net')"><i class="am-icon-home am-icon-fw"></i>数据字典维护</a>
                        </li>
                        <li>
                            <a href="#" data-bind="click: forward.bind($data, '../school/schoolm.html')"><i class="am-icon-home am-icon-fw"></i>系统资源维护</a>
                        </li>
                    </ul>
                </div>
            </dd>
        </dl>
        <!--<dl class="am-accordion-item">-->
        <!--<dt class="am-accordion-title title">-->
        <!--员工管理-->
        <!--</dt>-->
        <!--<dd class="am-accordion-bd am-collapse ">-->
        <!--&lt;!&ndash; 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 &ndash;&gt;-->
        <!--<div class="am-accordion-content">-->
        <!--我就这样告别山下的家，我实在不愿轻易让眼泪留下。我以为我并不差不会害怕，我就这样自己照顾自己长大。我不想因为现实把头低下，我以为我并不差能学会虚假。怎样才能够看穿面具里的谎话？别让我的真心散的像沙。如果有一天我变得更复杂，还能不能唱出歌声里的那幅画？-->
        <!--</div>-->
        <!--</dd>-->
        <!--</dl>-->
        <!--<dl class="am-accordion-item">-->
        <!--<dt class="am-accordion-title title">-->
        <!--设备管理-->
        <!--</dt>-->
        <!--<dd class="am-accordion-bd am-collapse ">-->
        <!--&lt;!&ndash; 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 &ndash;&gt;-->
        <!--<div class="am-accordion-content">-->
        <!--我就这样告别山下的家，我实在不愿轻易让眼泪留下。我以为我并不差不会害怕，我就这样自己照顾自己长大。我不想因为现实把头低下，我以为我并不差能学会虚假。怎样才能够看穿面具里的谎话？别让我的真心散的像沙。如果有一天我变得更复杂，还能不能唱出歌声里的那幅画？-->
        <!--</div>-->
        <!--</dd>-->
        <!--</dl>-->
    </section>
</div>
<!-- 内容操作区域 -->
<div id="content" data-options="region:'center'" style="overflow: visible;">
    <iframe width="100%" height="100%" data-bind="attr: {src: url}"></iframe>
</div>
<!-- 页脚 -->
<div data-options="region:'south',border:false" class="am-footer am-footer-default footer theme" data-am-footer="{  }">
    <div class="copyright">
        <p>由<span>Eugene</span>提供技术支持 CopyRight©2017  AllMobilize Inc.</p>
    </div>
</div>
</body>
</html>