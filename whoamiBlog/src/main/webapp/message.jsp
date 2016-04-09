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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SimpleTextEditor</title>
<link href='images/top2.jpg' rel='icon' type='image/x-icon' />
<script type="text/javascript" src="script/SimpleTextEditor.js"></script>
<link rel="stylesheet" type="text/css" href="css/SimpleTextEditor.css">

</head>
<body>
	<div>

		<div id="logo">
			<a href="action_index" id="logo-a">whoami的个人博客</a>
		</div>
		<div class="set">
			<form action="messageAction_addMessage" method="post">
				<div class="text">
					<span>文章标题：</span><br>
					<hr />
					<input id="title" type="text" name="title" placeholder="文章标题" />
				</div>
				<div class="text">
					<span>文章内容：</span>
				</div>
				<textarea name="context"  id="context" cols="60" rows="10">
				</textarea>
				<script type="text/javascript">
					var ste = new SimpleTextEditor("context", "ste");
					ste.init();
				</script>
				<div  class="select">
						<select name="see">
							<option selected="selected" value="1">公开</option>
							<option value="0">不公开</option>
						</select>
				</div>
				<div class="submit">
				<input type="submit" value="提交" onclick="ste.submit();">
				</div>
			</form>
		</div>
	</div>
</body>
</html>