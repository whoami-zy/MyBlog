<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <footer>
	<div class="wrap-footer zerogrid">
		<div class="row">
			<div class="col-full">
				<div class="wrap-col">
					<h1>whoami</h1>
					<p>whoami的个人博客 www.ltingzyong.com</p>
					<div class="menu-bottom">
						<ul>
							<li><a href="action_index">Home</a></li>
							<li><a href="messageAction_viewAll">Blog</a></li>
							<li><a href="#">About</a></li>
							<li><a href="#">Contact</a></li>
							
						</ul>
						<div class="clear"></div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</footer>
	</div>
 </body>
</html>