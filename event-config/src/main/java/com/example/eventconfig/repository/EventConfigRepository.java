package com.example.eventconfig.repository;

import com.example.eventconfig.entity.EventConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventConfigRepository extends JpaRepository<EventConfig, Long> {
}
