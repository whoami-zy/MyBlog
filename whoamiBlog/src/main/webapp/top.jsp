<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>       
   		 <link rel="stylesheet" href="css/style.css"> 
    	<link rel="stylesheet" href="css/zerogrid.css">
    	<link rel="stylesheet" href="css/component.css">
    	<link rel="stylesheet" href="css/responsive.css">
 </head>
 <body>
 <div class="wrap-body">
<header>
	<div class="top-header">
		<div class="wrap-top zerogrid">
			<div class="row">
				<div class="top-search"><form method="get" action="" id="search">
				  <input name="q" type="text" size="40" placeholder="Search..." />
				</form></div>
			</div>
		</div>
	</div>
	
	<div class="wrap-header zerogrid">
		<div class="row">
			<div class="col-1-3">
				<div id="logo"><a href="action_index" target="_blank" style="font-size:35px;text-shadow:2px 5px 5px rgba(77, 31, 191, 0.57)">whoami的个人博客</a></div>	
			</div>
			<div class="col-2-3">
				<nav>
					 
					<ul class="menu">
						<li><a href="action_index" target="_blank">我的主页</a></li>
						<li><a href="messageAction_viewAll"  target="_blank">我的日志</a></li>
						<li><a href="photos.jsp"  target="_blank">我的相册</a></li>
						<li><a href="message.jsp"  target="_blank">写日志</a></li>
						<li><a href="action_leaveLanguage"  target="_blank">我的留言</a></li>
						<li><a href="aboutMe.html"  target="_blank">关于我的</a></li>
						<li><a href="contact.html"  target="_blank">联系我</a></li>
					</ul>
				</nav>
			</div>
			
		</div>
	</div>
</header>
</div>
 </body>
</html>