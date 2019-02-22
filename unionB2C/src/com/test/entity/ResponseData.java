package com.test.entity;

public class ResponseData {
	private String merchantId;
	private String responseMode;
	private String orderId;
	private String currencyType;
	private String amount;
	private String returnCode;
	private String returnMessage;
	private String bankCode;
	private String mac;
	
	 public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getResponseMode() {
		return responseMode;
	}

	public void setResponseMode(String responseMode) {
		this.responseMode = responseMode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "ResponseData [merchantId=" + merchantId + ", responseMode=" + responseMode + ", orderId=" + orderId
				+ ", currencyType=" + currencyType + ", amount=" + amount + ", returnCode=" + returnCode
				+ ", returnMessage=" + returnMessage + ", bankCode=" + bankCode + ", mac=" + mac + "]";
	}
	public String getMacStrPre(){
		StringBuffer sf = new StringBuffer();
		sf.append("merchantId=").append(merchantId);
		sf.append("&responseMode=").append(responseMode);
		sf.append("&orderId=").append(orderId);
		sf.append("&currencyType=").append(currencyType);
		sf.append("&amount=").append(amount);
		sf.append("&returnCode=").append(returnCode);
		sf.append("&returnMessage=").append(returnMessage);
		return sf.toString();
	}
}
