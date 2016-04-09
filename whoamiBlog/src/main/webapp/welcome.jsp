<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link href='images/top2.jpg' rel='icon' type='image/x-icon' />
<title></title>
</head>
<body>
		<center>
		
				<h1>登陆成功,欢迎<%=session.getAttribute("SessionName") %></h1>
				
				<%
					response.setHeader("refresh", "3;url='index.jsp'");
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("登陆成功，将在3秒后跳转，如果没有，请点<a href='index.jsp'>主页</a>");
				%>
			
		</center>
</body>
</html>