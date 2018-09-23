<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html style="background-color: #e2e2e2;">
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	
  <meta name="keywords" content="{{ lay.base.keywords }}">
  <meta name="description" content="{{ lay.base.description }}">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/pp.js"></script>
	
  <style>
  .header{border-bottom: 1px solid #404553; border-right: 1px solid #404553;}
  </style>
</head>
<body class="pp-full">

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="/">
      <img src="../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this"> 
		  <a href="index.html"><i class="iconfont icon-jiaoliu"></i> 主页</a> 
	  </li>
      <li class="layui-nav-item ">
        <a href=""><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
      </li>
    </ul>
    
    <ul class="layui-nav pp-nav-user">
      
      <!-- 未登入的状态 -->
		 <!--
      <li class="layui-nav-item">
        <a class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
      </li>
      <li class="layui-nav-item">
        <a href="user/login.html">登入</a>
      </li>
      <li class="layui-nav-item">
        <a href="user/reg.html">注册</a>
      </li>
      -->
      <!-- 登入后的状态 -->
     
      <li class="layui-nav-item">
        <a class="pp-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">贤心</cite>
          <i class="layui-badge pp-badge-vip layui-hide-xs">**</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="user/reg.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
      
    </ul>
  </div>
</div>

<div class="pp-case-header">
  <p class="pp-case-year">2017</p>
  <a href="/case/{{ year }}/">
    <img class="pp-case-banner" src="../res/images/main.jpg" alt="#####">
  </a>
</div>

<div class="pp-main" style="overflow: hidden;">

  <div class="pp-tab-border pp-case-tab">
    <span>
      <a href="#" class="tab-this">活动</a>
      <a href="#">社团</a>
    </span>
  </div>
  <div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
      <li class="layui-this" id="rank1"><a href="##">按时间排行</a></li>
      <li id="rank2"><a href="##" >按##排行</a></li>
    </ul>
  </div>
	
  <section class="act-content" >
			<div class="home-mod recommend layout">
							<div class="recommend-list">
								<div class="recommend-content" style="display: block;" id="recommend_content_2">
									<ul class="recommend-act act-list" id="act-list">
										
									</ul>
								</div>								
							</div>
						</div>
			
			</section>

  <div style="text-align: center;">
    <div class="laypage-main">
      <span class="laypage-curr" href="##">1</span>
      <span href="##">2</span>
	  <span href="##">3</span>
      <span href="##">4</span>
      <span href="##">5</span>
      <span>…</span>
      <a href="" class="laypage-last" title="尾页">尾页</a>
      <a href="" class="laypage-next">下一页</a>
    </div>
  </div>

</div>

<div class="pp-footer">
  <p><a href="/" target="_blank">PP技术支持</a> 2017 &copy; <a href="/" target="_blank">pp出品</a> <a href="/" target="_blank">管理员模式</a></p>
  <p>
	<a href="/" target="_blank">如</a>
    <a href="/" target="_blank">商业合作</a>
	<a href="/" target="_blank">或</a>
    <a href="/" target="_blank">招聘我们</a>
	<a href="/" target="_blank">请</a>
    <a href="/" target="_blank">加我微信</a>
	 
  </p>
</div>
<script src="../res/layui/layui.js"></script>
<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  pp: 'index'
}).use('pp');
</script>
</body>
</html>