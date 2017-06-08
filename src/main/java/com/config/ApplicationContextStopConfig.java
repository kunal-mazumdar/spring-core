package com.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStoppedEvent;

@Configuration
public class ApplicationContextStopConfig implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent arg0) {
		System.out.println("** Method invoked when the application context is closed manually. **");
	}
}
