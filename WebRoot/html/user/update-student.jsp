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
    <title>用户中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
    <script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/admin.js"></script>
</head>
<body>

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="/">
      <!-- <img src="../../res/images/logo.png" alt="layui"> -->
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>前台主页</a> </li>
      <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/html/user/backindex.jsp"><i class="iconfont icon-jiaoliu"></i>后台主页</a>
      </li>
    </ul>
    
    <ul class="layui-nav pp-nav-user">
      <c:if test="${empty sessionScope.Admin}">
	      <!-- 未登入的状态 -->
	      <li class="layui-nav-item">
	        <a class="iconfont icon-touxiang layui-hide-xs" href="${pageContext.request.contextPath}/html/user/home.jsp"></a>
	      </li>
	      <li class="layui-nav-item">
	        <a href="${pageContext.request.contextPath}/html/user/home.jsp">登入</a>
	      </li>
      </c:if>
      
      <c:if test="${not empty sessionScope.Admin}">
      <!-- 登入后的状态 -->
      <li class="layui-nav-item">
        <a class="pp-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">${sessionScope.Admin.username}</cite>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${pageContext.request.contextPath}/logoutAdmin.action" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
      </c:if>
    </ul>
  </div>
</div>

<div class="layui-container pp-marginTop pp-user-main">
  <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    <li class="layui-nav-item">
      <a href="${pageContext.request.contextPath}/html/user/home.jsp">
        <i class="layui-icon">&#xe609;</i>
        我的主页
      </a>
    </li>
    <li class="layui-nav-item layui-this">
      <a href="${pageContext.request.contextPath}/html/user/backindex.jsp">
        <i class="layui-icon">&#xe612;</i>
        管理中心
      </a>
    </li>
  </ul>

  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  <div class="pp-panel pp-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
		<div class="layui-container pp-marginTop">
  		  <div class="pp-panel">
    		<div class="layui-form layui-form-pane">
      		  <div class="layui-tab layui-tab-brief" lay-filter="user">
        		<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          		  <div class="layui-tab-item layui-show">
            		 <form action="" method="post">
                		  <div class="layui-col-md4">
			                  <label class="layui-form-label">学号</label>
			                  <div class="layui-input-block">
			                    <input type="text" id="username" class="layui-input" lay-verify="required">
			                  </div>
			                </div>
			                <div class="layui-col-md4">
			                	<div class="layui-form-item">
								    <label class="layui-form-label">系别</label>
								    <div class="layui-input-block">
								      <select id="department" name="de" lay-verify="required" onchange="javascript:alert(1)">
								        <option value=""></option>
								        <option selected >信息工程系</option>
								        <option >机电工程系</option>
								        <option >旅游商贸系</option>
								        <option >经济贸易系</option>
								      </select>
								    </div>
								  </div>
			                </div>
			                <div class="layui-col-md4">
			                	<div class="layui-form-item">
								    <label class="layui-form-label">年级</label>
								    <div class="layui-input-block">
								      <select name="grade" lay-verify="required" onchange="javascript:alert(1)">
								      	<option value=""></option>
								        <option selected >2016</option>
								        <option >2017</option>
								        <option >2018</option>
								      </select>
								    </div>
								  </div>
			                </div>
			                <div style="clear:both;"></div>
			                
			                <div class="layui-col-md4">
			                	<div class="layui-form-item">
								    <label class="layui-form-label">专业</label>
								    <div class="layui-input-block">
								      <select name="major" lay-verify="required" onchange="javascript:alert(1)">
								      	<option value=""></option>
								        <option selected >软件技术</option>
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
								      <select name="clazz" lay-verify="required" onchange="javascript:alert(1)">
								      	<option value=""></option>
								        <option selected >1班</option>
								        <option >2班</option>
								        <option >3班</option>
								      </select>
								    </div>
								  </div>
			                </div>
			              </div>
			              
			              <div class="layui-form-item">
			                <button class="layui-btn" type="submit">修改</button>
			                <a class="layui-btn" type="button" href="javascript:history.go(-1)">返回</a>
			              </div>
                     </form>
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

<script src="${pageContext.request.contextPath}/res/layui/layui.js"></script>
<script>

layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  pp: 'index'
}).use('pp');
ajaxStudentById();
/* ajaxDepartment();

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
	
	} */
	
	function ajaxStudentById(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/findStudentById.action?studentId=${param.studentId}",
			dataType:"json",
			processData:false,
			success:function(data){
				
				$("#username").val(data.student.username);
				
			}
		});	
	}
</script>

</body>
</html>