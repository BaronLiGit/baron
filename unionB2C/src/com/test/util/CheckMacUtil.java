package com.test.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CheckMacUtil {

		public static boolean checkMac(Map<String,String> param) throws UnsupportedEncodingException{
			String macOld = param.get("mac");
			
			String macStr = "merchantId="+param.get("merchantId");
			macStr+="&responseMode="+param.get("responseMode");
			macStr+="&orderId="+param.get("orderId");
			macStr+="&currencyType="+param.get("currencyType");
			macStr+="&amount="+param.get("amount");
			macStr+="&returnCode="+param.get("returnCode");
			macStr+="&returnMessage="+param.get("returnMessage");
			macStr+="&merchantKey="+param.get("merchantKey");
			
			String macNew = Md5Encrypt.md5(macStr).toUpperCase();
			if(macOld.equals(macNew)){
				return true;
			}else{
				return false;
			}
			
		}
}
