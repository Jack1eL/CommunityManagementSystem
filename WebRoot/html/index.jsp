<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
      <!-- <img src="../res/images/logo.png" alt="layui"> -->
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
  <p class="pp-case-year">2018</p>
  <a href="/case/{{ year }}/">
    <img class="pp-case-banner" src="../res/images/main.jpg" alt="#####">
  </a>
</div>

<div class="pp-main" style="overflow: hidden;">
  <!-- 社团or活动 -->
  <div class="pp-tab-border pp-case-tab">
    <span>
      <a href="#" class="tab-this">社团</a>
      <a href="#">活动</a>
    </span>
  </div>
  <!-- 排序类型 -->
  <div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
      <li id="rank1"><a href="javascript:void(0)">按时间排序</a></li>
      <li class="layui-this" id="rank2"><a href="javascript:void(0)" >按活动名排序</a></li>
    </ul>
  </div>
  <!-- 列表区 -->
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

  <div style="clear:both;"></div>
  <!-- 分页区 -->
  <div style="text-align: center;">
    <div class="laypage-main">
      <button id="first">首页</button>
      <button id="prev">上一页</button>
      <div class="layui-bg-green">第<span id="cur"></span>页</div>
      <div class="layui-bg-green">共<span id="tot"></span>页</div>
      <button id="next">下一页</button>
      <button id="last">尾页</button>
    </div>
  </div>
  <!-- 排序类型和字段的隐藏域 -->
  <input id="orderType" type="text" />
  <input id="orderField" type="text" />
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



/*社团列表*/
/* $(document).ready(function(){
	var code = '';
	for(var i=1;i<4;i++){

	
	code+='<li><a class="act-img" href="activity.html"><img src="../res/images/main.jpg"/><span class="act-num">'+"已有"+'<strong class="act-img-t">'+"n"+'</strong>'+"人关注"+'</span><span class="act-number">'+"##人"+'</span></a><div class="act-inner"><h4  href="activity.html" title="">'+"活动名"+'</h4><p class="act-date">'+"活动时间:"+'<span>'+"####"+"~"+"#######"+'</span></p><p>'+"##########"+'</p></div></li>';
	$("#act-list").html(code);
	}
	
}); */

//进入时请求所有的社团活动列表
ajaxAssociationActivity("",1,"desc","activityName");
//点击首页
$("#first").click(function(){
	ajaxAssociationActivity("",1,$("#orderType").val(),$("#orderField").val());
});
//点击上一页
$("#prev").click(function(){
	ajaxAssociationActivity("",parseInt($("#cur").text())-1,$("#orderType").val(),$("#orderField").val());
});
//点击下一页
$("#next").click(function(){
	//alert(parseInt($("#cur").text())+1);
	ajaxAssociationActivity("",parseInt($("#cur").text())+1,$("#orderType").val(),$("#orderField").val());
});
//点击尾页
$("#last").click(function(){
	ajaxAssociationActivity("",$("#tot").text(),$("#orderType").val(),$("#orderField").val());
});

//根据时间排序
/* $("#rank1").click(function(){
	if($("#orderType").val()=="desc"){
		$("#orderType").val("asc");
	}else{
		$("#orderType").val("desc");
	}
	$("#orderField").val("activityBegin");
	ajaxAssociationActivity("",1,$("#orderType").val(),$("#orderField").val());
});
//根据活动名排序
$("#rank2").click(function(){
	if($("#orderType").val()=="desc"){
		$("#orderType").val("asc");
	}else{
		$("#orderType").val("desc");
	}
	$("#orderField").val("activityName");
	ajaxAssociationActivity("",1,$("#orderType").val(),$("#orderField").val());
}); */

//异步请求获取所有的社团活动列表
function ajaxAssociationActivity(keyWord,curPage,orderType,orderField){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/findAllActivity.action?keyWord="+keyWord+"&curPage="+curPage+"&orderType="+orderType+"&orderField="+orderField,
		dataType:"json",
		processData:false,
		success:function(data){
			$("#cur").text(data.curPage);
			$("#tot").text(data.totalPage);
			$("#orderType").val(data.orderType);
			$("#orderField").val(data.orderField);
			var code = '';
			for(var i=0;i<data.list.length;i++){
				code+='<li><a class="act-img" href="activity.html"><img src="${pageContext.request.contextPath}/res/images/main.jpg"/><span class="act-num">'+"已有"+'<strong class="act-img-t">'+"n"+'</strong>'+"人关注"+'</span><span class="act-number">'+"##人"+'</span></a><div class="act-inner"><h4  href="activity.html" title="">'+data.list[i].activityName+'</h4><p class="act-date">'+"活动时间:<br>"+'<span>'+data.list[i].activityBegin+"至<br>"+data.list[i].activityEnd+'</span></p><p></p></div></li>';
				$("#act-list").html(code);
			}
		}
	});
}


</script>
</body>
</html>