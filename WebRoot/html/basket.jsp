<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
  <meta name="keywords" content="{{ lay.base.keywords }}">
  <meta name="description" content="{{ lay.base.description }}">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/global.css">
  <script src="${pageContext.request.contextPath}/res/js/jquery-3.2.1.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/sortable.min.css">
  <script src="${pageContext.request.contextPath}/res/js/sortable.min.js"></script>
  <script src="${pageContext.request.contextPath}/res/js/pp.js"></script>
  <style>
  .header{border-bottom: 1px solid #404553; border-right: 1px solid #404553;}
  </style>
</head>
<body class="pp-full" style="background-image:url(${pageContext.request.contextPath}/res/images/basket-bg.jpg);min-height:900px;">

<div class="pp-header layui-bg-black">
  <div class="layui-container">
    <a class="pp-logo" href="">
      <!-- <img src="../res/images/logo.png" alt="layui"> -->
    </a>
    <ul class="layui-nav pp-nav layui-hide-xs">
      <li class="layui-nav-item layui-this"> 
		  <a href="${pageContext.request.contextPath}/html/index.jsp"><i class="iconfont icon-jiaoliu"></i>主页 </a> 
	  </li>
	  
	  <c:if test="${not empty sessionScope.Student}">
	  	<c:if test="${not empty sessionScope.Student.association}">
	      <li class="layui-nav-item ">
	        <a href="${pageContext.request.contextPath}/html/activity.jsp?associationId=${sessionScope.Student.association.associationId}"><i class="iconfont icon-iconmingxinganli"></i>我的社团</a>
	      </li>
	    </c:if>
	   
	    <c:if test="${empty sessionScope.Student.association}">
	      <li class="layui-nav-item ">
	        你还没有加入社团
	      </li>
	    </c:if>
      </c:if>
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
<div class="htmleaf-container">
		  <main class="sortable">
		    <div class="container">
		      <div class="wrapper">
		        <ul class="sortable__nav nav">
		          <li>
		            <a data-sjslink="all" class="nav__link">
		              	全部
		            </a>
		          </li>
		          <li>
		            <a data-sjslink="image" class="nav__link">
		              	图片
		            </a>
		          </li>
		          <li>
		            <a data-sjslink="article" class="nav__link">
		              	文章
		            </a>
		          </li>
		          <li>
		            <a data-sjslink="video" class="nav__link">
		              	视频
		            </a>
		          </li>
		        </ul>
		        <div id="sortable" class="sjs-default">
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-1.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">摄影社</h2>
		                <p class="card__text">
		                  这位漂亮的小姐姐摄影技术可是一流的哦，她平时...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/activity/basketball-act.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">篮球社</h2>
		                <p class="card__text">
		                  晚间的精彩SOLO赛，来自信工系和机电系的2位高手...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="video">
		            <div class="card">
		              <video>vi</video>
		              <div class="card-infos">
		                <h2 class="card__title">电竞社</h2>
		                <p class="card__text">
		                  王者级别的操作
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/activity/java-act.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Java社</h2>
		                <p class="card__text">
		                  //学习脑图已出，速来围观
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/activity/football-act.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">足球社</h2>
		                <p class="card__text">
		                  这么年轻就能上演帽子戏法，真是令人惊叹的天赋！
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-6.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">Example 6</h2>
		                <p class="card__text">
		                  
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="article">
		            <div class="card">
		              <div class="card-infos">
		                <h2 class="card__title">文学社</h2>
		                <p class="card__text">
		                  “感恩之心，幻化成蝶”雅而不失原本滋色，其实这八个字传递的是一种高度，人生在世因为懂得感恩，所以不再抱怨生活艰辛，因为懂得感恩，所以不去计较过多的利益得失，因为懂得感恩，所以不再在乎快乐或是悲伤，伤或不伤的这段过程本身就是一种幸福。曾看过这样一段话，其出自哈佛大学图书馆馆训：“你所浪费的今天，是昨天死去的人奢望的明天。你所厌恶的现在，是未来的你回不去的曾经。”自己就算再不堪，你还拥有大把的生命去挥霍，你还可以尽情享受生活，张开双手拥抱明早初生的太阳。感恩生命，活着就是最宝贵的拥有。

　　感恩生活

　　说到感恩，首先对自己说上一句谢谢，谢谢你始终默默坚守，谢谢你无论越过多少沟壑，通往前方的路是曲折是坎坷你都从未放弃行走。

　　英国作家萨克雷说：“生活就是一面镜子，你笑，它也笑；你哭，它也哭。”

　　“人有悲欢离合，月有阴晴圆缺。”就如同这诗句一般，人生在世，不如意事十有八九。难过、失落、彷徨注定贯穿在我们的生命线中的，若你过度在意、纠结那你就会始终陷入困顿的沼泽再无法自拔。

　　没有一帆风顺的人生，有的只是内心的波澜不惊，从容不迫。如你抱怨，那你看到的世界处处不顺心意。你若感恩，很多事便化作是过眼烟云。内心保持一份安宁是我们对生命最好的感谢...
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="image">
		            <div class="card">
		              <img class="card__picture" src="${pageContext.request.contextPath}/res/images/gallery-8.jpg" alt="">
		              <div class="card-infos">
		                <h2 class="card__title">网球社</h2>
		                <p class="card__text">
		                  球场如赛场，只有把握每一个发球，才能搏出无限的可能，希望各位能用网球打出人生的精彩！！
		                </p>
		              </div>
		            </div>
		          </div>
		          <div data-sjsel="article">
		            <div class="card">
		              
		              <div class="card-infos">
		                <h2 class="card__title">文学社</h2>
		                <p class="card__text">
		                  半夜时分，一个人躺在床上，四处静谧无声，有一种孤独的感觉如爬虫般悄悄爬上我的心头，辗转反侧，无法入眠。轻轻起来，戴上耳机听音乐，打开书本……

　　 曾经看见过这样一句话：有一种心情叫无助，有一种美丽叫孤独。对耐不住寂寞的人来说，孤独是可怕的，是恐惧的。而对我来说，孤独是生命圆满的开始，是一种静美，不喧嚣，不繁华，是在静谧中独享一个人的清欢。

　　 你看，那独钓寒江雪的柳宗元是孤独的。在下着大雪的江面上，一叶小舟，一个老渔翁，独自在寒冷的江心垂钓。天地之间是如此纯洁而寂静，只剩下他一个人，与万物共谋。一尘不染，万籁无声。这清高孤傲的渔翁，正是柳宗元自己在政治上失意郁闷和苦恼时，隐居在山水之间寄托自己清高而孤傲情感的真实写照。他的幽静过于孤独，过于冷清，不带一点人间烟火的气味。

　　 其实人人骨子里皆有一份别人无法理解，也无法自拔的孤独。只是很多时候，这孤独总会被周遭的喧嚣浮华所蒙蔽，以致造成繁荣的假象。殊不知，不理会这种孤独，在某种意义上而言，我们便不算真正活过。或许我们，本就应该学会享受孤独。在孤独的时候，你才可以听到自己的心跳和呼吸，寻找到迷失的自我。

　　 不知不觉，我也喜欢上了孤独。我的孤独和风月无关，和苦闷无关，有着浓浓的烟火气息，只是一种一个人独处时的欢喜。

　　 我喜欢孤独，不与任何人说话，在一份静谧中安然地做自己喜欢的事。任身心徜徉，暂...
		                </p>
		              </div>
		            </div>
		          </div>
				  <div data-sjsel="video">
		            <div class="card">
		              <video></video>
		              <div class="card-infos">
		                <h2 class="card__title">Example 9</h2>
		                <p class="card__text">
		                  
		                </p>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </main>
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
layui.cache.page = 'user';

layui.config({
  version: "3.0.0"
  ,base: '../res/mods/'
}).extend({
  pp: 'index'
}).use('pp');

document.querySelector('#sortable').sortablejs();
	

</script>
</body>
</html>