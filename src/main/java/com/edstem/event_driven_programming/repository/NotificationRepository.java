package com.edstem.event_driven_programming.repository;

import com.edstem.event_driven_programming.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByUserIdOrderByCreatedAtAsc(Long userId);
}
