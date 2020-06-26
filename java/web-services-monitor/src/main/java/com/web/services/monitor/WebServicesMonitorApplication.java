package com.web.services.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServicesMonitorApplication {

	RequestManager requestManager = new RequestManager();
	
	public static void main(String[] args) {
		SpringApplication.run(WebServicesMonitorApplication.class, args);
	}

}
