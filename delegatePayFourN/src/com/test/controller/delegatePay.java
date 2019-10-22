package com.test.controller;

import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.entity.DelegatePayOrder;
import com.test.entity.QueryBalanceData;
import com.test.entity.QueryOrderData;
import com.test.entity.ResponseData;
import com.test.util.HttpUtil;
import com.test.util.Md5Encrypt;


@Controller
public class delegatePay {
	public static final Logger log = LoggerFactory.getLogger(delegatePay.class);
	
	@Value("${accountId}")
	private String accountId;
	
	@Value("${fourElementsPay_url}")
	private String payUrl;
	
	@Value("${queryOrderStatus}")
	private String queryUrl;
	
	@Value("${queryBalance}")
	private String queryBalance;
	
	@Value("${resposne_url}")
	private String responseUrl;
	
	@Value("${key}")
	private String key;
	/**
	 * 发起实时代付订单支付请求
	 * @param delegatePayOrder 请求参数
	 * @return 结果页面
	 */
	@RequestMapping(value="/fourElementsPay")
	public ModelAndView fourElementsPay(DelegatePayOrder delegatePayOrder){
		delegatePayOrder.setAccountId(accountId);
		delegatePayOrder.setResponseUrl(responseUrl);
		delegatePayOrder.setKey(key);
		String mac = "";
		try {
		 mac = Md5Encrypt.md5(delegatePayOrder.getMacStr()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("代付支付MD5加密出错");
			e.printStackTrace();
		}
		delegatePayOrder.setMac(mac);
		String result = HttpUtil.doPost(payUrl, delegatePayOrder.getMap());
		log.info("实时代付请求参数："+delegatePayOrder.getMap());
		//log.info("Mac加密串："+delegatePayOrder.getMacStr());
		//log.info("Mac值："+mac);
        log.info("实时代付响应参数："+result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}
	/**
	 * 实时代付订单查询
	 * @param queryOrderData 查询参数
	 * @return
	 */
	@RequestMapping(value="/queryOrderStatus")
	public ModelAndView queryorder(QueryOrderData queryOrderData){
		queryOrderData.setAccountId(accountId);
		queryOrderData.setKey(key);
		String mac = "";
		try {
			 mac = Md5Encrypt.md5(queryOrderData.getMacStr()).toUpperCase();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				log.info("代付支付MD5加密出错");
				e.printStackTrace();
			}
		queryOrderData.setMac(mac);
		String result = HttpUtil.doPost(queryUrl, queryOrderData.getMap());
		log.info("实时代付订单查询参数："+queryOrderData.getMap());
		log.info("实时代付订单查询结果："+result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}
	/**
	 * 实时代付账户余额查询接口
	 * @param queryBalanceData 查询参数
	 * @return 结果页面
	 */
	@RequestMapping(value="/queryBalance")
	public ModelAndView queryBalance(QueryBalanceData queryBalanceData){
		queryBalanceData.setAccountId(accountId);
		queryBalanceData.setKey(key);
		String mac = "";
		try {
			 mac = Md5Encrypt.md5(queryBalanceData.getMacStr()).toUpperCase();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				log.info("代付查询余额MD5加密出错");
				e.printStackTrace();
			}
		queryBalanceData.setMac(mac);
		String result = HttpUtil.doPost(queryBalance, queryBalanceData.getMap());
		log.info("实时代付余额查询-请求参数："+queryBalanceData.getMap());
		log.info("实时代付余额查询-查询结果："+result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("msg", result);
		return mv;
	}
	/**
	 * 接受实时代付异步通知
	 * @param responseData 响应参数
	 * @return 接受状态
	 */
	@RequestMapping(value="/response")
	public String response(ResponseData responseData){
		log.info("实时代付结果通知："+responseData.toString());
		responseData.setAccountId(accountId);
		responseData.setKey(key);
		String mac = "";
		try {
		 mac = Md5Encrypt.md5(responseData.getMacStr()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("代付支付通知MD5加密出错");
			e.printStackTrace();
		}
		if (responseData.getMac().equals(mac)){
			log.info("实时代付结果通知-验签成功");
			return "验证签名成功success";
		} else {
			log.info("实时代付结果通知-验签失败");
			return "验证签名失败failed";
		}
	}
	@RequestMapping(value="/guide")
	public ModelAndView guide(String destination){
		ModelAndView mv = new ModelAndView();
		if (destination.equals("payOrder")) {
			log.info("实时代付四要素new-订单支付");
			mv.setViewName("payOrder");
		} else if(destination.equals("queryOrder")){
			log.info("实时代付四要素new-订单查询");
			mv.setViewName("queryOrder");
		} else if(destination.equals("queryBlance")){
			log.info("实时代付四要素new-账户余额查询");
			mv.setViewName("queryBlance");
		}
		return mv;
	}
}
