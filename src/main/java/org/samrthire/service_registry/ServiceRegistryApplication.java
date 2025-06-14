package org.samrthire.service_registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication implements ApplicationListener<WebServerInitializedEvent> {
	private static final Logger log = LoggerFactory.getLogger(ServiceRegistryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		int port = event.getWebServer().getPort();
		log.warn("\uD83D\uDE80 Application started on port:  {}", port);
		log.warn("Suraj + Jisu Smart-hire the next hiring app");
	}
}
