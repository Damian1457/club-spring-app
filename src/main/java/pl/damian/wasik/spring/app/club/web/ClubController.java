package pl.damian.wasik.spring.app.club.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.damian.wasik.spring.app.club.repository.entity.ClubEntity;
import pl.damian.wasik.spring.app.club.service.ClubService;
import pl.damian.wasik.spring.app.club.web.model.Club;

import java.util.List;

@Controller
@RequestMapping(value = "/clubs") // http://localhost:8080/clubs
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public String findAllClubs(Model model) {
        List<Club> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/{id}")
    public String readView(@PathVariable("id") Long id, Model model) {
        Club club = clubService.findById(id);
        model.addAttribute("club", club);
        return "clubs-detail";
    }

    @GetMapping("/new")
    public String createView(Model model) {
        ClubEntity club = new ClubEntity();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("club") Club club,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-create";
        }
        clubService.create(club);
        return "redirect:/clubs";
    }

    @GetMapping("/{id}/update")
    public String updateView(@PathVariable("id") Long id, Model model) {
        Club club = clubService.findById(id);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute("club") Club club,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clubs-edit";
        }
        club.setId(id);
        clubService.update(club);
        return "redirect:/clubs";
    }
}
