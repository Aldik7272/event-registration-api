package kz.iitu.event_registration_api.controller;

import kz.iitu.event_registration_api.model.EventInfo;
import kz.iitu.event_registration_api.service.EventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final EventService eventService;

    @Value("${app.course}")
    private String course;

    @Value("${app.semester}")
    private String semester;

    public RegistrationController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", eventService.getWelcomeMessage());
    }

    @GetMapping("/events")
    public List<EventInfo> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(Map.of("error", "Event with id " + id + " not found")));
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return Map.of(
                "application", "event-registration-api",
                "course", course,
                "semester", semester
        );
    }
}