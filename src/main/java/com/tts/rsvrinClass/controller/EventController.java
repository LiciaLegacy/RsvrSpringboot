package com.tts.rsvrinClass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvrinClass.model.Event;
import com.tts.rsvrinClass.service.EventServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventServiceImpl eventServiceImpl;
	
	
	//Get all events
	@GetMapping()
	public List<Event> geEvents(){
		return eventServiceImpl.findAll();
	}
	
	//Get Event by id
	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id) {
		return eventServiceImpl.findEventById(id);
		
	}
	
	//Create an event
	@PostMapping()	//this will post to our root event, so we don't need to specify a path here
	public Event saveEvent(@RequestBody Event event) {
		return eventServiceImpl.saveEvent(event);

	}
	
	//Update an event
	@PutMapping("/{id}") //put for updates
	public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
		return eventServiceImpl.updateEventById(id, event);		
	}

	//Delete an event
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventServiceImpl.deleteEventById(id);
	}

}
