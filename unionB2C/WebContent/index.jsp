<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<% String name =request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消费网银支付</title>
</head>
<style>
	div{
	margin:10%;
	padding:10%;
	border:2px solid black;
	}
</style>
<body>
<div align="center">
<h3 align="center">消费网银支付4.0版本接口调用实例</h3>
<br><br><br><br>
<input type="button" onclick="window.location.href='<%=name+"/guide?destination=pay" %>'" value="5. 商户订单支付接口">
<br><br><br><br>
<input  type="button" onclick="window.location.href='<%=name+"/guide?destination=query" %>'" value="6. 交易状态查询接口">
</div>
</body>
</html>
