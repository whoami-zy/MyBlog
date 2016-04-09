<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.whoami.po.*"%>
<%@page import="java.util.*"%>
<%@page import="com.whoami.DAOFactory.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<title>标题</title>
<style type="text/css">
body {
	background: #222222;
	color: #4D4D4D;
	margin-left:100px;
	font: 14px/25px Arial, Helvetica, sans-serif;
}
a{
	text-decoration: none;
	}
	tr{
	display:block; /*将tr设置为块体元素*/
	margin:8px 0;  /*设置tr间距为2px*/
}
#s_data{
	text-shadow:2px 5px 5px rgba(77, 31, 191, 0.57);
	font-size: 15px;
}

#s_title{
	
	display:block;
	font-size: 20px;
	padding-left: 200px;
}
</style>
</head>
<body>
	<table>
		<%
			int k = 0;
			List<message> all = DAOFactory.getMessageDAOInstance().newInsert();
			Iterator<message> iter = all.iterator();
			while (iter.hasNext()) {
				message mess = (message) iter.next();
				k++;
				int id = mess.getM_id();
				String title = mess.getTitle();
				String data = mess.getData_time();
		%>
		<tr>
			<td id="s_data"><%=data%></td>
		</tr>
		<tr>
			<td id="s_title"><a href="messageAction_viewById?id=<%=id%>" target="_blank"><%=title%></a></td>
		</tr>
	<% } %>
	</table>
</body>
</html>