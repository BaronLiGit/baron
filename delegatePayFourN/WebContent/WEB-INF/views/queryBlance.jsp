<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商户账户余额及保证金余额查询接口</title>
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
		<h2 align="center">实时代付商户账户余额及保证金余额查询接口</h2>
		<form action=<%=path+"queryBalance" %> method="post" target="_blank">
			<table width="600" border="0" cellspacing="5">
				<tr align="center">
					<td>商户账户余额及保证金余额查询</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>