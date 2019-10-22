package com.test.entity;

public class ResponseData {
	
	private String result_code;
	
	private String result_msg;
	
	private String amount;
	
	private String orderId;
	
	private String mac;
	

	private String key;
	

	private String accountId;

	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getResult_msg() {
		return result_msg;
	}

	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "responseData [result_code=" + result_code + ", result_msg=" + result_msg + ", amount=" + amount
				+ ", orderId=" + orderId + ", mac=" + mac + "]";
	}
	
	public String getMacStr(){
		StringBuffer sf = new StringBuffer();
		sf.append("accountId=").append(accountId);
		sf.append("&orderId=").append(orderId);
		sf.append("&amount=").append(amount);
		sf.append("&result_code=").append(result_code);
		sf.append("&result_msg=").append(result_msg);
		sf.append("&key=").append(key);
		return sf.toString();
	}
	
}
