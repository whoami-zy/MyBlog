<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>我的主页</title>
<link href='images/top2.jpg' rel='icon' type='image/x-icon' />
</head>
<frameset rows="25%,55%,20%" border="0">
	<frame src="top.jsp"  />
	<frameset cols="30%,*,30%" border="0">
		<frame src="tools.html"  name="lift" />
		<frame src="center.jsp" name="center"/>
		<frame src="day.html"  name="right" />
	</frameset>
	<frame src="final.jsp">
</frameset>
<noframes></noframes>

</html>