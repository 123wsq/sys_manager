package com.wsq.sys.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wsq.sys.auth.bean.LoginRecordInfo;
import com.wsq.sys.auth.bean.SysUserInfo;
import com.wsq.sys.auth.bean.UAI;
import com.wsq.sys.auth.dao.LoginRecordDao;
import com.wsq.sys.auth.dao.SysUserInfDao;
import com.wsq.sys.auth.service.UserService;
import com.wsq.sys.base.exception.MsgCode;
import com.wsq.sys.base.exception.WException;
import com.wsq.sys.base.utils.DateFormatUtils;


@Service
public class UserServiceImpl  implements UserService{
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SysUserInfDao sysUserInfDao;
	@Autowired
	private LoginRecordDao loginRecordDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UAI onLogin(Map<String, Object> param) throws WException {
		// TODO Auto-generated method stub
		
		UAI uai = null;
		List<SysUserInfo> result = sysUserInfDao.selectUserInfo(param);
		
		if (result.size()==0) {
			throw new WException(MsgCode.USER_NOT_EXIST);
		}
		
		SysUserInfo userInfo = result.get(0);
		String random = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
		uai = new UAI(userInfo.getId()+"", userInfo.getUser_id(), userInfo.getUsername(), userInfo.getNickname(), random);
		log.debug("登录成功，开始修改登录次数");
		Map<String, Object> map = new HashMap<>();
		map.put("login_count", 1);
		map.put("user_id", userInfo.getUser_id());
		sysUserInfDao.updateUser(map);
		LoginRecordInfo loginRecord = new LoginRecordInfo();
		loginRecord.setUser_id(userInfo.getUser_id());
		loginRecord.setAddress("");
		loginRecord.setCreate_time(DateFormatUtils.onCurTime(DateFormatUtils.DATE_FORMAT_2));
		loginRecordDao.insertLoginRecord(loginRecord);
		return uai;
		
	}

}
