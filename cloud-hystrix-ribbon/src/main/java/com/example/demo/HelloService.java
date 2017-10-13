package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * EUREKA-CLIENT: 对应的是eureka server application name 大写
	 * 
	 * @param name
	 * @return
	 */
//	public String hiService(String name) {
//		return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
//	}
	
	

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
