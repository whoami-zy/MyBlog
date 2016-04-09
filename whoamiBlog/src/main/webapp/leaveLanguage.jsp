<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<title>留言</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href='images/top2.jpg' rel='icon' type='image/x-icon' />
<link href="css/leaveLanguage.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<form action="leaveLanguangeAction_addLeaveLanguage" method="post">
		<div class="div1">
			<span>请留下你的名字：</span><br />  <br />
			<input type="text" class="text1" name="leavename" placeholder="姓名" />
		</div>
		<div class="div1">
			<span>请留下你的邮箱：</span><br /> <br /> 
			<input type="text" class="text1" name="email" placeholder="邮箱" />
		</div>
		<div class="div1">
			<span>请留言：</span><br /><br />
			<textarea name="leavemessage" id="info" class="field" cols="30" rows="10" placeholder="骚年，哪有不爽，来喷吧！"></textarea>
		</div>
		<div class="div1">
			<input id="btn" type="submit" value="留言" style="background-color: #3E3032; color: white;" />
		</div>
	</form>
</body>
</html>