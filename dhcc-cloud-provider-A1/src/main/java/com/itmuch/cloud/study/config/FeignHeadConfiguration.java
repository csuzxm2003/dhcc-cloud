/*package com.itmuch.cloud.study.config;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor; 
*//** 
 * 自定义的请求头处理类，处理服务发送时的请求头； 
 * 将服务接收到的请求头中的uniqueId和token字段取出来，并设置到新的请求头里面去转发给下游服务 
 * 比如A服务收到一个请求，请求头里面包含uniqueId和token字段，A处理时会使用Feign客户端调用B服务 
 * 那么uniqueId和token这两个字段就会添加到请求头中一并发给B服务； 
 * @author mozping 
 * @version 1.0 
 * @date 2018/6/27 14:13 
 * @see FeignHeadConfiguration 
 * @since JDK1.8 
 * *//* 
@Configuration 
public class FeignHeadConfiguration { 
	private static final Logger log = LoggerFactory.getLogger(FeignHeadConfiguration.class); 
	@Bean 
	public RequestInterceptor requestInterceptor() { 
		return requestTemplate -> { 
			ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
			if (attrs != null) { 
				HttpServletRequest request = attrs.getRequest(); 
				Enumeration<String> headerNames = request.getHeaderNames(); 
				if (headerNames != null) { 
					while (headerNames.hasMoreElements()) { 
						String name = headerNames.nextElement(); 
						String value = request.getHeader(name); 
						requestTemplate.header(name, value);
						*//** * 遍历请求头里面的属性字段，将logId和token添加到新的请求头中转发到下游服务 * *//* 
						if ("uniqueId".equalsIgnoreCase(name) || "token".equalsIgnoreCase(name)) { 
							log.debug("添加自定义请求头key:" + name + ",value:" + value); 
							requestTemplate.header(name, value); 
						} else { 
							log.debug("FeignHeadConfiguration", "非自定义请求头key:" + name + ",value:" + value + "不需要添加!"); 
						} 
					} 
				} else { 
					log.warn("FeignHeadConfiguration", "获取请求头失败！"); 
				} 
			} 
		}; 
	} 
}
*/