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
  .promo-list div img{width: 100%; height: auto;max-width: 100%; display: block;margin-top: -30%;}
  </style>
</head>
<body class="pp-full">

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="">
      <!-- <img src="../res/images/logo.png" alt="layui"> -->
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this"> 
		  <a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>主页</a> 
	  </li>
	  <c:if test="${not empty sessionScope.Student}">
	  	<c:if test="${not empty sessionScope.Student.association}">
	      <li class="layui-nav-item ">
	        <a href="${pageContext.request.contextPath}/html/activity.jsp?associationId=${sessionScope.Student.association.associationId}"><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
	      </li>
	    </c:if>
	    <c:if test="${empty sessionScope.Student.association}">
	      <li class="layui-nav-item ">
	        你还没有加入社团
	      </li>
	    </c:if>
      </c:if>
    </ul>
    
    <ul class="layui-nav pp-nav-user">
      <c:if test="${empty sessionScope.Student}">
	      <!-- 未登入的状态 -->
	      <li class="layui-nav-item">
	        <a class="iconfont icon-touxiang layui-hide-xs" href="${pageContext.request.contextPath}/html/user/login.jsp"></a>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath}/html/user/login.jsp">登入</a>
	      </li>
      </c:if>
      
      <c:if test="${not empty sessionScope.Student}">
	      <!-- 登入后的状态 -->
	      <li class="layui-nav-item">
		    <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">${sessionScope.Student.studentInfo.name}</a>
		    <dl class="layui-nav-child">
		      <dd><a href="${pageContext.request.contextPath}/html/student-info.jsp?studentId=${sessionScope.Student.studentId}">修改信息</a></dd>
		      <dd><a href="">安全管理</a></dd>
		      <dd><a href="">退了</a></dd>
		    </dl>
		  </li>
      </c:if>
    </ul>
  </div>
</div>

<div class="pp-case-header" >
 	<div class="layui-carousel" id="promo" style=" position: absolute; left:50%;top:50%;transform: translate(-50%, -50%);">
  	<div class="promo-list"  carousel-item="">
    	<div><img src="../res/images/avatar/0.jpg" ></div>
    	<div><img src="../res/images/avatar/6.jpg" ></div>
  	</div>
</div>
</div>

<div class="pp-main" style="overflow: hidden;">
  <!-- 社团or活动 
  <div class="pp-tab-border pp-case-tab">
    <span>
      <a href="#" class="tab-this">社团</a>
      <a href="#">活动</a>
    </span>
  </div> -->
  <!-- 排序类型 -->
  <div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
      <!-- <li id="rank1"><a href="javascript:void(0)">按时间排序</a></li> -->
      <li class="layui-this" id="rank2"><a href="javascript:void(0)" >按社团名排序</a></li>
      <c:if test="${not empty sessionScope.Student}">
	      <c:if test="${empty sessionScope.Student.association }">
	      	<a class="layui-btn" style="float:right;" href="${pageContext.request.contextPath}/html/add-association.jsp">申请社团</a>
	      </c:if>
      </c:if>
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
    <div id="page" class="laypage-main">
      <button id="first">首页</button>
      <button id="prev">上一页</button>
      <div class="layui-bg-green">第<span id="cur"></span>页</div>
      <div class="layui-bg-green">共<span id="tot"></span>页</div>
      <button id="next">下一页</button>
      <button id="last">尾页</button>
    </div>
  </div>
  <!-- 排序类型和字段的隐藏域 -->
  <input id="orderType" type="hidden" />
  <input id="orderField" type="hidden" />
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
<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script>
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  carousel.render({
elem: '#promo'
,interval: 1800
,anim: 'fade'
, width: '50%'
,height: '100%'
  });
});
layui.config({
  version: "3.0.0"
  ,base: '${pageContext.request.contextPath}/res/mods/'
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


ajaxAssociation("",1,"desc","name",1);
//点击首页
$("#first").click(function(){
	ajaxAssociation("",1,$("#orderType").val(),$("#orderField").val(),1);
});
//点击上一页
$("#prev").click(function(){
	ajaxAssociation("",parseInt($("#cur").text())-1,$("#orderType").val(),$("#orderField").val(),1);
});
//点击下一页
$("#next").click(function(){
	//alert(parseInt($("#cur").text())+1);
	ajaxAssociation("",parseInt($("#cur").text())+1,$("#orderType").val(),$("#orderField").val(),1);
});
//点击尾页
$("#last").click(function(){
	ajaxAssociation("",$("#tot").text(),$("#orderType").val(),$("#orderField").val(),1);
});
//根据活动名排序
$("#rank2").click(function(){
	if($("#orderType").val()=="desc"){
		$("#orderType").val("asc");
	}else{
		$("#orderType").val("desc");
	}
	$("#orderField").val("name");
	ajaxAssociation("",1,$("#orderType").val(),$("#orderField").val(),1);
}); 

//异步获取社团列表
function ajaxAssociation(keyWord,curPage,orderType,orderField,statusId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/showAssociation.action?keyWord="+keyWord+"&curPage="+curPage+"&orderType="+orderType+"&orderField="+orderField+"&status.statusId="+statusId,
		dataType:"json",
		processData:false,
		success:function(data){
			if(data.totalPage<=1){
				$("#page").css("display","none");
			}
			$("#cur").text(data.curPage);
			$("#tot").text(data.totalPage);
			$("#orderType").val(data.orderType);
			$("#orderField").val(data.orderField);
			var code = '';
			for(var i=0;i<data.associationList.length;i++){
				code+='<li><a class="act-img" href="${pageContext.request.contextPath}/html/activity.jsp?associationId='+data.associationList[i].associationId+'"><img src="${pageContext.request.contextPath}/res/images/main.jpg"/><span class="act-num">'+"已有"+'<strong class="act-img-t">'+"n"+'</strong>'+"人关注"+'</span><span class="act-number">'+"##人"+'</span></a><div class="act-inner"><h4  href="activity.html" title="">'+data.associationList[i].name+'</h4><span style="color:#01aaed">'+data.associationList[i].explains+'</span><p></p></div></li>';
				$("#act-list").html(code);
			}
		}
	});
}



</script>
</body>
</html>