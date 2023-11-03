package uz.brogrammers.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.brogrammers.bookstore.service.PublisherService;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    public String getPublishers(Model model) {

        model.addAttribute("publishers", publisherService.getAll());
        return "publishers";

    }

}
