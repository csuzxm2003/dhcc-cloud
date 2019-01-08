package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieApplication.class, args);
  }
  /*@Bean
  public ServletRegistrationBean getServlet(){ 
	  HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet(); 
	  ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet); 
	  registrationBean.setLoadOnStartup(1); registrationBean.addUrlMappings("/actuator/hystrix.stream"); 
	  registrationBean.setName("HystrixMetricsStreamServlet"); 
	  return registrationBean; 
  }*/
}
