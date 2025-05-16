package com.edstem.event_driven_programming.events;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
	private final Long userId;
	private final String userName;

	public UserRegisteredEvent(Object source, Long userId, String userName) {
		super(source);
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public Long getUserId() {
		return userId;
	}
}
