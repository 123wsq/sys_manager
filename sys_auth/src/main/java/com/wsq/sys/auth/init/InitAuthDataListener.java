package com.wsq.sys.auth.init;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.wsq.sys.auth.bean.UserAppSession;



public class InitAuthDataListener  implements InitializingBean, ServletContextAware{

//	@Autowired MenuService menuService;
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		try {
			//加载数据字典信息至内存
			String auditId="123";
//			menuService.getCheckMenuByAudit(auditId);
			
			UserAppSession.init();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
