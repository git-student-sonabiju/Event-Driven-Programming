package com.edstem.event_driven_programming.service;

import com.edstem.event_driven_programming.dto.NotificationDTO;
import com.edstem.event_driven_programming.model.Notification;
import com.edstem.event_driven_programming.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {
	private final NotificationRepository notificationRepository;

	public List<NotificationDTO> getNotificationsByUserId(Long userId) {
		List<Notification> notifications = notificationRepository.findByUserIdOrderByCreatedAtAsc(userId);
		return notifications.stream().map(this::toDTO).collect(Collectors.toList());
	}

	private NotificationDTO toDTO(Notification notification) {
		NotificationDTO dto = new NotificationDTO();
		dto.setId(notification.getId());
		dto.setUserId(notification.getUserId());
		dto.setMessage(notification.getMessage());
		dto.setRead(notification.isRead());
		dto.setType(notification.getType());
		dto.setCreatedAt(notification.getCreatedAt());
		return dto;
	}
}
