package com.itmuch.cloud.study.user.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;

import brave.Span;
import brave.Tracer;

@RestController
public class MovieController {
  @Autowired
  private UserFeignClient userFeignClient;
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private Tracer tracer;
  private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);
  
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
	  
	  LOG.info("这是开始a！---------------------------------------");
	  
	  
	  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder .getRequestAttributes(); 
	  HttpServletRequest request = attributes.getRequest(); 
	  Enumeration<String> headerNames = request.getHeaderNames(); 
	  if (headerNames != null) { 
		  while (headerNames.hasMoreElements()) { 
			  String name = headerNames.nextElement(); 
			  String values = request.getHeader(name); 
			  System.out.println(name+"==="+values);
		  } 
	  }
	  Span span = tracer.currentSpan();
	  System.out.println("===================="+span.context());
	  span.finish();
	  
	  LOG.info("这是结束a！---------------------------------------");
    return this.userFeignClient.findById(id);
  }
  
  /**
   * 查询microservice-provider-user服务的信息并返回
   * @return microservice-provider-user服务的信息
   */
  @GetMapping("/user-instance")
  public List<ServiceInstance> showInfo() {
    return this.discoveryClient.getInstances("microservice-provider-user");
  }
}
