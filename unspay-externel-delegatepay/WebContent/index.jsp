<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
   String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<% String name =request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>unspay-externel-delegatepay实时代付</title>
        <style type="text/css">
            div.main {
                border: 2px solid black;
            }
            div {
                text-align: center;
                margin: 5%;
                padding: 5%;
                top: 10%;
                left: 10%;
                right: 10%;
            }
        </style>
    </head>
    <body>
        <div  class="main">
            <h2>实时代付接口列表</h2>
            <div><input type="button" onclick="window.location.href='<%=name+"/guide?destination=pay" %>'" value="1. 实时代付接口"></div>
            <div><input type="button" onclick="window.location.href='<%=name+"/guide?destination=queryOrderStatus" %>'" value="2. 订单状态查询接口"></input></div>
            <div><input type="button" onclick="window.location.href='<%=name+"/guide?destination=queryBlance" %>'" value="3. 商户账户余额和保证金余额查询接口"></input></div>
        </div>
    </body>
</html>