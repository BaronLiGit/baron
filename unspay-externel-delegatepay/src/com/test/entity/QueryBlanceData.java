package com.test.entity;

import java.util.HashMap;

public class QueryBlanceData {
	
	private String accountId;

	private String mac;

	private String key;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
		return "queryBlanceData [accountId=" + accountId + ", mac=" + mac + "]";
	}

	public String getMacStr() {
		StringBuffer sf = new StringBuffer();
		sf.append("accountId=").append(accountId);
		sf.append("&key=").append(key);
		return sf.toString();
	}

	public HashMap<String, String> getMap() {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("accountId", accountId);
		param.put("mac", mac);
		return param;
	}
}
