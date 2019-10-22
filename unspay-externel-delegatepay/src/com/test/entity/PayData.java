package com.test.entity;

import java.util.HashMap;

public class PayData {

	private String accountId;

	private String name;

	private String cardNo;

	private String orderId;

	private String purpose;

	private String amount;

	private String responseUrl;

	private String mac;

	private String key;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getResponseUrl() {
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl) {
		this.responseUrl = responseUrl;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "delegatePayOrder [accountId=" + accountId + ", name=" + name + ", cardNo=" + cardNo + ", orderId="
				+ orderId + ", purpose=" + purpose + ", amount=" + amount + ",  responseUrl="
				+ responseUrl + ", mac=" + mac + "]";
	}

	public String getMacStr() {
		StringBuffer sf = new StringBuffer();
		sf.append("accountId=").append(accountId);
		sf.append("&name=").append(name);
		sf.append("&cardNo=").append(cardNo);
		sf.append("&orderId=").append(orderId);
		sf.append("&purpose=").append(purpose);
		sf.append("&amount=").append(amount);
		if (responseUrl != "" && responseUrl != null) {
			sf.append("&responseUrl=").append(responseUrl);
		}
		sf.append("&key=").append(key);
		return sf.toString();
	}

	public HashMap<String, String> getMap() {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("accountId", accountId);
		param.put("name", name);
		param.put("cardNo", cardNo);
		param.put("orderId", orderId);
		param.put("purpose", purpose);
		param.put("amount", amount);
		param.put("responseUrl", responseUrl);
		param.put("mac", mac);
		return param;
	}
}
