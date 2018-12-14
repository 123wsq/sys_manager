package com.wsq.sys.auth.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户权限信息,存入Session中。
 * 
 * @author wsq
 *
 */
public class UAI {
	


	

	// 用户信息
	private String id;
	private String userId;
	private String userName;
	private String nickName;
	private String userRandom;


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserRandom() {
		return userRandom;
	}

	public void setUserRandom(String userRandom) {
		this.userRandom = userRandom;
	}



	/**
	 * 是否 第一次登录 如果是的话 需要强制 修改密码<br>
	 * 0 否,1 是
	 *
	 */
	private Integer isFirstLoginFlag;

	// 权限树

	public Integer getIsFirstLoginFlag() {
		return isFirstLoginFlag;
	}

	public void setIsFirstLoginFlag(Integer isFirstLoginFlag) {
		this.isFirstLoginFlag = isFirstLoginFlag;
	}

	

	private Map<String, Boolean> menuAuth = new HashMap<String, Boolean>();



	public UAI(String id, String userId, String userName, String nickName, String userRandom) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.userRandom = userRandom;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Boolean> getMenuAuth() {
		return menuAuth;
	}

	public void setMenuAuth(Map<String, Boolean> menuAuth) {
		this.menuAuth = menuAuth;
	}

	

}
