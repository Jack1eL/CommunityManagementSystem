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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/sortable.min.css">
  <script src="${pageContext.request.contextPath}/res/js/sortable.min.js"></script>
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
<div class="htmleaf-container">
		  <main class="sortable">
		    <div class="container">
		      <div class="wrapper">
		        <ul class="sortable__nav nav">
		          <li>
		            <a data-sjslink="all" class="nav__link">
		              All
		            </a>
		          </li>
		          <li>
		            <a data-sjslink="flatty" class="nav__link">
		              Flatty
		            </a>
		          </li>
		          <li>
		            <a data-sjslink="funny" class="nav__link">
		              Funny
		            </a>
		          </li>
		        </ul>
		        <div id="sortable" class="sjs-default">
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-1.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 1</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eveniet, eius, asperiores. Incidunt sapiente est quae iure...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-2.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 2</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum vitae necessitatibus, dolorem similique vero explicabo...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="funny">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-3.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 3</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo, placeat voluptate, fuga tenetur eos ducimus animi porro...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/avatar/0.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 4</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit doloremque quisquam, obcaecati unde nam est quos...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-5.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 5</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse corporis hic minima nisi reprehenderit...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="funny">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-6.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 6</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatibus, id, deserunt inventore...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-7.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 7</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rerum enim beatae vero culpa, fuga, magni sunt dolores nam...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="flatty">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-8.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 8</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae numquam, blanditiis necessitatibus...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="funny">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-9.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 9</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur adipisci voluptatum laborum officiis...
		                </p>
		              </div>
		            </div>
		          </div>
				  <div data-sjsel="funny">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 9</h2>
		                <p class="card__text">
		                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur adipisci voluptatum laborum officiis...
		                </p>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </main>
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