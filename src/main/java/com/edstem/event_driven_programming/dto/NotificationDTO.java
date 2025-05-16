package com.edstem.event_driven_programming.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
	private Long id;
	private Long userId;
	private String type;
	private String message;
	private boolean isRead;
	private LocalDateTime createdAt;
}
