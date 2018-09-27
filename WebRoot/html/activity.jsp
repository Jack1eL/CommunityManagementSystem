<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
	<script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/js/act.js"></script>
</head>
<body>

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="/">
      <img src="../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this">
        <a href="index.jsp"><i class="iconfont icon-jiaoliu"></i>主页</a>
      </li>
      <li class="layui-nav-item">
        <a href="activity.jsp?associationId=从用户中取得"><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
      </li>
    </ul>
    
    <ul class="layui-nav pp-nav-user">
      <c:if test="${empty sessionScope.Student}">
	      <!-- 未登入的状态 -->
	      <li class="layui-nav-item">
	        <a class="iconfont icon-touxiang layui-hide-xs" href="${pageContext.request.contextPath}/user/login.html"></a>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath}/user/login.html">登入</a>
	      </li>
      </c:if>
      
      <c:if test="${not empty sessionScope.Student}">
	      <!-- 登入后的状态 -->
	      <li class="layui-nav-item">
	        <a class="pp-nav-avatar" href="javascript:;">
	          <cite class="layui-hide-xs">${sessionScope.Student.username}</cite>
	          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
	        </a>
	        <dl class="layui-nav-child">
	          <dd><a href="../user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
	          <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
	          <dd><a href="../user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
	          <hr style="margin: 5px 0;">
	          <dd><a href="${pageContext.request.contextPath}/logoutStudent.action" style="text-align: center;">退出</a></dd>
	        </dl>
	      </li>
      </c:if>
    </ul>
  </div>
</div>

<div class="pp-panel pp-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="/"><span id="asso"></span>的活动</a></li> 
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
          <a>活动列表</a>
          <c:if test="${sessionScope.Student.position.positionId==1}">
          	<a class="layui-btn" style="color:white;float:right;" href="${pageContext.request.contextPath}/html/add-activity.jsp?associationId=${param.associationId}">增加活动</a>
          </c:if>
        </div>
        <ul class="pp-list" id="as-list">
            
        </ul>
      </div>
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
	  <div class="layui-col-md4">
      <div class="pp-panel">
        <div class="pp-panel-title">社团简介</div>
	  <div class="layui-col-md12">
      	<div class="layui-card">
        	<div class="layui-card-body" style="margin-top:-20px;">
          		################################
        	</div>
      	</div>
  	  </div>
      </div>
	  <div class="pp-panel-main">
          <a href="###" target="_blank" class="pp-zanzhu layui-bg-green" time-limit="2017.09.25-2099.01.01">查看所有成员</a>
      </div>
      <div class="pp-panel" style="padding: 20px 0; text-align: center;">
        <img src="#群二维码#" style="max-width: 100%;" alt="QQ二维码">
        <p style="position: relative; color: #666;">QQ扫码加群</p>
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
	<a  href="jie/add.html"><li class="layui-icon" style="background-color:#009688" lay-type="bar1"></li></a>
</ul>
<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script>
layui.cache.page = 'jie';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '${pageContext.request.contextPath}/res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '${pageContext.request.contextPath}/res/mods/'
}).extend({
  pp: 'index'
}).use('pp');


//进入时请求所有的社团活动列表
ajaxAssociationActivity("",1,"desc","activityName",${param.associationId});
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
$("#rank1").click(function(){
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
}); 

//异步请求获取所有的社团活动列表
function ajaxAssociationActivity(keyWord,curPage,orderType,orderField,associationId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/findAllActivityByAssociationId.action?keyWord="+keyWord+"&curPage="+curPage+"&orderType="+orderType+"&orderField="+orderField+"&association.associationId="+associationId,
		dataType:"json",
		processData:false,
		success:function(data){
		
			if(data.list.length!=0){
				$("#cur").text(data.curPage);
				$("#tot").text(data.totalPage);
				$("#orderType").val(data.orderType);
				$("#orderField").val(data.orderField);
				var code = '';
				for(var i=0;i<=data.list.length;i++){
					var h='活动'+i+'类型';
					var b=data.list[i].activityName;
					var s='活动发布者';
					var n=data.list[i].activityBegin+"至"+data.list[i].activityEnd;
					
					code+='<li><h2><a class="pp-avatar" href="/u/6497232"><img src="${pageContext.request.contextPath}/res/images/avatar/0.jpg"></a><a class="layui-badge">'+h+'</a><a href="${pageContext.request.contextPath}/html/jie/detail.jsp?activityId='+data.list[i].activityId+'">'+b+'</a></h2><div class="pp-list-info"><a href="##"><cite>'+s+'</cite></a><span class="layui-badge pp-badge-accept layui-hide-xs"><i class="iconfont icon-shijian"></i>'+n+'</span><span class="pp-list-nums"></span></div><div class="pp-list-badge"></div></li>';
				
					$("#as-list").html(code);
					
					$("#asso").text(data.list[i].association.name);
				}
			}else{
				$("#as-list").html('<blockquote class="layui-elem-quote layui-quote-nm">这个社团并没有活动！</blockquote>');
			}
		}
	});
	
}
</script>
</body>
</html>