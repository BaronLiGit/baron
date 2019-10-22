package com.test.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.entity.PayData;
import com.test.entity.QueryBlanceData;
import com.test.entity.QueryOrderData;
import com.test.util.HttpUtil;
import com.test.util.Md5Encrypt;

@Controller
public class ExternelDelegatePay {
	public static final Logger log = LoggerFactory.getLogger(ExternelDelegatePay.class);
	@Value("${accountId}")
	private String accountId;

	@Value("${key}")
	private String key;

	@Value("${url_pay}")
	private String payUrl;

	@Value("${url_queryOrderStatus}")
	private String queryOrderStatusUrl;

	@Value("${url_queryBlance}")
	private String queryBlance;
	/**
	 * 代付订单支付请求
	 * @param payData
	 * @return 返回结果信息
	 */
	@RequestMapping(value = "/Pay")
	public ModelAndView Pay(PayData payData) {
		payData.setAccountId(accountId);
		payData.setKey(key);
		String mac = "";
		try {
			mac = Md5Encrypt.md5(payData.getMacStr()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("MD5加密出错");
			e.printStackTrace();
		}
		payData.setMac(mac);
		String result = HttpUtil.doPost(payUrl, payData.getMap());
		log.info("实时代付请求参数：" + payData.getMap());
		// log.info("Mac加密串："+delegatePayOrder.getMacStr());
		// log.info("Mac值："+mac);
		log.info("实时代付响应参数：" + result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}

	/**
	 * 代付订单查询接口
	 * @param queryOrderData
	 * @return 查询结果信息
	 */
	@RequestMapping(value = "/queryOrderStatus")
	public ModelAndView queryOrderStatus(QueryOrderData queryOrderData) {
		queryOrderData.setAccountId(accountId);
		queryOrderData.setKey(key);
		String mac = "";
		try {
			mac = Md5Encrypt.md5(queryOrderData.getMacStr()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("MD5加密出错");
			e.printStackTrace();
		}
		queryOrderData.setMac(mac);
		String result = HttpUtil.doPost(queryOrderStatusUrl, queryOrderData.getMap());
		log.info("订单查询请求参数：" + queryOrderData.getMap());
		// log.info("Mac加密串："+delegatePayOrder.getMacStr());
		// log.info("Mac值："+mac);
		log.info("订单查询响应参数：" + result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}

	/**
	 * 代付账户余额和保证金余额查询接口
	 * @param queryBlanceData
	 * @return 查询结果
	 */
	@RequestMapping(value = "/queryBlance")
	public ModelAndView queryBlance(QueryBlanceData queryBlanceData) {
		queryBlanceData.setAccountId(accountId);
		queryBlanceData.setKey(key);
		String mac = "";
		try {
			mac = Md5Encrypt.md5(queryBlanceData.getMacStr()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("MD5加密出错");
			e.printStackTrace();
		}
		queryBlanceData.setMac(mac);
		String result = HttpUtil.doPost(queryBlance, queryBlanceData.getMap());
		log.info("余额查询请求参数：" + queryBlanceData.getMap());
		// log.info("Mac加密串："+delegatePayOrder.getMacStr());
		// log.info("Mac值："+mac);
		log.info("余额查询响应参数：" + result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}

	/**
	 * 接受异步通知
	 * @param param Content-Type:application/x-www-form-urlencoded
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/callback")
	@ResponseBody
	public void response(@RequestParam Map<String, String> param) throws UnsupportedEncodingException {
		log.info("实时代付-异步通知" + param.toString());
		String result_code = param.get("result_code");
		String result_msg = param.get("result_msg");
		String orderId = param.get("orderId");
		String amount = param.get("amount");
		String mac = param.get("mac");

		String macStr = "accountId=" + accountId + "&orderId=" + orderId + "&amount=" + amount + "&result_code="
				+ result_code + "&result_msg=" + result_msg + "&key=" + key;
		log.info(macStr);
		String myMac = Md5Encrypt.md5(macStr).toUpperCase();
		log.info(myMac);
		if(mac.equals(myMac)){
			log.info("实时代付-异步通知:验签成功"+orderId);
		}else{
			log.info("实时代付-异步通知:验签失败"+orderId);
		}
	}

	@RequestMapping(value = "/guide")
	public ModelAndView guide(String destination) {
		ModelAndView mv = new ModelAndView();
		if (destination.equals("pay")) {
			log.info("实时代付-订单支付");
			mv.setViewName("externelPay");
		} else if (destination.equals("queryOrderStatus")) {
			log.info("实时代付-订单查询");
			mv.setViewName("queryOrderStatus");
		} else if (destination.equals("queryBlance")) {
			log.info("实时代付-余额查询");
			mv.setViewName("queryBlance");
		}
		return mv;
	}
}
