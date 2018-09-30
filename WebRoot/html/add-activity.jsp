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
  <title>发表问题 编辑问题 公用</title>
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
      <li class="layui-nav-item">
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

<div class="layui-container pp-marginTop">
  <div class="pp-panel" pad20 style="padding-top: 5px;">
    <!--<div class="pp-none">没有权限</div>-->
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form class="layui-form" action="${pageContext.request.contextPath}/addActivity.action">
            	<div class="layui-form-item">
            		<label class="layui-form-label">社团</label>
            		<div class="layui-input-block" style="width:200px">
            			<input class="layui-input" type="text" placeholder='+s+' lay-verify="title" disabled>
            		</div>
            	</div>
	            <div class="layui-form-item">
	           		<label class="layui-form-label">活动名称</label>
	           		<div class="layui-input-block" style="width:200px">
	           			<input name="activityName" class="layui-input" type="text" placeholder="请输入内容" lay-verify="title" >
	           		</div>
	           	</div>
	           	<div class="layui-form-item layui-form-text">
	           		<label class="layui-form-label">活动简介</label>
	           		<div class="layui-input-block">
		           		<textarea class="layui-textarea" name="explains" placeholder="请输入内容" style="height:350px;resize:none;"></textarea>
		           	</div>
	           	</div>
	           	<div class="layui-form">
	           		<div class="layui-form-item">
	           			<div class="layui-inline">
	           				<label class="layui-form-label">活动时间</label>
	           				<div class="layui-input-inline" style="width:200px">
	           					<input class="layui-input" name="activityBegin" id="begin" type="text" placeholder="yyyy-MM-dd" >
	           				</div>
	           			</div>
	           			<div id="endDiv" class="layui-inline" style="display:none;">
	           				<div class="layui-form-mid">-</div>
           					<div class="layui-input-inline" style="width:200px">
           						<input class="layui-input" name="activityEnd" id="end" type="text" placeholder="yyyy-MM-dd">
           					</div>
	           			</div>
	           		</div>
	           	</div>
	           	<input name="association.associationId" value="${param.associationId}" type="text">
	           	<input name="status.statusId" value="2" type="text">
	           	<div class="layui-form-item">
	                <button class="layui-btn" type="submit">发布活动</button>
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
<script type="text/javascript">
var today=new Date();
var todayDate=""+(today.getYear()+1900)+"-"+(today.getMonth()+1)+"-"+today.getDate()+" "+today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
var endDate;

$("#begin").blur(function(){
	endDate=$("#begin").val();
	
	layui.use('laydate', function(){
		var laydate = layui.laydate;
	  	laydate.render({
			elem: '#end'
	    	,type: 'datetime'
	    	,min: $("#begin").val()
	  	});
  	});
  	
  	$("#endDiv").show();
});

layui.use('laydate', function(){
  	var laydate = layui.laydate;
  	//日期
  	laydate.render({
		elem: '#begin'
    	,value: todayDate
    	,type: 'datetime'
    	,min: todayDate
    	,isInitValue: true
  	});

});

</script>

</body>
</html>