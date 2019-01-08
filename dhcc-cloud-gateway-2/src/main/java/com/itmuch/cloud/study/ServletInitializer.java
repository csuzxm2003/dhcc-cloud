package com.itmuch.cloud.study;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * @Description:支持tomcat启动
 * @filename:	ServletInitializer.java
 * @author:		Zhao Xiaoman
 * @version:	1.0  
 * @Date:		2018年12月27日 
 * 
 * 修改历史:  
 * 修改日期                         修改人员                            版本 	   修改内容  
 * ----------------------------------------------  
 * 2018年12月27日   Zhao Xiaoman   1.0   新建
 *
 * 版权:   版权所有(C)2018
 * 公司:   东华云计算有限公司
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulApplication.class);
	}

}
