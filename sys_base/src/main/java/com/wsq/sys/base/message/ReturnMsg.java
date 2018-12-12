package com.wsq.sys.base.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnMsg {

	private List<?> rows;
	  private int records;
	  private int code = 0;
	  private String msg;
	  private HashMap<String, Object> map = new HashMap<String, Object>();
	  private Object obj;

	  public ReturnMsg()
	  {
	  }

	  public ReturnMsg(Object obj)
	  {
	    this.obj = obj;
	  }

	  public ReturnMsg(int rspcod, String rspmsg)
	  {
	    this.code = rspcod;
	    this.msg = rspmsg;
	  }

	  public ReturnMsg(int records, List<?> rows)
	  {
	    this.records = records;
	    this.rows = rows;
	  }

	  public void put(String key, Object value)
	  {
	    this.map.put(key, value);
	  }

	  public Object getMap()
	  {
	    return this.map;
	  }

	  public void putAll(Map<String, Object> map) {
	    this.map.putAll(map);
	  }

	  public Object getObj()
	  {
	    return this.obj;
	  }

	  public void setObj(Object obj) {
	    this.obj = obj;
	  }

	  public int getcode() {
	    return this.code == 0 ? 200 : this.code;
	  }

	  public void setcode(int rspcod) {
	    this.code = rspcod;
	  }

	  public String getmsg() {
	    return this.msg == null ? "请求成功" : this.msg;
	  }

	  public void setmsg(String rspmsg) {
	    this.msg = rspmsg;
	  }

	  public ReturnMsg setFail()
	  {
	    setcode(201);
	    return this;
	  }

	  public ReturnMsg setFail(String msg)
	  {
	    setcode(201);
	    setmsg(msg);
	    return this;
	  }

	  public ReturnMsg setFail(String msg, String url)
	  {
	    setcode(201);
	    setmsg(msg);

	    return this;
	  }

	  public ReturnMsg setFail(String msg, Map<?, ?> data)
	  {
	    setcode(201);
	    setmsg(msg);

	    return this;
	  }

	  public ReturnMsg setFail(String msg, String url, Map<?, ?> data)
	  {
	    setcode(201);
	    setmsg(msg);

	    return this;
	  }

	  public ReturnMsg setSuccess()
	  {
	    setcode(200);
	    return this;
	  }

	  public ReturnMsg setSuccess(String msg)
	  {
	    setcode(200);
	    setmsg(msg);
	    return this;
	  }

	  public ReturnMsg setSuccess(String msg, String url)
	  {
	    setcode(200);
	    setmsg(msg);

	    return this;
	  }

	  public ReturnMsg setSuccess(String msg, Map<?, ?> data)
	  {
	    setcode(200);
	    setmsg(msg);

	    return this;
	  }

	  public ReturnMsg setSuccess(String msg, String url, Map<?, ?> data)
	  {
	    setcode(200);
	    setmsg(msg);

	    return this;
	  }

	  public int getRecords()
	  {
	    return this.records;
	  }

	  public void setRecords(int records) {
	    this.records = records;
	  }

	  public List<?> getRows() {
	    return this.rows;
	  }

	  public void setRows(List<?> rows) {
	    this.rows = rows;
	  }

	  public void setMsg(int rspcod, String rspmsg)
	  {
	    this.code = rspcod;
	    this.msg = rspmsg;
	  }
}
