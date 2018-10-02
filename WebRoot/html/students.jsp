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

<div class="pp-panel pp-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="/">###社团成员</a></li> 
    </ul>
  </div>
</div>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="pp-panel">
      	<div class="pp-panel-title pp-filter">
          <a>成员列表</a>
        </div>
		<div class="layui-collapse" lay-accordion=""  id="showGroup">

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
var groupCount;    //因为我们要查询出学生在某个组，首先我们先记住这个社团的组数，在student中进行循环嵌套

//ajaxAssociationGroup(${param.associationId});
ajaxStudent(${param.associationId});
//异步获取社团组的信息
/*function ajaxAssociationGroup(associationId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/findGroupCountById.action?association.associationId="+associationId,
		dataType:"json",
		processData:false,
		success:function(data){
			
			for(var i=0;i<data.totalPage;i++){
				$("#showGroup").append('<div class="layui-colla-item"><h2 class="layui-colla-title">'+(i+1)+'组成员</h2><div class="layui-colla-content layui-show"><div class="layui-card"><div class="layui-card-body"><ul name="showStudent"></ul></div></div></div></div>');
			}
			groupCount=data.totalPage;
		}
	});

}*/

//异步获取此社团的学生
function ajaxStudent(associationId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/getGroupStudent.action?association.associationId="+associationId,
		dataType:"json",
		processData:false,
		success:function(data){
			
				$("[name='showStudent']").append('1');
				
			
		}
	});
}


</script>
</body>
</html>