$(document).ready(function(){	
	var code ='';
	for(var i=0;i<=4;i++){
	var h='活动'+i+'类型';
	var b='活动名称';
	var s='活动发布者';
	var n='时间~时间';
	
	code+='<li><h2><a class="pp-avatar" href="/u/6497232"><img src="../res/images/avatar/0.jpg"></a><a class="layui-badge">'+h+'</a><a href="jie/detail.html">'+b+'</a></h2><div class="pp-list-info"><a href="##"><cite>'+s+'</cite></a><span class="layui-badge pp-badge-accept layui-hide-xs"><i class="iconfont icon-shijian"></i>'+n+'</span><span class="pp-list-nums"></span></div><div class="pp-list-badge"></div></li>';

	$("#as-list").html(code);
}
});

$(document).ready(function(){
	var list=$(".laypage-main"),//获取最外层框架的名称
	promoNumber=list.find("span");	
	promoNumber.on("click",function(){  //为每个按钮绑定一个事件 
		$(this).addClass("laypage-curr").siblings().removeClass("laypage-curr");
		});
	});