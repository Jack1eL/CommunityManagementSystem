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
      <img src="../../res/images/logo.png" alt="layui">
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
      <ul class="layui-tab-title" id="LAY_mine">
        <li class="layui-this">社团管理（<span>3</span>）</li>
        <li>活动审核（<span>3</span>）</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <ul class="mine-view jie-row" id="backAssociation">
            
          </ul>
          <div style="clear:both;"></div>
	         	<!-- 分页区 -->
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
          <div id="LAY_page"></div>
        </div>
        <div class="layui-tab-item">
          
			
			<ul class="mine-view jie-row" id="activityList">
          	
          </ul>
          <!-- 分页区 -->
			<div style="text-align: center;">
			  <div class="laypage-main">
			    <button id="first1">首页</button>
			    <button id="prev1">上一页</button>
			    <div class="layui-bg-green">第<span id="cur1"></span>页</div>
			    <div class="layui-bg-green">共<span id="tot1"></span>页</div>
			    <button id="next1">下一页</button>
			    <button id="last1">尾页</button>
			  </div>
			</div>
          <div id="LAY_page1"></div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="pp-footer">
  <p><a href="http://pp.layui.com/" target="_blank">pp社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://pp.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/pp/" target="_blank">获取pp社区模版</a>
    <a href="http://pp.layui.com/jie/2461/" target="_blank">微信公众号</a>
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
//----------------社团活动列表相关
//进入页面时异步请求第一页的社团活动列表
ajaxAssociationActivity(1);

//点击首页
$("#first1").click(function(){
	ajaxAssociationActivity(1);
});
//点击上一页
$("#prev1").click(function(){
	ajaxAssociationActivity(parseInt($("#cur1").text())-1);
});
//点击下一页
$("#next1").click(function(){
	ajaxAssociationActivity(parseInt($("#cur1").text())+1);
});
//点击尾页
$("#last1").click(function(){
	ajaxAssociationActivity($("#tot1").text());
});

//----------------社团列表相关
//进入页面时异步请求第一页的社团列表
ajaxAssociation(1,0);

//点击首页
$("#first").click(function(){
	ajaxAssociation(1,0);
});
//点击上一页
$("#prev").click(function(){
	ajaxAssociation(parseInt($("#cur").text())-1,0);
});
//点击下一页
$("#next").click(function(){
	//alert(parseInt($("#cur").text())+1);
	ajaxAssociation(parseInt($("#cur").text())+1,0);
});
//点击尾页
$("#last").click(function(){
	ajaxAssociation($("#tot").text(),0);
});



//异步请求社团列表，进行分页查询
function ajaxAssociation(curPage,statusId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/showAssociation.action?keyWord="+""+"&curPage="+curPage+"&orderType=desc&orderField=name+&status.statusId="+statusId,
		dataType:"json",
		processData:false,
		success:function(data){
			$("#cur").text(data.curPage);		
			$("#tot").text(data.totalPage);		
			var code = '';
			for(var i=0;i<data.associationList.length;i++){
				code+='<li><a class="jie-title" href="${pageContext.request.contextPath}/jie/detail.html" target="_blank">' +data.associationList[i].name+ '</a><i>' +data.associationList[i].explains+ '</i><div class="pp-admin-box data-id=123"><button class="layui-btn layui-btn-xs" id="update'+i+'">编辑</button><button class="layui-btn layui-btn-xs" id="del'+i+'">删除</button></div><em>' +data.associationList[i].status.statusName+ '</em></li>';
				$("#backAssociation").html(code);
				
			}
			//删除按钮的jqeury样式
			for(var i=0;i<data.associationList.length;i++){
			  $("#del"+i).bind('click', function(){
			    layer.open({
			      type: 1,
			      area: ['600px', '360px'],
			      shadeClose: true, //点击遮罩关闭
			      content: '\<\div style="padding:20px;">自定义内容\<\/div>',
			    });
			  });
			}
		}
	});	
}

//异步请求社团活动列表，进行分页查询
function ajaxAssociationActivity(curPage){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/findAllActivity.action?keyWord="+""+"&curPage="+curPage+"&orderType=desc&orderField=activityName",
		dataType:"json",
		processData:false,
		success:function(data){
			$("#cur1").text(data.curPage);		
			$("#tot1").text(data.totalPage);		
			var code = '';
			for(var i=0;i<data.list.length;i++){
				code+='<li><a class="jie-title" href="${pageContext.request.contextPath}/jie/detail.html" target="_blank">' +data.list[i].activityName+ '</a><i>' +data.list[i].explains+ '</i><div class="pp-admin-box data-id=123"><button class="layui-btn layui-btn-xs" id="updateA'+i+'">编辑</button><button class="layui-btn layui-btn-xs" id="delA'+i+'">删除</button></div><em>' +data.list[i].status.statusName+ '</em></li>';
				$("#activityList").html(code);
			}
			
			//删除按钮的jqeury样式
			for(var i=0;i<data.list.length;i++){
			  $("#delA"+i).bind('click', function(){
			    layer.open({
			      type: 1,
			      area: ['600px', '360px'],
			      shadeClose: true, //点击遮罩关闭
			      content: '\<\div style="padding:20px;">自定义内容\<\/div>',
			    });
			  });
			}
		}
	});	
}

</script>

</body>
</html>