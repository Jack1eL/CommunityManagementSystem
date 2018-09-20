/**top**/
$(document).ready(function(){
	var list=$(".pp-nav"),//获取最外层框架的名称
	promoNumber=list.find("li");	
	promoNumber.on("click",function(){  //为每个按钮绑定一个事件 
		$(this).addClass("layui-this").siblings().removeClass("layui-this");
	});
});
/*社团列表*/
$(document).ready(function(){
	var code = '';
	for(var i=1;i<4;i++){

	
	code+='<li><a class="act-img" href="activity.html"><img src="../res/images/main.jpg"/><span class="act-num">'+"已有"+'<strong class="act-img-t">'+"n"+'</strong>'+"人关注"+'</span><span class="act-number">'+"##人"+'</span></a><div class="act-inner"><h4  href="activity.html" title="">'+"活动名"+'</h4><p class="act-date">'+"活动时间:"+'<span>'+"####"+"~"+"#######"+'</span></p><p>'+"##########"+'</p></div></li>';
	$("#act-list").html(code);
	}
	
});

$(document).ready(function(){
	var list=$(".laypage-main"),//获取最外层框架的名称
	promoNumber=list.find("span");	
	promoNumber.on("click",function(){  //为每个按钮绑定一个事件 
		$(this).addClass("laypage-curr").siblings().removeClass("laypage-curr");
	});
});

$(document).ready(function(){
	var list=$(".pp-case-tab"),//获取最外层框架的名称
	promoNumber=list.find("span a");	
	promoNumber.on("click",function(){  //为每个按钮绑定一个事件 
		$(this).addClass("tab-this").siblings().removeClass("tab-this");
	});
});

/*rank*/
$(document).ready(function(){	
  	$("#rank1").bind("click",function(){
		$("#rank1").addClass("layui-this").siblings().removeClass("layui-this");
		/*siblings是选择父DOM下除了自身以外的DOM，把他们的class属性去掉，没有选择自己*/

		});
	});
$(document).ready(function(){	
  	$("#rank2").bind("click",function(){
		$("#rank2").addClass("layui-this").siblings().removeClass("layui-this");
		/*siblings是选择父DOM下除了自身以外的DOM，把他们的class属性去掉，没有选择自己*/

		});
	});
$(document).ready(function(){
	$(".pp-nav-avatar").bind("mouseover mouseout",function(){
		$(".layui-nav-child").css("display=block");
	});
});