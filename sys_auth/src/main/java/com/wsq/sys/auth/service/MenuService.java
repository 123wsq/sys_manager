package com.wsq.sys.auth.service;

import java.util.List;
import java.util.Map;

import com.wsq.sys.auth.bean.Tree;
import com.wsq.sys.base.exception.WException;

public interface MenuService {

	List<Tree> queryAuthMenuTree(Map<String, Object> param) throws WException;
}
