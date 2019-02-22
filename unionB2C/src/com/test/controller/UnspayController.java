package com.test.controller;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.util.CheckMacUtil;
import com.test.util.HttpUtil;
import com.test.util.Md5Encrypt;
import com.test.entity.ResponseData;
@Controller
public class UnspayController {
	public static final Logger log = LoggerFactory.getLogger(UnspayController.class);
	
	@Value("${key}")
	private String key;
	
	@Value("${accountId}")
	private String accountId;
	
	@Value("${unspay_query.url}")
	private String unspayQueryUrl;
	
	@RequestMapping(value="/queryOrderStatus")
	public ModelAndView queryOrderStatus(HttpServletRequest request){
		log.info("订单查询请求参数："+request);
		StringBuffer sf = new StringBuffer();
		sf.append("merchantId=").append(request.getParameter("merchantId"));
		sf.append("&orderId=").append(request.getParameter("orderId"));
		sf.append("&merchantKey=").append(key);
		String mac="";
		try {
			mac = Md5Encrypt.md5(sf.toString()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("订单查询MD5加密出错");
			e.printStackTrace();
		}
		HashMap<String, String> param = new HashMap<String, String>();  
        param.put("merchantId", request.getParameter("merchantId")); 
        param.put("orderId", request.getParameter("orderId")); 
        param.put("mac", mac);
	 	String result = HttpUtil.doPost(unspayQueryUrl, param);
	 	log.info("订单查询接口返回:"+result);
	 	String[] array = result.split("\\|");
	 	String merchantId = array[0];
	 	String orderId = array[1];
	 	String amount = array[2];
	 	String returnCode = array[3];
	 	String returnMessage = array[4];
	 	String status = array[5];
	 	String mac11 = array[6];
	 	//String fee = array[7];
	 	StringBuffer sf1 = new StringBuffer();
		sf1.append(merchantId).append("|");
		sf1.append(orderId).append("|");
		sf1.append(amount).append("|");
		sf1.append(returnCode).append("|");
		sf1.append(returnMessage).append("|");
		sf1.append(status).append("|");
		sf1.append(key);
		log.info("加密前："+sf1.toString());
		String macquery="";
		try {
			macquery = Md5Encrypt.md5(sf1.toString()).toUpperCase();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.info("订单查询通知MD5加密出错");
			e.printStackTrace();
		}
		log.info("接受到的mac："+mac11);
		log.info("验签mac："+macquery);
		if(macquery.equals(mac11)){
			log.info("验签成功");
		}else {
			log.info("验签失败");
		}
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("result");
	    mv.addObject("msg", result);
		return mv;
	}
	
	
	/**
	 * 后台通知优化
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/callBack")
	@ResponseBody
	public String responseCallBack(@RequestBody Map<String,String> param) throws UnsupportedEncodingException {
		log.info("后台通知"+param);
		param.put("merchantKey", key);
		if(CheckMacUtil.checkMac(param)){
			log.info("验签成功");
		}else{
			log.info("验签失败");	
		}
		return "{\"returnCode\":\"000000\"}";
	}
	
	@RequestMapping(value="/response/merchantUrl")
	@ResponseBody
	public  void resonseBack(ResponseData responseData) throws Throwable{
		if("2".equals(responseData.getResponseMode())){
			log.info("后台通知"+responseData.toString());
			String macstr = responseData.getMacStrPre()+"&merchantKey="+key;
			log.info("验签串："+macstr);
			String mac=Md5Encrypt.md5(macstr).toUpperCase();
			log.info("加密MAC："+mac);
			String responseMac=responseData.getMac();
			log.info("接受的MAC："+responseMac);
			if (responseMac.equals(mac)) {
				log.info("验签成功");
			}else {
				log.info("验签失败");	
			}	
		}
	}
	
	@RequestMapping(value="/response/frontUrl")
	public @ResponseBody ModelAndView resonseFront(ResponseData responseData) throws Throwable{
		if("1".equals(responseData.getResponseMode())){
			log.info("前台通知"+responseData.toString());
			String macstr = responseData.getMacStrPre()+"&merchantKey="+key;
			log.info("验签串："+macstr);
			String mac=Md5Encrypt.md5(macstr).toUpperCase();
			log.info("加密MAC："+mac);
			String responseMac=responseData.getMac();
			log.info("接受的MAC："+responseMac);
			if (responseMac.equals(mac)) {
				log.info("验签成功");
			}else {
				log.info("验签失败");
				
			}	
		}
		ModelAndView mv = new ModelAndView("redirect:http://www.unspay.com/");
		return mv;
	}
	
	@RequestMapping(value = "/guide")
	public ModelAndView guide(String destination) {
		ModelAndView mv = new ModelAndView();
		if (destination.equals("pay")) {
			log.info("消费网银支付-订单支付");
			mv.setViewName("b2cPay");
		} else if(destination.equals("query")){
			log.info("消费网银支付-订单查询");
			mv.setViewName("b2cQuery");
		}
		return mv;
	}
}
