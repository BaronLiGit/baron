package com.test.entity;

import java.io.IOException;
import java.util.HashMap;

public class DelegatePayOrder {
	
	
	private String accountId;
	
	private String name;
	
	private String cardNo;
	
	private String orderId;
	
	private String purpose;
	
	private String amount;
	
	private String idCardNo;
	
	private String summary;
	
	private String phoneNo;

	private String responseUrl;
	
	private String businessType;
	
	private String version;
	
	private String mac;
	
	private String key;

	
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getResponseUrl() {
		return responseUrl;
	}

	public void setResponseUrl(String responseUrl) {
		this.responseUrl = responseUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IOException {
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

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "delegatePayOrder [accountId=" + accountId + ", name=" + name + ", cardNo=" + cardNo + ", orderId="
				+ orderId + ", purpose=" + purpose + ", amount=" + amount + ", idCardNo=" + idCardNo + ", summary="
				+ summary + ", phoneNo=" + phoneNo + ", responseUrl=" + responseUrl + ", businessType=" + businessType
				+ ", version=" + version + ", mac=" + mac + "]";
	}
	
	public String getMacStr(){
		StringBuffer sf = new StringBuffer();
		
		sf.append("accountId=").append(accountId);
		sf.append("&name=").append(name);
		sf.append("&cardNo=").append(cardNo);
		sf.append("&orderId=").append(orderId);
		sf.append("&purpose=").append(purpose);
		sf.append("&amount=").append(amount);
		sf.append("&idCardNo=").append(idCardNo);
		sf.append("&summary=").append(summary);
		if(phoneNo !=""&& phoneNo!=null){
			sf.append("&phoneNo=").append(phoneNo);
		}
		if(responseUrl !=""&& responseUrl!=null){
			sf.append("&responseUrl=").append(responseUrl);
		}
		if(businessType !=""&&businessType!=null){
			sf.append("&businessType=").append(businessType);
		}
		
		if(version!=""&& version !=null){
			sf.append("&version=").append(version);
		}
		sf.append("&key=").append(key);
		return sf.toString();
	}
	
	public HashMap<String, String> getMap(){
		HashMap<String, String> param = new HashMap<String, String>();  
        param.put("accountId", accountId); 
        param.put("name", name); 
        param.put("cardNo", cardNo); 
        param.put("orderId", orderId); 
        param.put("purpose", purpose); 
        param.put("amount", amount); 
        param.put("idCardNo", idCardNo); 
        param.put("summary", summary); 
        param.put("phoneNo", phoneNo); 
        param.put("responseUrl", responseUrl); 
        param.put("businessType", businessType); 
        param.put("version", version); 
        param.put("mac", mac); 
        return param;
	}
}
