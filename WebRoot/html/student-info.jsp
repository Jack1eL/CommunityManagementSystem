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
	    <a class="pp-logo" href="">
	      <!-- <img src="../res/images/logo.png" alt="layui"> -->
	    </a>
	    <ul class="layui-nav pp-nav layui-hide-xs">
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>主页</a>
	      </li>
	      <li class="layui-nav-item layui-this">
	        <a href="${pageContext.request.contextPath}/html/activity.jsp?associationId=${sessionScope.Student.association.associationId}"><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
	      </li>
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
	
	<div class="pp-home pp-panel" style="background-image: url();">
		<form class="layui-form" style="margin: 0 auto;width:400px; text-align: left;" >
			<div class="layui-form-item" >
				<label class="layui-form-label">姓名</label>
				<div id="name" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	  		</div>
			<div class="layui-form-item" >
				<label class="layui-form-label">性别</label>
				<div id="gender" class="layui-input-block" style="margin-left:240px;">
				  
				</div>
	  		</div>
			<div class="layui-form-item" >
				<label class="layui-form-label">学号</label>
				<div id="username" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	  		</div>
			<div class="layui-form-item" >
				<label class="layui-form-label">所在系部</label>
				<div id="department" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
				<label class="layui-form-label">所在班级</label>
				<div id="clazz" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	  		</div>
			<div class="layui-form-item">
			<label class="layui-form-label">加入的社团</label>
				<div id="association" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	  		</div>
			<div class="layui-form-item">
				<label class="layui-form-label">社团职务</label>
				<div id="position" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	 		</div>
			<div class="layui-form-item">
				<label class="layui-form-label">家庭地址</label>
				<div id="address" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	 	 	</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">个人简介</label>
				<div id="explain" style="width: 250px; height: 40px; line-height: 40px;margin-left:240px;">
					
				</div>
	  		</div>
			<!-- <div class="layui-form-item">
				<div class="layui-input-block">
				  <button class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
				</div>
			</div> -->
		</form>
	</div>
	
	<div class="layui-container">
	  <div class="layui-row layui-col-space15">
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
	<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
	<script>
	layui.config({
	  version: "3.0.0"
	  ,base: '${pageContext.request.contextPath}/res/mods/'
	}).extend({
	  pp: 'index'
	}).use('pp');
	
	
	
		ajaxStudentInfo();
		
		function ajaxStudentInfo(){
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/findStudentById.action?studentId=${param.studentId}",
				dataType:"json",
				processData:false,
				success:function(data){
					$("#name").text(data.student.studentInfo.name);
					if(data.student.studentInfo.sex=="男"){
						$("#gender").html('<h1 style="width: 100px;"><i class="iconfont icon-nan">男</i></h1>');
					}else{
						$("#gender").html('<h1 style="width: 100px;"><i class="iconfont icon-nv">女</i></h1>');
					}
					$("#username").text(data.student.username);
					$("#department").text(data.student.studentInfo.classes.major.department.departmentName);
					$("#clazz").text(data.student.studentInfo.classes.major.grade+data.student.studentInfo.classes.major.majorName+data.student.studentInfo.classes.classNumber+"班");
					$("#association").text(data.student.association.name);
					$("#position").text(data.student.position.positionName);
					$("#address").text(data.student.studentInfo.address);
					$("#explain").text(data.student.studentInfo.explains);
					
				}
			});	
		
		}
	
	
	</script>
</body>
</html>
