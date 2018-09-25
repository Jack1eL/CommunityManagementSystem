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
		<div class="layui-container pp-marginTop">
  		  <div class="pp-panel">
    		<div class="layui-form layui-form-pane">
      		  <div class="layui-tab layui-tab-brief" lay-filter="user">
        		<ul class="layui-tab-title">
         	 		<li class="layui-this">活动修改<!-- 编辑帖子 --></li>
        		</ul>
        		<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          		  <div class="layui-tab-item layui-show">
            		 <form action="" method="post">
              			<div class="layui-row layui-col-space15 layui-form-item">
                		  <div class="layui-col-md3">
                  			<label class="layui-form-label">活动类型</label>
                  			<div class="layui-input-block">
                    		  <select lay-verify="required" name="class" lay-filter="column">
                       			<option value="0">##</option> 
                      			<option value="99">##</option> 
                      			<option value="100">##</option> 
                      			<option value="101">##</option> 
                      			<option value="168">##</option> 
                      			<option value="169">##</option> 
                    		  </select>
                  			</div>
                		   </div>
               			   <div class="layui-col-md9">
                  		   <label for="L_title" class="layui-form-label">标题</label>
                  		   	 <div class="layui-input-block">
                               <input type="text" id="L_title" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                  		     </div>
                		   </div>
                        </div>
         				<div class="layui-form-item layui-form-text">
                		  <div class="layui-input-block">
                  			<textarea id="L_content" name="content" required lay-verify="required" placeholder="详细描述" class="layui-textarea pp-editor" style="height: 260px;"></textarea>
                          </div>
              			</div>
              			<div class="layui-form-item">
                		  <label for="L_vercode" class="layui-form-label">人类验证</label>
                		  <div class="layui-input-inline">
                  		    <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                		  </div>
                		  <div class="layui-form-mid">
                  			<span style="color: #c00;">1+1=?</span>
                          </div>
                       </div>
              		   <div class="layui-form-item">
                		 <button class="layui-btn" lay-filter="*" lay-submit>完成修改</button>
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



ajaxAssociation(1);
//点击首页
$("#first").click(function(){
	ajaxAssociation(1);
});
//点击上一页
$("#prev").click(function(){
	ajaxAssociation(parseInt($("#cur").text())-1);
});
//点击下一页
$("#next").click(function(){
	//alert(parseInt($("#cur").text())+1);
	ajaxAssociation(parseInt($("#cur").text())+1);
});
//点击尾页
$("#last").click(function(){
	ajaxAssociation($("#tot").text());
});



//异步请求社团列表，进行分页查询
function ajaxAssociation(curPage){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/showAssociation.action?keyWord="+""+"&curPage="+curPage+"&orderType=desc&orderField=name",
		dataType:"json",
		processData:false,
		success:function(data){
			$("#cur").text(data.curPage);		
			$("#tot").text(data.totalPage);		
			var code = '';
			for(var i=0;i<data.associationList.length;i++){
				code+='<li><a class="jie-title" href="${pageContext.request.contextPath}/jie/detail.html" target="_blank">' +data.associationList[i].name+ '</a><i>' +data.associationList[i].explains+ '</i><div class="pp-admin-box data-id=123"><a class="mine-edit href=/jie/edit/8116" >编辑</a><a class="mine-edit" type="del">删除</a></div><em>' +data.associationList[i].status.statusName+ '</em></li>';
				$("#backAssociation").html(code);
			}
		}
	});	
}
</script>

</body>
</html>