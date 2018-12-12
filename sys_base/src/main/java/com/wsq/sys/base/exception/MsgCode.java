package com.wsq.sys.base.exception;

public enum MsgCode {

	PARAM_NULL(101,"参数不能为空"),
	PARAM_ERROR(102,"参数错误");
	
	private int mCode;
	private String mMsg;
	private MsgCode(int code, String msg) {
		this.mCode = code;
		this.mMsg = msg;
	}
	public static String getMsg(int code) {
		
		for (MsgCode c : MsgCode.values()) {
	        if (c.getCode() == code) {
	            return c.mMsg;
	        }
	        }
	        return null;
	}
	
	public int getCode() {
		return mCode;
	}
	
	public String getMsg() {
		return mMsg;
	}
}
