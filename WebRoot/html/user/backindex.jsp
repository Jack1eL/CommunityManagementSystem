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
    <a class="pp-logo" href="">
      <!-- <img src="../res/images/logo.png" alt="layui"> -->
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
        <li class="layui-this">社团管理（<span id="assManage"></span>）<span id="redDot1" class="layui-badge-dot"></span></li>
        <li>活动审核（<span id="actManage"></span>）<span id="redDot2" class="layui-badge-dot"></span></li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <!-- <ul class="mine-view jie-row" id="backAssociation">
            
          </ul> -->
          <table class="layui-table" lay-skin="line">
			  
			  <thead>
			    <tr>
			      <th>社团名</th>
			      <th>社团简介</th>
			      <th>操作</th>
			      <th>状态</th>
			    </tr> 
			  </thead>
			  <tbody id="backAssociation">
			    
			  </tbody>
		  </table>
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
          
			
		  <!-- <ul class="mine-view jie-row" id="activityList">
          	
          </ul> -->
          <table class="layui-table" lay-skin="line">
			  
			  <thead>
			    <tr>
			      <th>活动名</th>
			      <th>活动简介</th>
			      <th>所属社团</th>
			      <th>开始时间</th>
			      <th>结束时间</th>
			      <th>操作</th>
			      <th>状态</th>
			    </tr> 
			  </thead>
			  <tbody id="actList">
			  
			  </tbody>
		  </table>
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

<script src="../../res/layui/layui.js"></script>
<script>

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

var getI;
function caonima(thisId){
	getI=thisId;
}

//异步删除社团
function ajaxDeleteAssociation(associationId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/removeAssociation.action?associationId="+associationId,
		dataType:"json",
		processData:false,
		success:function(data){
			setTimeout(function(){
				window.location.reload();
			}, 1000);
		}
	});	
}

//异步删除社团活动
function ajaxDeleteActivity(activityId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/deleteActivity.action?activityId="+activityId,
		dataType:"json",
		processData:false,
		success:function(data){
			alert("删除成功");
			window.location.reload();	
		}
	});	
}

//异步请求社团列表，进行分页查询
function ajaxAssociation(curPage,statusId){
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/showAssociation.action?keyWord="+""+"&curPage="+curPage+"&orderType=desc&orderField=associationId+&status.statusId="+statusId,
		dataType:"json",
		processData:false,
		success:function(data){
			$("#backAssociation").empty();
			$("#cur").text(data.curPage);		
			$("#tot").text(data.totalPage);		
			var count=0;
			for(var i=0;i<data.associationList.length;i++){
				if(data.associationList[i].status.statusId==2){
					count++;
				}
				var str="";
				if(data.associationList[i].explains.length>=15){
					str=data.associationList[i].explains.substring(0,14)+"...";
				}else{
					str=data.associationList[i].explains.substring(0,data.associationList[i].explains.length);
				}
				if(data.associationList[i].status.statusId==1 || data.associationList[i].status.statusId==3){
					$("#backAssociation").append('<tr><td>'+data.associationList[i].name+'</td><td title="'+data.associationList[i].explains+'">' +str+ '</td><td><button class="layui-btn layui-btn-xs" id="del'+i+'" onClick="caonima(' +data.associationList[i].associationId+ ')">删除</button></td><td>'+data.associationList[i].status.statusName+'</td></tr>');
				}else{
					$("#backAssociation").append('<tr><td>'+data.associationList[i].name+'</td><td title="'+data.associationList[i].explains+'">' +str+ '</td><td><button class="layui-btn layui-btn-xs">通过</button><button class="layui-btn layui-btn-xs">拒绝</button><button class="layui-btn layui-btn-xs" id="del'+i+'" onClick="caonima(' +data.associationList[i].associationId+ ')">删除</button></td><td>'+data.associationList[i].status.statusName+'</td></tr>');
				}
			}
			if(count==0){
				$("#redDot1").css("display","none");
			}
			$("#assManage").text(count);
			
			//删除按钮的jqeury样式
			for(var i=0;i<data.associationList.length;i++){
			  $("#del"+i).bind('click', function(){
			    layer.open({
			      type: 1,
			      title:[''],
			      content:'<div style="text-align:center;margin-top:40px;font-size:18px;">是否确认删除</div>',
			      area: ['350px', '200px'],
				  anim: 6,
			      shadeClose: true, 
				  btnAlign: 'c',
			  	  btn: ['确认', '取消',]
			  	  ,yes: function(index, layero){
			    	ajaxDeleteAssociation(getI);
			    	layer.closeAll();
					layer.msg("删除成功");
			  	  }
			  	  ,btn2: function(index, layero){
			    	//按钮【按钮二】的回调
			    
			    	//return false 开启该代码可禁止点击该按钮关闭
			  	  }
			  	  ,cancel: function(){ 
			    	//右上角关闭回调
			    	//return false 开启该代码可禁止点击该按钮关闭
			  	  }
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
			$("#actList").empty();
			$("#cur1").text(data.curPage);		
			$("#tot1").text(data.totalPage);
			var count=0;
			for(var i=0;i<data.list.length;i++){
				if(data.list[i].status.statusId==2){
					count++;
				}
				var str="";
				if(data.list[i].explains.length>=5){
					str=data.list[i].explains.substring(0,4)+"...";
				}else{
					str=data.list[i].explains.substring(0,data.list[i].explains.length);
				}
				if(data.list[i].status.statusId==1 || data.list[i].status.statusId==3){
					$("#actList").append('<tr><td>'+data.list[i].activityName+'</td><td title="'+data.list[i].explains+'">' +str+ '</td><td>'+data.list[i].association.name+'</td><td>' +data.list[i].activityBegin+ '</td><td>' +data.list[i].activityEnd+ '</td><td><button class="layui-btn layui-btn-xs" id="delA'+i+'" onClick="caonima(' +data.list[i].activityId+ ')">删除</button></td><td>'+data.list[i].status.statusName+'</td></tr>');
				}else{
					$("#actList").append('<tr><td>'+data.list[i].activityName+'</td><td title="'+data.list[i].explains+'">' +str+ '</td><td>'+data.list[i].association.name+'</td><td>' +data.list[i].activityBegin+ '</td><td>' +data.list[i].activityEnd+ '</td><td><button class="layui-btn layui-btn-xs">通过</button><button class="layui-btn layui-btn-xs">拒绝</button><button class="layui-btn layui-btn-xs" id="delA'+i+'" onClick="caonima(' +data.list[i].activityId+ ')">删除</button></td><td>'+data.list[i].status.statusName+'</td></tr>');
				}
			}
			if(count==0){
				$("#redDot2").css("display","none");
			}
			$("#actManage").text(count);
			
			//删除按钮的jqeury样式
			for(var i=0;i<data.list.length;i++){
			  $("#delA"+i).bind('click', function(){
			    layer.open({
			      type: 1,
			      title:[''],
			      content:'<div style="text-align:center;margin-top:40px;font-size:18px;">是否确认删除</div>',
			      area: ['350px', '200px'],
				  anim: 6,
			      shadeClose: true, 
				  btnAlign: 'c',
			  	  btn: ['确认', '取消',]
			  	  ,yes: function(index, layero){
			      	ajaxDeleteActivity(getI);
			      	layer.closeAll();
			  	  }
			  	  ,btn2: function(index, layero){
			    	//按钮【按钮二】的回调
			    
			    	//return false 开启该代码可禁止点击该按钮关闭
			  	  }
			  	  ,cancel: function(){ 
			    	//右上角关闭回调
			    	//return false 开启该代码可禁止点击该按钮关闭
			  	  }
			    });
			  });
			}
			
			
		}
	});	
}

</script>

</body>
</html>