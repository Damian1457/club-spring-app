package pl.damian.wasik.spring.app.club.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.damian.wasik.spring.app.club.repository.entity.EventEntity;
import pl.damian.wasik.spring.app.club.service.EventService;
import pl.damian.wasik.spring.app.club.web.model.Event;

import java.util.List;

@Controller
@RequestMapping(value = "/events") // http://localhost:8080/events
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String findAllEvents(Model model) {
        List<Event> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/{id}/new")
    public String createView(@PathVariable("id") Long id, Model model) {
        EventEntity eventEntity = new EventEntity();
        model.addAttribute("id", id);
        model.addAttribute("event", eventEntity);
        return "events-create";
    }

    @PostMapping("/{id}")
    public String create(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model) {
        eventService.create(id, event);
        return "redirect:/clubs/" + id;
    }
}
