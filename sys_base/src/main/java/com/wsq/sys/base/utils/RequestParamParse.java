package com.wsq.sys.base.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestParamParse {
	
	private static Logger logger = LoggerFactory.getLogger(RequestParamParse.class);
	
	public static Map<String, Object> onRequest(HttpServletRequest request){
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String[]> map = request.getParameterMap();
		Iterator<Map.Entry<String, String[]>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = it.next();
			param.put(entry.getKey(), entry.getValue()[0]);
			
		}
		logger.debug("请求参数： {}", param);
		
		return param;
	}

}
