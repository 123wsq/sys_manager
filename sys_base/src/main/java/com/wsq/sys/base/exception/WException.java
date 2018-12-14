package com.wsq.sys.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 异常信息处理类
 * @author wsq
 *
 */
public class WException extends Exception {
	private static Logger log = LoggerFactory.getLogger(WException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -539836596259427728L;
	
	private int code = -1;
	
	private Throwable cause;
	
	/**
	 * 错误描述，不用做客户端展示
	 */
	private String desc = "";
	private String[] args = null;

	public WException(){
		super();
	}
	/**
	 * 通过有参构造函数，自定义错误消息。
	 * @param msgcod 错误代码
	 */
	public WException(int msgcod){
		this.code = msgcod;
		this.println();
	}

	public WException(MsgCode code){
		this.code = code.getCode();
		this.desc = MsgCode.getMsg(this.code);
		this.println();
	}
	/**
	 * 
	 * @param msgcod 错误代码
	 * @param desc 详细错误信息描述
	 * @param args 动态参数
	 */
	public WException(int msgcod,String desc,String... args){
		this.code = msgcod;
		this.desc = desc;
		this.args = args;
		this.println();
	}

	/**
	 * 
	 * @param msgcod 错误代码：6位
	 * @param desc 详细错误信息描述
	 * @param cause Throwable
	 * @param args 动态参数
	 */
	public WException(int msgcod,String desc,Throwable cause,String... args){

		this.desc = desc;
		this.args = args;
		this.code = msgcod;
		this.cause = cause;

		this.println();
	}
	public WException(int msgcod,Throwable cause,String... args){
		this.args = args;
		this.code = msgcod;
		this.cause = cause;

		this.println();
	}
	public void println(){
		
		log.error("错误代码:{} {}",this.getCode(),getLogMsg());
		if(desc != null && !desc.equals("")){
			log.error("错误描述:{}",desc);
		}
		if(this.cause != null){
			log.error(cause.getMessage(),cause);
		}
	}
	public WException(Throwable cause) {
        super(cause);
    }
	/**
	 * 获取异常代码
	 * @return
	 */
	public int getCode(){
		return this.code;
	}
	/**
	 * APP日志
	 * @return
	 */
	public String getMsg(){
		String msg = MsgCode.getMsg(code);
		if(this.args != null && this.args.length > 0){
			for (String value : this.args) {
				msg = msg.replaceFirst("\\{}", value);
			}
		}
		return msg;
	}
	/**
	 * 错误详细描述信息
	 * @param desc
	 */
	public WException detail(String desc){
		this.desc = desc;
		return this;
	}
	/**
	 * 后台日志
	 * @return
	 */
	public String getLogMsg(){
		String msg =  MsgCode.getMsg(code);
		if(this.args != null && this.args.length > 0){
			for (String value : this.args) {
				msg = msg.replaceFirst("\\{}", value);
			}
		}
		return msg;
	}

	public WException setDesc(String desc) {
		this.desc = desc;
		return this;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}

}
