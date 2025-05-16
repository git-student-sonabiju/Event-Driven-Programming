package com.edstem.event_driven_programming.controller;

import com.edstem.event_driven_programming.dto.NotificationDTO;
import com.edstem.event_driven_programming.events.OrderPlacedEvent;
import com.edstem.event_driven_programming.events.ProductOutOfStockEvent;
import com.edstem.event_driven_programming.events.UserRegisteredEvent;
import com.edstem.event_driven_programming.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {
	private final ApplicationEventPublisher applicationEventPublisher;
	private final NotificationService notificationService;

	@GetMapping("/{userId}")
	public List<NotificationDTO> getNotifications(@PathVariable Long userId) {
		return notificationService.getNotificationsByUserId(userId);
	}

	@PostMapping("/register/{userId}")
	public ResponseEntity<String> testUser(@PathVariable Long userId, @RequestParam String userName) {
		applicationEventPublisher.publishEvent(new UserRegisteredEvent(this, userId, userName));
		return ResponseEntity.ok("UserRegisteredEvent triggered");
	}

	@PostMapping("/test/order")
	public ResponseEntity<String> testOrder(@RequestParam Long userId, @RequestParam String orderNumber) {
		applicationEventPublisher.publishEvent(new OrderPlacedEvent(this, userId, orderNumber));
		return ResponseEntity.ok("OrderPlacedEvent triggered");
	}

	@PostMapping("/test/out_of_stock")
	public ResponseEntity<String> testProduct(@RequestParam Long userId, @RequestParam String productName) {
		applicationEventPublisher.publishEvent(new ProductOutOfStockEvent(this, userId, productName));
		return ResponseEntity.ok("ProductOutOfStockEvent triggered");
	}

}
