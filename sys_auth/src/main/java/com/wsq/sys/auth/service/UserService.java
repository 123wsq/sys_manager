package com.wsq.sys.auth.service;

import java.util.Map;

import com.wsq.sys.auth.bean.UAI;
import com.wsq.sys.base.exception.WException;

public interface UserService {
	
	/**
	 * 登录
	 * @param param
	 * @throws Exception
	 */
	UAI onLogin(Map<String, Object> param) throws WException;

}
