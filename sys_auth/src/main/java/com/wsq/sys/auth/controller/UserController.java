package com.wsq.sys.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wsq.sys.auth.bean.UAI;
import com.wsq.sys.auth.bean.UserAppSession;
import com.wsq.sys.auth.service.UserService;
import com.wsq.sys.base.exception.WException;
import com.wsq.sys.base.utils.JUtil;
import com.wsq.sys.base.utils.RequestParamParse;


@Controller
@RequestMapping("/user/")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Value("#{authConfig}")
	private Properties prop;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("mainPanel")
	public String mainPanel(HttpSession session) {
		UAI uai = (UAI) session.getAttribute("UID");
		// 查询菜单
//		List<MenuInf> menus = menuService.queryAuthAccording(uai.getId(), uai.getSysId());
//		log.debug("用户拥有的菜单树：{}", menus);
		// 查询用户的权限
//		uai.setMenuAuth(menuService.queryAuthMap(uai.getId(), uai.getSysId()));
		session.setAttribute("UID", uai);
		log.debug("用户信息:[{}]", uai.toString());

		return "index";
	}
	
	@RequestMapping("login")
	public ModelAndView onLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();
		
		log.debug("进入到方法");
		Map<String, Object> rspMsg = new HashMap<>();
		Map<String, Object> param=null;
		UAI uai = null;
		try {
			//
			param = RequestParamParse.onRequest(request);
			uai = userService.onLogin(param);
			
		}catch (WException e) {
			// TODO: handle exception
			rspMsg.put("rspcod", e.getCode());
			rspMsg.put("rspmsg", e.getMsg());
		}
		
		if (uai == null) {
			model.addObject(rspMsg);
			model.setViewName("login");
		}else {
			session.setAttribute("UID", uai);
			UserAppSession.setUserSession(uai.getId(), session);
			// 设置session有效时间15分钟
			String timeout = prop.getProperty("loginTimeout");
			if (timeout == null) {
				timeout = "3600";
			}
			// 重定向
			model.setViewName("redirect:user/mainPanel.do");
			rspMsg.put("rspcod", "200");
			rspMsg.put("rspmsg", "登录成功");
			rspMsg.put("redirect", "user/mainPanel.do");
		}
		String reqType = param.get("reqType")+"";
		if ("ajax".equalsIgnoreCase(reqType)) {
			try {
				response.getWriter().write(JUtil.toJsonString(rspMsg));
				response.getWriter().flush();
				// response.getWriter().close();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return model;
	}

}
