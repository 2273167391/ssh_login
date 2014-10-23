package com.tenghu.ssh.core.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Json消息工具类
 * @author arvin
 *
 */
public class JsonMessageUtil {
	private JsonMessageUtil(){}
	
	/**
	 * 返回成功的JSON消息
	 * @param message
	 * @return
	 */
	public static String getSurressJson(String message){
		return "{\"result\":1,\"message\":\""+message+"\"}";
	}
	
	/**
	 * 返回失败的JSON消息
	 * @param message
	 * @return
	 */
	public static String getErrorJson(String message){
		return "{\"result\":0,\"message\":\""+message+"\"}";
	}
	
	/**
	 * 返回集合Json数据
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getListJson(List list){
		if(list.size()==0)
			return getErrorJson("list is null");
		String listJson=JSONObject.toJSONString(list).toString();
		return "{\"result\":1,\"data\":"+listJson+"}";
	}
	
	/**
	 * 获取对象JSON数据
	 * @param obj
	 * @return
	 */
	public static String getObjectJson(Object obj){
		if(null==obj)return getErrorJson("Object is null");
		String objJson=JSONObject.toJSONString(obj).toString();
		return "{\"result\":1,\"data\":"+objJson+"}";
	}
}
