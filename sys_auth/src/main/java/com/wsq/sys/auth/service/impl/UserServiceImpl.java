package com.wsq.sys.auth.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsq.sys.auth.bean.SysUserInfo;
import com.wsq.sys.auth.dao.SysUserInfDao;
import com.wsq.sys.auth.service.UserService;
import com.wsq.sys.base.exception.WException;


@Service
public class UserServiceImpl  implements UserService{
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SysUserInfDao sysUserInfDao;

	@Override
	public Map<String, String> onLogin(Map<String, Object> param) throws WException {
		// TODO Auto-generated method stub
		
		List<SysUserInfo> result = sysUserInfDao.selectUserInfo(param);
		
		log.debug("查询结果:{}", result);;
		
		return null;
		
	}

}
