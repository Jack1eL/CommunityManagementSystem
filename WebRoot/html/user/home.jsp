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
    <title>用户主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../res/layui/css/layui.css">
    <link rel="stylesheet" href="../../res/css/global.css">
</head>
<body style="margin-top: 65px;">

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="/">
      <img src="../../res/images/logo.png" alt="layui">
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>前台主页</a> </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/html/user/backindex.jsp"><i class="iconfont icon-jiaoliu"></i>后台主页</a> </li>
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
	<c:if test="${empty sessionScope.Admin}">
		<div class="pp-home pp-panel" style="background-image: url();">
			<div class="layui-container pp-marginTop">
			  <div class="pp-panel pp-panel-user" pad20>
			    <div class="layui-tab layui-tab-brief" lay-filter="user">
			      <ul class="layui-tab-title">
			        <li class="layui-this">管理员登入</li>
			      </ul>
			      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
			        <div class="layui-tab-item layui-show">
			          <div class="layui-form layui-form-pane">
			            <form method="post" action="${pageContext.request.contextPath}/loginAdmin.action">
			              <div class="layui-form-item">
			                <label for="L_email" class="layui-form-label">登录名</label>
			                <div class="layui-input-inline">
			                  <input type="text" id="L_email" name="username" required lay-verify="required" autocomplete="off" class="layui-input">
			                </div>
			              </div>
			              <div class="layui-form-item">
			                <label for="L_pass" class="layui-form-label">密码</label>
			                <div class="layui-input-inline">
			                  <input type="password" id="L_pass" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
			                </div>
			              </div>
			              <!-- <div class="layui-form-item">
			                <label for="L_vercode" class="layui-form-label">人类验证</label>
			                <div class="layui-input-inline">
			                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
			                </div>
			                <div class="layui-form-mid">
			                  <span style="color: #c00;">{{d.vercode}}</span>
			                </div>
			              </div> -->
			              <div class="layui-form-item">
			                <button class="layui-btn" type="submit">立即登录</button>
			              </div>
			            </form>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
</div>
		</div>
	</c:if>
	
	<c:if test="${not empty sessionScope.Admin}">
		<div class="pp-home pp-panel" style="background-image: url();">
		  <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
		  <i class="iconfont icon-renzheng" title="pp社区认证"></i>
		  <h1>${sessionScope.Admin.username }
		    <!-- <i class="iconfont icon-nan"></i> -->
		  </h1>
		  <p class="pp-home-info">
		    <i class="iconfont icon-shijian"></i><span>2018-6-17 加入</span>
		    <i class="iconfont icon-chengshi"></i><span>来自南昌</span>
		  </p>
		
		  <p class="pp-home-sign">（人生仿若一场修行）</p>
		
		  <!-- <div class="pp-sns" data-user="">
		    <a href="javascript:;" class="layui-btn layui-btn-primary pp-imActive" data-type="addFriend">加为好友</a>
		    <a href="javascript:;" class="layui-btn layui-btn-normal pp-imActive" data-type="chat">发起会话</a>
		  </div> -->
		
		</div>
	</c:if>

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

<script src="../../res/layui/layui.js"></script>
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
</script>

</body>
</html>