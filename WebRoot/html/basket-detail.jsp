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
  <meta name="keywords" content="{{ lay.base.keywords }}">
  <meta name="description" content="{{ lay.base.description }}">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/pp.js"></script>
  <style>
  .header{border-bottom: 1px solid #404553; border-right: 1px solid #404553;}
  </style>
</head>
<body class="pp-full" style="background-color:rgba(0,0,0,0.00)">

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="">
      <!-- <img src="../res/images/logo.png" alt="layui"> -->
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this"> 
		  <a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>主页 </a> 
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
			  <dd><a href="${pageContext.request.contextPath}/html/update-password.jsp?studentId=${sessionScope.Student.studentId}">安全管理</a></dd>
			  <dd><a href="${pageContext.request.contextPath}/logoutStudent.action">退了</a></dd>
		    </dl>
		  </li>
      </c:if>
    </ul>
  </div>
</div>
<div class="pp-panel pp-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="/">社团篮子</a></li> 
    </ul> 
  </div>
</div>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8 content detail">
      <div class="pp-panel detail-box">
        <h1 style="padding-left: 15px;">标题！！</h1>
        <div class="pp-detail-info">
        </div>
        <div class="detail-about" style="padding-left: 0px;">
			<dt class="pp-panel-title">
			  <div class="pp-detail-user" >
				<a href="../user/home.html" class="pp-link">
				  <cite>用户名</cite>
				</a>
				<span>2017-11-30</span>
			  </div>
			</dt>
        </div>
        <div class="detail-body photos" style="padding-left: 15px;">
          <p>
           #####################
          </p>
          <p>
            <img src="../../res/images/fly.jpg" alt="##">
          </p>
        </div>
      </div>

    </div>
    <div class="layui-col-md4">
      <dl class="pp-panel pp-list-one">
        <dt class="pp-panel-title">用户名<i style="padding-left: 15px;font-size: 12px; color: #979797">系部班级</i></dt>
		 
        <dd>
          <a href="">他的其他篮子？</a>
        </dd>
        <dd>
          <a href="">他的其他篮子？</a>
        </dd>
        <dd>
          <a href="">他的其他篮子？</a>
          
        </dd>
      </dl>
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
<script src="../res/layui/layui.js"></script>
<script>
layui.cache.page = 'user';

layui.config({
  version: "3.0.0"
  ,base: '../res/mods/'
}).extend({
  pp: 'index'
}).use('pp');

document.querySelector('#sortable').sortablejs();
	

</script>
</body>
</html>