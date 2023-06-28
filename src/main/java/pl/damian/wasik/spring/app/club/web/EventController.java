package pl.damian.wasik.spring.app.club.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.damian.wasik.spring.app.club.repository.entity.EventEntity;
import pl.damian.wasik.spring.app.club.service.EventService;
import pl.damian.wasik.spring.app.club.web.model.Event;

import java.text.AttributedString;
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

    @GetMapping("/{id}")
    public String readView(@PathVariable("id") Long id, Model model) {
        Event event = eventService.findByEventId(id);
        model.addAttribute("event", event);
        return "events-detail";
    }

    @GetMapping("/{id}/new")
    public String createView(@PathVariable("id") Long id, Model model) {
        EventEntity eventEntity = new EventEntity();
        model.addAttribute("id", id);
        model.addAttribute("event", eventEntity);
        return "events-create";
    }

    @PostMapping("/{id}")
    public String create(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("event", event);
            return "clubs-create";
        }
        eventService.create(id, event);
        return "redirect:/clubs/" + id;
    }

    @GetMapping("/{id}/update")
    public String updateView(@PathVariable("id") Long id, Model model) {
        Event event = eventService.findByEventId(id);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("{id}/update")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute("event") Event event,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        Event eventNew = eventService.findByEventId(id);
        event.setId(id);
        event.setClubEntity(eventNew.getClubEntity());
        eventService.update(event);
        return "redirect:/events";
    }
}
