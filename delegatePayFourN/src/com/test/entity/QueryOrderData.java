package com.test.entity;

import java.util.HashMap;

public class QueryOrderData {
	
	private String accountId;
	
	private String orderId;
	
	private String key;
	
	private String mac;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "QueryOrderData [accountId=" + accountId + ", orderId=" + orderId + ", mac=" + mac + "]";
	}
	
	public String getMacStr(){
		StringBuffer sf = new StringBuffer();
		sf.append("accountId=").append(accountId);
		sf.append("&orderId=").append(orderId);
		sf.append("&key=").append(key);
		return sf.toString();
	}
	
	public HashMap<String, String> getMap(){
		HashMap<String, String> param = new HashMap<String, String>();  
        param.put("accountId", accountId); 
        param.put("orderId", orderId); 
        param.put("mac", mac); 
        return param;
	}
	
}
