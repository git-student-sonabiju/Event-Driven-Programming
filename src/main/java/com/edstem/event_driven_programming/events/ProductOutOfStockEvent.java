package com.edstem.event_driven_programming.events;

import org.springframework.context.ApplicationEvent;

public class ProductOutOfStockEvent extends ApplicationEvent {
	private final Long userId;
	private final String productName;

	public ProductOutOfStockEvent(Object source, Long userId, String productName) {
		super(source);
		this.userId = userId;
		this.productName = productName;
	}

	public Long getUserId() {
		return userId;
	}

	public String getProductName() {
		return productName;
	}
}
