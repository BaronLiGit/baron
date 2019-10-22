package com.test;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demoTest")
public class responseDemo {
	private String key = "";
	private String accountId = "";

	/**
	 * 结果通知
	 * 
	 * @param dcCallBack
	 * @throws Exception
	 */
	@RequestMapping(value = "/action")
	@ResponseBody
	public void responseCollect(@RequestBody Map<String, String> param) throws Exception {
		System.out.println("结果通知:" + param);

		StringBuffer sf = new StringBuffer();
		sf.append("accountId=").append(accountId);
		sf.append("&orderId=").append(param.get("orderId"));
		sf.append("&amount=").append(param.get("amount"));
		sf.append("&result_code=").append(param.get("result_code"));
		sf.append("&result_msg=").append(param.get("result_msg"));
		sf.append("&key=").append(key);
		System.out.println("公众号支付结果通知mac串：" + sf.toString());
		String responseMac = param.get("mac");
		System.out.println("响应mac:" + responseMac);
		String mac = Md5Encrypt.md5(sf.toString()).toUpperCase();
		System.out.println("生成mac:" + mac);
		if (mac.equals(responseMac)) {
			System.out.println("验签成功");
		} else {
			System.out.println("验签失败");
		}

	}

	/**
	 * 接受异步通知
	 * 
	 * @param param
	 *            Content-Type:application/x-www-form-urlencoded
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/callback")
	@ResponseBody
	public void response(@RequestParam Map<String, String> param) throws UnsupportedEncodingException {
		// log.info("异步通知" + param.toString());
		System.out.println("异步通知" + param.toString());
		String result_code = param.get("result_code");
		String result_msg = param.get("result_msg");
		String orderId = param.get("orderId");
		String amount = param.get("amount");
		String mac = param.get("mac");

		String macStr = "accountId=" + accountId + "&orderId=" + orderId + "&amount=" + amount + "&result_code="
				+ result_code + "&result_msg=" + result_msg + "&key=" + key;
		// log.info(macStr);
		String myMac = Md5Encrypt.md5(macStr).toUpperCase();
		// log.info(myMac);
		if (mac.equals(myMac)) {
			// log.info("异步通知:验签成功"+orderId);
			System.out.println("异步通知:验签成功" + orderId);
		} else {
			// log.info("异步通知:验签失败"+orderId);
			System.out.println("异步通知:验签失败" + orderId);
		}
	}

}
