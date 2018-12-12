package com.wsq.sys.auth.service;

import java.util.Map;

import com.wsq.sys.base.exception.WException;

public interface UserService {
	
	/**
	 * 登录
	 * @param param
	 * @throws Exception
	 */
	Map<String, String> onLogin(Map<String, Object> param) throws WException;

}
