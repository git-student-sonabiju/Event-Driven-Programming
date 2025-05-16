package com.edstem.event_driven_programming.events;

import org.springframework.context.ApplicationEvent;

public class OrderPlacedEvent extends ApplicationEvent {
	private final Long userId;
	private final String orderNumber;

	public OrderPlacedEvent(Object source, Long userId, String orderNumber) {
		super(source);
		this.userId = userId;
		this.orderNumber = orderNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
}
