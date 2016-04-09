<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<title>查看</title>
<link href='images/top2.jpg' rel='icon' type='image/x-icon' />
<script type="text/javascript" src="script/SimpleTextEditorId.js"></script>
<link rel="stylesheet" type="text/css" href="css/SimpleTextEditorId.css">
</head>
<body>
	<div>
		<jsp:include page="top.jsp"></jsp:include>
		<hr />
	</div>
	<br />
	<div>
		<div class="set">
			<s:iterator value="#request.listById.list" id="messtype">
				<div class="text">
					<span>文章时间：</span><br>
					<span class="span_context"><s:property value="#messtype.data_time" /></span> 
				</div>
				<div class="text">
					<span>文章标题：</span><br>
					<span class="span_context"><s:property value="#messtype.title" /></span> 
				</div>
				<div class="text">
					<span>文章内容：</span><br>
					
						<textarea name="context" id="context" cols="60" rows="10">
								<s:property value="#messtype.context" />
						</textarea>
					
				</div>
				<script type="text/javascript">
					var ste = new SimpleTextEditor("context", "ste");
					ste.init();
				</script>
				<div class="text">
				<div class="leaveLanguage">
					<div><span>发表评论</span></div>
					<div >
						<form action="leaveLanguangeAction_addLeaveLanguage" method="post">
						<input type="text" name="m_id" id="m_id" value="<s:property value="#messtype.m_id" />" />
						<span>请留下您的姓名：</span>
						<div class="d_input"><input type="text" class="s_input" name="leavename" placeholder="姓名" /></div>
						<span>请留下您的email：</span><br>
						<div class="d_input"><input type="text" class="s_input" name="email" placeholder="邮箱" /></div>
						<span>请评论：</span><br>
						<div style="padding-left: 50px;width: 500px;"><textarea rows="20" cols="20" class="s_input" name="leavemessage"></textarea></div>
						<div style="padding-left: 50px;padding-bottom: 50px;width: 100px;"><input type="submit" value="提交评论" style="background-color: #3E3032;color: white;" /></div>
						</form>
					</div>
				</div>
		</div>
			</s:iterator>
		</div>	
	</div>
		
</body>
</html>
