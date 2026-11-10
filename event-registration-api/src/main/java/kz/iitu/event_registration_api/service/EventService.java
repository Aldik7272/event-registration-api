package kz.iitu.event_registration_api.service;

import kz.iitu.event_registration_api.model.EventInfo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final List<EventInfo> events = new ArrayList<>();

    public EventService() {
        events.add(new EventInfo(1L, "Web Design Workshop", "Auditorium 302"));
        events.add(new EventInfo(2L, "JavaScript Quiz", "Online Zoom"));
        events.add(new EventInfo(3L, "IT Career Talk", "Main Conference Hall"));
    }

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }

    public List<EventInfo> getAllEvents() {
        return events;
    }

    public Optional<EventInfo> getEventById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
}