function getNowFormatDate() {  
            var date = new Date();  
            var year = date.getFullYear();  
            var month = date.getMonth() + 1;  
            var strDate = date.getDate();  
            var hours = date.getHours();
            var minutes=date.getMinutes();
            var seconds =  date.getSeconds();   
            if (month >= 1 && month <= 9) {  
                month = "0" + month;  
            }  
            if (strDate >= 0 && strDate <= 9) {  
                strDate = "0" + strDate;  
            } 
            if (hours >= 0 && hours <= 9) {  
                hours = "0" + hours;  
            } 
            if (minutes >= 0 && minutes <= 9) {  
                minutes = "0" + minutes;  
            }   
            if (seconds >= 0 && seconds <= 9) {  
                seconds = "0" + seconds;  
            }     
            var currentdate = year + month +  strDate  
              + hours + minutes  
               + seconds;  
            return currentdate;  
        } 
function mymd5(){
	var merchantId = $("#merchantId").val();
	var merchantUrl = $("#merchantUrl").val();
	var responseMode = $("#responseMode").val();
	var orderId = $("#orderId").val();
	var currencyType = $("#currencyType").val();
	var amount = $("#amount").val();
	var assuredPay = $("#assuredPay").val();
	var remark = $("#remark").val();
	var frontURL = $("#frontURL").val();
	var merchantKey = $("#merchantKey").val();
	var time = getNowFormatDate();
	var macStr = "merchantId="+merchantId + "&merchantUrl="+merchantUrl + "&responseMode="+responseMode + "&orderId="+orderId+ "&currencyType="+currencyType
	+"&amount="+amount+"&assuredPay="+assuredPay+"&time="+time+"&remark="+remark+"&merchantKey="+merchantKey;
	var mac = md5(macStr).toUpperCase();
$("#mac").val(mac);
$("#time").val(time);
}