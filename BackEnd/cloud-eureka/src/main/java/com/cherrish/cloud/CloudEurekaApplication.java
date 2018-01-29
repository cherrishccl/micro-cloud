package com.cherrish.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cherrish
 * @time 2018-01-29 16:19
 * @name CloudEurekaApplication
 * @desc: registry center
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaApplication.class, args);
	}
}
