<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String timeTag = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String orderId = "ysb"+timeTag;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>实时代付四要素支付接口</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h2 align="center">实时代付四要素支付接口</h2>
	<form action =<%=path+"fourElementsPay" %> method="post" target="_blank">
		<table width="600" border="0" cellspacing="5">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>银行卡号</td>
				<td><input type="text" name="cardNo" value=""></td>
			</tr>
			<tr>
				<td>订单号</td>
				<td><input type="text" name="orderId" value=<%=orderId %>></td>
			</tr>
			<tr>
				<td>付款目的</td>
				<td><input type="text" name="purpose" value="代付测试"></td>
			</tr>
			<tr>
				<td>金额</td>
				<td><input type="text" name="amount" value="0.01"></td>
			</tr>
			<tr>
				<td>收款人身份证号</td>
				<td><input type="text" name="idCardNo" value="420528199210163514"></td>
			</tr>
			<tr>
				<td>付款人付款摘要</td>
				<td><input type="text" name="summary" value="代付提现"></td>
			</tr>
			<tr>
				<td>收款人手机号</td>
				<td><input type="text" name="phoneNo" value=""></td>
			</tr>
			<tr>
				<td>业务种类</td>
				<td><input type="text" name="businessType" value="100006"></td>
			</tr>
			<tr>
				<td>版本号参数</td>
				<td><input type="text" name="version" value="1.0.1"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>