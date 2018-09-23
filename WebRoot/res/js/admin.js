$(document).ready(function(){
	var code = '';
	for(var i=1;i<4;i++){

	
	code+='<li><a class="jie-title" href="../jie/detail.html" target="_blank">'+"******活动"+'</a><i>'+"2017/3/14 上午8:30:00"+'</i><a class="mine-edit" href="/jie/edit/8116">'+"编辑"+'</a><a class="mine-edit" href="/">'+"删除"+'</a><em>'+"待审核"+'</em></li>';
	$("#activityList").html(code);
	}
	
});