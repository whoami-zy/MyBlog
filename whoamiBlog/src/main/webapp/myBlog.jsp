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
    <title>我的博客</title>        
    <link href='images/top2.jpg' rel='icon' type='image/x-icon' />
   <style type="text/css">
   	body {
	background: #222222;
	color: #4D4D4D;
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
	display:block;
	text-shadow:2px 5px 5px rgba(77, 31, 191, 0.57);
	font-size: 15px;
}
#d_title{
	padding-left: 100px;
}
#s_title{
	display:block;
	font-size: 20px;
	padding-left: 200px;
	padding-top: 15px;
}
   </style>
     <script type="text/javascript">
 	function validate(){
 			var page =document.getElementByName("page")[0].value;
 			if(page > <s:property value="#request.listByAll.totalPage"/>){
 				alert("你输入的页数大于最大页数，页面将跳转到首页！");
 				window.document.location.href = "messageAction_viewAll";
 				return false;
 			}
 			return true;
 	}
 </script>
 </head>
 <body>
 	<div>
 				<jsp:include page="top.jsp"></jsp:include>
 				<hr />
 				<br />
 				<div id="d_title">
 				<table>
 					
 					<s:iterator value="#request.listByAll.list" id="messtype">
 					<tr>
			<td id="s_data"><s:property value="#messtype.data_time"/></td>
		</tr>
		<tr>
			<td id="s_title"><a href="messageAction_viewById?id=<s:property value="#messtype.m_id"/>" target="_blank"><s:property value="#messtype.title"/></a></td>
		</tr>
 		</s:iterator>
 				</table>
 				<center>
 			<font size="5">共<font color="red"><s:property value="#request.listByAll.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.listByAll.allRows"/></font>条记录</font><br /><br />
        
        <s:if test="#request.listByAll.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="messageAction_viewAll">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="messageAction_viewAll?page=<s:property value="#request.listByAll.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="#request.listByAll.currentPage != #request.listByAll.totalPage">
            <a href="messageAction_viewAll?page=<s:property value="#request.listByAll.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="messageAction_viewAll?page=<s:property value="#request.listByAll.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center>
    	</div>
 		</div>
 </body>
</html>