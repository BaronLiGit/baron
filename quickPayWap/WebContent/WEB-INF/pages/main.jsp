<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String name =request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>wap快捷支付</title>
</head>
<input type="button" onclick="window.location.href='<%=name+"/forward?status=1" %>'" value='快捷支付接口'><br><br><br><br>
<input type="button" onclick="window.location.href='<%=name+"/forward?status=2" %>'" value="订单状态查询接口"><br><br><br><br>

</body>
</html>