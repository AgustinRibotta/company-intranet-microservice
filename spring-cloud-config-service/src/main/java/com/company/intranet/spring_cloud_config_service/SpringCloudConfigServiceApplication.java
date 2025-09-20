package com.company.intranet.spring_cloud_config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServiceApplication.class, args);
	}

}
