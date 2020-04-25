package com.tts.rsvrinClass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tts.rsvrinClass.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	Event findEventById(Long id);
}
