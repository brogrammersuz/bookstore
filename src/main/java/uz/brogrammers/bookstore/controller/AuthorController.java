package uz.brogrammers.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.brogrammers.bookstore.entity.Author;
import uz.brogrammers.bookstore.service.AuthorService;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping({"", "/"})
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.getAll());

        return "/author/authors";
    }

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("author", new Author());

        return "author/create";
    }

    @PostMapping("/new")
    public String createAuthor(@ModelAttribute Author author) {
        authorService.save(author);

        return "redirect:/authors/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") Long id, Model model) {
        authorService.findById(id).ifPresent(author -> {
            model.addAttribute("author", author);
        });

        return "author/create";
    }

    @PutMapping("/update")
    public String updateAuthor(@ModelAttribute Author author) {
        authorService.save(author);

        return "redirect:/authors/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);

        return "redirect:/authors";
    }

}
