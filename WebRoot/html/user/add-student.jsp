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

  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
    <script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
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
				  <dd><a href="${pageContext.request.contextPath}/html/update-password.jsp?studentId=${sessionScope.Student.studentId}">安全管理</a></dd>
				  <dd><a href="${pageContext.request.contextPath}/logoutStudent.action">退了</a></dd>
			    </dl>
			  </li>
	      </c:if>
	    </ul>
	  </div>
	</div>
  	
  	<div class="layui-container pp-marginTop">
	  <div class="pp-panel" pad20 style="padding-top: 5px;">
	    <div class="layui-form layui-form-pane">
	      <div class="layui-tab layui-tab-brief" lay-filter="user">
	        <ul class="layui-tab-title">
	          <li class="layui-this">添加学生</li>
	        </ul>
	        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
	          <div class="layui-tab-item layui-show">
	            <form action="${pageContext.request.contextPath}/addStudent.action" method="post">
	              <div class="layui-row layui-col-space15 layui-form-item">
	                <div class="layui-col-md4">
	                  <label class="layui-form-label">学号</label>
	                  <div class="layui-input-block">
	                    <input type="text" name="name" class="layui-input" lay-verify="required">
	                  </div>
	                </div>
	                <div class="layui-col-md4">
	                	<div class="layui-form-item">
						    <label class="layui-form-label">系别</label>
						    <div class="layui-input-block">
						      <select id="department" name="de" lay-verify="required" onchange="javascript:alert(1)">
						        
						      </select>
						    </div>
						  </div>
	                </div>
	                <div class="layui-col-md4">
	                	<div class="layui-form-item">
						    <label class="layui-form-label">年级</label>
						    <div class="layui-input-block">
						      <select name="major" lay-verify="required" onchange="javascript:alert(1)">
						      	<option value=""></option>
						        <option >2016</option>
						        <option >2017</option>
						        <option >2018</option>
						      </select>
						    </div>
						  </div>
	                </div>
	                <div style="clear:both;"></div>
	                <div class="layui-col-md4">
	                  <label for="L_title" class="layui-form-label">密码</label>
	                  <div class="layui-input-block">
	                    <input type="text" id="L_title" value="123456" class="layui-input" disabled>
	                    <!-- 提交的学生的id -->
	                    <input type="hidden" name="studentId" value="${sessionScope.Student.studentId}">
	                  </div>
	                </div>
	                <div class="layui-col-md4">
	                	<div class="layui-form-item">
						    <label class="layui-form-label">专业</label>
						    <div class="layui-input-block">
						      <select name="major" lay-verify="required" onchange="javascript:alert(1)">
						      	<option value=""></option>
						        <option >软件技术</option>
						        <option >物联网应用技术</option>
						        <option >计算机网络技术</option>
						      </select>
						    </div>
						  </div>
	                </div>
	                <div class="layui-col-md4">
	                	<div class="layui-form-item">
						    <label class="layui-form-label">班级</label>
						    <div class="layui-input-block">
						      <select name="major" lay-verify="required" onchange="javascript:alert(1)">
						      	<option value=""></option>
						        <option >1班</option>
						        <option >2班</option>
						        <option >3班</option>
						      </select>
						    </div>
						  </div>
	                </div>
	              </div>
	              
	              <div class="layui-form-item">
	                <button class="layui-btn" type="submit">立即添加</button>
	                <a class="layui-btn" type="button" href="javascript:history.go(-1)">返回</a>
	              </div>
	                
	            </form>
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
	
	<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
	<script>
	ajaxDepartment();
	
	layui.config({
	  version: "3.0.0"
	  ,base: '${pageContext.request.contextPath}/res/mods/'
	}).extend({
	  pp: 'index'
	}).use('pp');
	


	function ajaxDepartment(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/findAllDepartment.action",
			dataType:"json",
			processData:false,
			success:function(data){
				$("#department").empty();
				
				$("#department").append('<option value="-1"></option>');
				
				for(var i=0;i<data.list.length;i++){
					$("#department").append('<option value="'+i+'">'+data.list[i].departmentName+'</option>');
				}
			}
		});	
	
	}
	
	
	
	function ajaxMajor(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/findAllMajor.action",
			dataType:"json",
			processData:false,
			success:function(data){
				$("#major").empty();
				$("#major").append('<option value=""></option>');
				
				for(var i=0;i<data.list.length;i++){
					$("#major").append('<option value="0">'+data.list[i].departmentName+'</option>');
				}
			}
		});
	}
	
	</script>
  </body>
</html>
