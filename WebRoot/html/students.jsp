<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../res/layui/css/layui.css">
  <link rel="stylesheet" href="../res/css/global.css">
	  <script src="../res/js/jquery-3.2.1.min.js"></script>
  <script src="../res/js/act.js"></script>
</head>
<body>

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="/">
      <img src="../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this">
        <a href="index.html"><i class="iconfont icon-jiaoliu"></i>主页</a>
      </li>
      <li class="layui-nav-item">
        <a href="/"><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
      </li>
    </ul>
    
    <ul class="layui-nav pp-nav-user">
      
      <!-- 未登入的状态 -->
      <li class="layui-nav-item">
        <a class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
      </li>
      <li class="layui-nav-item">
        <a href="user/login.html">登入</a>
      </li>
      <li class="layui-nav-item">
        <a href="user/reg.html">注册</a>
      </li>
      
      <!-- 登入后的状态 -->
      <!--
      <li class="layui-nav-item">
        <a class="pp-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">贤心</cite>
          <i class="layui-badge pp-badge-vip layui-hide-xs">VIP3</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="/user/logout/" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
      -->
    </ul>
  </div>
</div>

<div class="pp-panel pp-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="/">###社团成员</a></li> 
    </ul> 
    
    <div class="pp-column-right layui-hide-xs"> 
      <span class="pp-search"><i class="layui-icon"></i></span> 
      <a href="jie/add.html" class="layui-btn">搜索活动</a> 
    </div> 
    <div class="layui-hide-sm layui-show-xs-block" style="margin-top: -10px; padding-bottom: 10px; text-align: center;"> 
      <a href="jie/add.html" class="layui-btn">搜索活动</a> 
    </div> 
  </div>
</div>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="pp-panel">
        <div class="pp-panel-title pp-filter">
          <a>成员列表</a>
        </div>
		<div class="layui-collapse" lay-accordion="">
  			<div class="layui-colla-item">
    			<h2 class="layui-colla-title">一组成员</h2>
    			<div class="layui-colla-content layui-show">
      				<div class="layui-card">
       					<div class="layui-card-body">
							<ul>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
							</ul>
        				</div>
		  			</div>
    			</div>
  			</div>
  			<div class="layui-colla-item">
    			<h2 class="layui-colla-title">二组成员</h2>
    			<div class="layui-colla-content">
      				<div class="layui-card">
       					<div class="layui-card-body">
							<ul>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
							</ul>
        				</div>
      	  			</div>
    			</div>
  			</div>
  			<div class="layui-colla-item">
    			<h2 class="layui-colla-title">三组成员</h2>
    			<div class="layui-colla-content">
      				<div class="layui-card">
       					<div class="layui-card-body">
							<ul>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
							</ul>
        				</div>
      	  			</div>
    			</div>
  			</div>
  			<div class="layui-colla-item">
    			<h2 class="layui-colla-title">四组成员</h2>
    			<div class="layui-colla-content">
      				<div class="layui-card">
       					<div class="layui-card-body">
							<ul>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
								<li><img src="../res/images/avatar/1.jpg">默默无闻的群员1</li>
							</ul>
        				</div>
      	  			</div>
    			</div>
  			</div>
		</div>
	</div>
  </div>
</div>
</div>
<div class="pp-footer">
  <p><a href="" target="_blank">PP技术支持</a> 2018 &copy; <a href="" target="_blank">pp出品</a><a href="${pageContext.request.contextPath}/html/user/home.jsp" target="_blank">管理员模式</a></p>
  <p>
	<a href="" target="_blank">如</a>
    <a href="" target="_blank">商业合作</a>
	<a href="" target="_blank">或</a>
    <a href="" target="_blank">招聘我们</a>
	<a href="" target="_blank">请</a>
    <a href="" target="_blank">加我微信</a>
	 
  </p>
</div>
<ul class="layui-fixbar">
	<a  href="jie/add.html"><li class="layui-icon" style="background-color:#009688" lay-type="bar1"></li></a>
</ul>
<script src="../res/layui/layui.js"></script>
<script>
layui.cache.page = 'jie';
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
<script>
layui.use(['element', 'layer'], function(){
  var element = layui.element;
  var layer = layui.layer;
  
  //监听折叠
  element.on('collapse(test)', function(data){
    layer.msg('展开状态：'+ data.show);
  });
});
</script>
</body>
</html>