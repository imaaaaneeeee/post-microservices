package org.bte.socialmedia.postservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PostService2Application {

	public static void main(String[] args) {
		SpringApplication.run(PostService2Application.class, args);
	}

}
