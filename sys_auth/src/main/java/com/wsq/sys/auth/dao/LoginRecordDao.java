package com.wsq.sys.auth.dao;

import com.wsq.sys.auth.bean.LoginRecordInfo;

public interface LoginRecordDao {

	/**
	 * 插入登录记录
	 * @param loginRecord
	 */
	void insertLoginRecord(LoginRecordInfo loginRecord);
}
