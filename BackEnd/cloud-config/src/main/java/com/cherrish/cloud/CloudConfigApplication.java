package com.cherrish.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author cherrish
 * @time 2018-01-29 16:19
 * @name CloudConfigApplication
 * @desc: config center
 */
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class CloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigApplication.class, args);
	}
}
