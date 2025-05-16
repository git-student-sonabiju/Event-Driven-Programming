package com.edstem.event_driven_programming.listener;

import com.edstem.event_driven_programming.events.OrderPlacedEvent;
import com.edstem.event_driven_programming.events.ProductOutOfStockEvent;
import com.edstem.event_driven_programming.events.UserRegisteredEvent;
import com.edstem.event_driven_programming.model.Notification;
import com.edstem.event_driven_programming.repository.NotificationRepository;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationEventListener {
	private final NotificationRepository notificationRepository;

	public NotificationEventListener(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@Async
	@EventListener
	public void handleUserRegistered(UserRegisteredEvent userRegisteredEvent) {
		saveNotification(userRegisteredEvent.getUserId(), "USER_REGISTERED", "Welcome " + userRegisteredEvent.getUserName() + "!your account has been created.");
	}

	@Async
	@EventListener
	public void handleOrderPlaced(OrderPlacedEvent orderPlacedEvent) {
		saveNotification(orderPlacedEvent.getUserId(), "ORDER_PLACED", "Your order " + orderPlacedEvent.getOrderNumber() + " has been placed.");
	}

	@Async
	@EventListener
	public void handleProductOutOfStock(ProductOutOfStockEvent productOutOfStockEvent) {
		saveNotification(productOutOfStockEvent.getUserId(), "PRODUCT_OUT_OF_STOCK", "The product " + productOutOfStockEvent.getProductName() + " is out of stock");
	}

	private void saveNotification(Long userId, String type, String message) {
		Notification notification = new Notification();
		notification.setUserId(userId);
		notification.setType(type);
		notification.setMessage(message);
		notification.setRead(false);
		notification.setCreatedAt(LocalDateTime.now());
		notificationRepository.save(notification);
	}
}
