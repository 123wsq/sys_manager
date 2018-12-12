package com.wsq.sys.auth.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsq.sys.auth.service.UserService;
import com.wsq.sys.base.exception.WException;
import com.wsq.sys.base.message.ReturnMsg;
import com.wsq.sys.base.utils.RequestParamParse;


@Controller
@RequestMapping("/user/")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("login")
	public ReturnMsg onLogin(HttpServletRequest request) {
		logger.debug("进入到方法");
		ReturnMsg msg = new ReturnMsg();
		try {
		Map<String, Object> param = RequestParamParse.onRequest(request);
		Map<String, String> data = userService.onLogin(param);
		
		}catch (WException e) {
			// TODO: handle exception
			msg.setMsg(e.getCode(), e.getMsg());
		}
		return msg;
	}

}
