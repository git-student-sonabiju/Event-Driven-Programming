package com.edstem.event_driven_programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventDrivenProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenProgrammingApplication.class, args);
	}

}
