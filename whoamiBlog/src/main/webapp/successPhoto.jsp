<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <style type="text/css">
			*{margin:0px;padding:0px;}
			img{border:0px;display:block;border-radius:2px;}
			body{font-size:12px;color:#666;font-family:"微软雅黑";background:#f9f9f9;}
			/*以“.”开头的css样式 称之为 类样式*/
			.top{width:1000px;height:66px;margin:0 auto;}
			.top .logo{float:left;}
			.top .qq{float:right;line-height:66px;
				font-size:26px;font-weight:bold;}
			.top .qq span{color:#ff5f25;}

			.pic{width:906px;height:1000px;margin:30px auto;}
			.pic ul li{list-style:none;float:left;margin-right:12px;margin-bottom:15px;border-radius:2px; 
			/*css3*/
			box-shadow: 0 1px 3px 0 rgba(0,0,0,0.3);}
			.pic ul li p{width:288px;height:35px;text-align:center;line-height:35px;background:#FFF;}
			/*兼容所有浏览器的*/
			.pic ul li a:hover img{opacity:0.8;filter:alpha(opacity=80);}
		</style>

		<!--引入jquery文件-->
		<script type="text/javascript" src="script/jquery.js"></script>
		<!--引入jquery.lazyload 主要是延时加载-->
		<script type="text/javascript" src="script/jquery.lazyload.js"></script>
		<script type="text/javascript">
			var Img = "images/lazyload.gif";
			jQuery.noConflict()(function(){
				jQuery.noConflict()("img").lazyload({placeholder:Img,effect:"fadeIn"});
			});
		</script>
 </head>
 <body>
 		<div class="pic">
		<ul>
			<s:iterator value="#request.listAllImages" id="imagtype">
			<li>
				<a href="#"><img src="photos/<s:property value="#imagtype.p_name"/>" alt="" width="288" height="180"/></a>
				<p><s:property value="#imagtype.p_name"/></p>
			</li>
			</s:iterator>
		</ul>
	</div>
 		
 </body>
</html>