package com.test.util;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class HttpUtil {
	/**
	 * get 请求
	 * @param url 请求地址
	 * @return
	 */
	public static String doGet(String url) {
		try {
			// 创建CloseableHttpClient
			HttpClientBuilder builder = HttpClientBuilder.create();
			CloseableHttpClient client = builder.build();
			// 执行
			HttpUriRequest httpGet = new HttpGet(url);
			CloseableHttpResponse response = client.execute(httpGet);
			// 请求发送成功，并得到响应
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 读取服务器返回过来的json字符串数据
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String entityStr = EntityUtils.toString(entity, "UTF-8");
					return entityStr;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * post请求(用于key-value格式的参数)
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map<?, ?> params) {
		try {
			// 定义HttpClient
			HttpClientBuilder builder = HttpClientBuilder.create();
			CloseableHttpClient client = builder.build();
			// 实例化HTTP方法
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new StringEntity("beppe", "UTF-8"));
 
			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Iterator<?> iter = params.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String value = String.valueOf(params.get(name));
				nvps.add(new BasicNameValuePair(name, value));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
			CloseableHttpResponse response = client.execute(httpPost);
			int state = response.getStatusLine().getStatusCode();
 
			// 请求成功
			if (state == HttpStatus.SC_OK) {
				/*
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
				//return sb.toString();
				*/
				// 第二种方法
				HttpEntity entity = response.getEntity();
				String entityStr="";
				if (entity != null) {
					 entityStr = EntityUtils.toString(entity, "utf-8");	
				}
				return entityStr;
			} else {
				System.out.println("POST请求状态码：" + state);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 
	/**
	 * post请求（用于请求json格式的参数）
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, String params) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		String charSet = "UTF-8";
		StringEntity entity = new StringEntity(params, charSet);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			int state = status.getStatusCode();
			if (state == HttpStatus.SC_OK) {
				HttpEntity responseEntity = response.getEntity();
				String jsonString = EntityUtils.toString(responseEntity, charSet);
				return jsonString;
			} else {
				System.out.println("请求返回:" + state + "(" + url + ")");
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main (String[] arg) throws Exception{
		/*
		String myurl = "https://delegate.unspay.com/delegate-collect-front/subcontract/signSimpleSubContractJson";
		
		JSONObject obj = new JSONObject();
		obj.put("accountId", "1120130523134348001");
		obj.put("b", "测试2");
		//String params = obj.toString();
		String params = "{\"accountId\":\"1120130523134348001\"}";
		System.out.println("代扣"+params);
		String result = doPost(myurl,params);
		System.out.println("代扣"+result);
		
		*/
		String myurl1 = "https://www.unspay.com/delegate-pay-front/delegatePay/pay";
		
		 HashMap<String, String> param = new HashMap<String, String>();  
	        param.put("accountId", "1120130523134348001"); 
	    System.out.println(param);   
		String result1 = doPost(myurl1,param);
		System.out.println("测试"+result1);
		
	}
}
