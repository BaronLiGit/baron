<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.ResourceBundle"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%
	ResourceBundle res = ResourceBundle.getBundle("config/unspaytest");
	String unspayPayUrl = res.getString("unspay_pay.url");
	String accountId = res.getString("accountId");
	String merchantUrl = res.getString("merchantUrl");
	String key = res.getString("key");
	String frontURL = res.getString("frontURL");
	
	String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String timeTag = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String orderId = "ysb"+timeTag;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>消费网银支付订单请求接口</title>
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/md5.js"></script>
<script type="text/javascript" src="static/b2c.js"></script>
</head>
<style>
div {
	margin: 10%;
	padding: 10%;
	border: 2px solid black;
}
</style>
<body>
	<div>
		<h2 align="center">消费网银支付参数列表</h2>
		<form action=<%=unspayPayUrl%> method="Post" id="unspay">
			<table width=60% border="0" align="center">
				<tr>
					<td align="left">接口版本号：</td>
					<td align="left"><input type="text" id="version"
						name="version" value="unionpayNew" /></td>
				</tr>
				<tr>
					<td align="left">商户编号：</td>
					<td align="left"><input type="text" id="merchantId"
						name="merchantId" value=<%=accountId%> readonly /></td>
				</tr>
				<tr>
					<td align="left">接收数据的响应url：</td>
					<td align="left"><input type="text" id="merchantUrl"
						name="merchantUrl" value=<%=merchantUrl%> /></td>
				</tr>
				<tr>
					<td align="left">响应方式：</td>
					<td align="left"><select id='responseMode' name="responseMode">
							<option value="1">页面响应</option>
							<option value="2">后台响应</option>
							<option value="3" selected>页面后台响应</option>
					</select></td>
				</tr>
				<tr>
					<td align="left">订单号：</td>
					<td align="left"><input type="text" id="orderId"
						name="orderId" value=<%=orderId %> /></td>
				</tr>
				<tr>
					<td align="left">货币类型：</td>
					<td align="left"><input type="text" id="currencyType"
						name="currencyType" value="CNY" /></td>
				</tr>
				<tr>
					<td align="left">支付金额：</td>
					<td align="left"><input type="text" id="amount" name="amount"
						value="0.01" /></td>
				</tr>
				<tr>
					<td align="left">是否通过银生担保支付：</td>
					<td align="left"><input type="text" id="assuredPay"
						name="assuredPay" value="false" /></td>
				</tr>
				<tr>
					<td align="left">备注，附加信息：</td>
					<td align="left"><input type="text" id="remark" name="remark"
						value="test" /></td>
				</tr>
				<tr>
					<td><input type="hidden" id="time" name="time" /></td>
				</tr>
				<tr>
					<td align="left">支付方式：</td>
					<td align="left"><input type="text" id="bankCode"
						name="bankCode" value="" /></td>
				</tr>
				<tr>
					<td align="left">是否B2B网上银行支付：</td>
					<td align="left"><input type="text" id="b2b" name="b2b"
						value="" /></td>
				</tr>
				<tr>
					<td align="left">商品名称：</td>
					<td align="left"><input type="text" id="commodity"
						name="commodity" value="" /></td>
				</tr>
				<tr>
					<td align="left">接入方式：</td>
					<td align="left"><select id='accessMode' name="accessMode">
						<option value="WEB">WEB</option>
						<option value="WAP">WAP</option>
					</select></td>
				</tr>
				<tr>
					<td align="left">订单url ：</td>
					<td align="left"><input type="text" id="orderUrl"
						name="orderUrl" value="" /></td>
				</tr>
				<tr>
					<td align="left">是否允许商联卡担保：</td>
					<td align="left"><input type="text" id="cardAssured"
						name="cardAssured" value="" /></td>
				</tr>
				<tr>
					<td align="left"><input type="hidden" id="merchantKey"
						name="merchantKey" value=<%=key%> readonly /></td>
				</tr>
				<tr>
					<td align="left">商户前台响应地址：</td>
					<td align="left"><input type="text" id="frontURL"
						name="frontURL" value="<%=frontURL%>" /></td>
				</tr>
				<tr>
					<td align="left">卡类型：</td>
					<td align="left"><select id='bankCardType' name="bankCardType">
							<option value="C">贷记卡</option>
							<option value="D" selected>储蓄卡</option>
					</select></td>
				</tr>
				<tr>
					<td align="left">商品简称：</td>
					<td align="left"><input type="text" id="commodityName"
						name="commodityName" value="商家消费" /></td>
				</tr>
				<tr>
					<td align="left">业务种类编码：</td>
					<td align="left"><input type="text" id="businessTypeNO"
						name="businessTypeNO" value="100006" /></td>
				</tr>
				<tr>
					<td align="left">MAC</td>
					<td><input type="text" id="mac" name="mac" /></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="button"
						onclick="mymd5();" value="计算签名"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="确定"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>