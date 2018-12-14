package com.wsq.sys.auth.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsq.sys.auth.bean.Tree;
import com.wsq.sys.auth.bean.UAI;
import com.wsq.sys.auth.service.MenuService;
import com.wsq.sys.base.exception.WException;
import com.wsq.sys.base.utils.RequestParamParse;

@Controller
@RequestMapping("/auth/menu/")
public class MenuController {
	
	
	private Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;
	
	
	@RequestMapping(value="queryAuthMenu")
	@ResponseBody
	public List<Tree> queryAuthMenu(HttpServletRequest request, HttpSession session){
		
		List<Tree> mList = null;
		try {
			Map<String, Object> param = RequestParamParse.onRequest(request);
			
			String parentId = param.get("parentId")+"";
			//从session中拿取用户id
			UAI uAI=(UAI) session.getAttribute("UID");
			String user_id=uAI.getUserId();
			mList = menuService.queryAuthMenuTree(param);
		}catch (WException e) {
			// TODO: handle exception
			logger.debug(e.getMsg());
		}
		return mList;
	}
}
