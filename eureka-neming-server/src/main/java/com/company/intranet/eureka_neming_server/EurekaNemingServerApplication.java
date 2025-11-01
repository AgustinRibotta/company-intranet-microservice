package com.company.intranet.eureka_neming_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaNemingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNemingServerApplication.class, args);
	}

}
