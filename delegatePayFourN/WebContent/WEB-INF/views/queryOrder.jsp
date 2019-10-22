<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单状态查询接口</title>
</head>
<style>
div {
	margin: 10%;
	padding: 10%;
	border: 2px solid black;
}
</style>
<body>
	<div align="center">
		<h2 align="center">>实时代付订单查询接口</h2>
		<form action=<%=path+"queryOrderStatus" %> method="post"
			target="_blank">
			<table width="600" border="0" cellspacing="5">
				<tr>
					<td>订单号</td>
					<td><input type="text" name="orderId" value=""></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>