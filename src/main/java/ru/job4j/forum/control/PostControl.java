package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        if (post.getId() == 0) {
            service.create(post);
        } else {
            service.update(post);
        }
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.findById(id));
        return "edit";
    }

    @GetMapping("/postDetails")
    public String postDetails(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.findById(id));
        return "post";
    }
}
