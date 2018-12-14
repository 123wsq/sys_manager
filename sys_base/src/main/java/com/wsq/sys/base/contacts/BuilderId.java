package com.wsq.sys.base.contacts;

import com.wsq.sys.base.utils.DateFormatUtils;

/**
 * 该类是生成各表中的id
 * @author mayn
 *
 */
public class BuilderId {

	/**
	 * 生成系统用户id  长度是11
	 * 格式：SU
	 * @return
	 */
	public static String createSysUserId() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("SU");
		sBuffer.append(DateFormatUtils.onYear().substring(2, 4));
		sBuffer.append(DateFormatUtils.onMinute());
		sBuffer.append(DateFormatUtils.onDay());
		sBuffer.append(DateFormatUtils.onMillisecond());
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(createSysUserId());
	}
}
