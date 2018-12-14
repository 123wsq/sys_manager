package com.wsq.sys.auth.dao;

import java.util.List;
import java.util.Map;

import com.wsq.sys.auth.bean.SysUserInfo;

public interface SysUserInfDao {
	
	
	/**
	 * 查询用户
	 * @param param
	 * @return
	 */
	public List<SysUserInfo> selectUserInfo(Map<String, Object> param);
	
	/**
	 * 更新用户信息
	 * @param param
	 */
	public void updateUser(Map<String, Object> param);
	

}
