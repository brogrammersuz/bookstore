package uz.brogrammers.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.brogrammers.bookstore.entity.Book;
import uz.brogrammers.bookstore.entity.Publisher;
import uz.brogrammers.bookstore.service.AuthorService;
import uz.brogrammers.bookstore.service.BookService;
import uz.brogrammers.bookstore.service.PublisherService;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping({"", "/"})
    public String getAllBooks(Model model) {
        var list = bookService.getAll();
        model.addAttribute("books", list);

        return "book/books";
    }

    @GetMapping("/new")
    public String getCreateBookForm(Model model) {

        Iterable<Publisher> publishers = publisherService.getAll();
        model.addAttribute("publishers", publishers);

        var authors = authorService.getAll();
        model.addAttribute("authors", authors);

        model.addAttribute("book", new Book());

        return "book/create";

    }

    @PostMapping("/new")
    public String addNewBook(@ModelAttribute Book book) {

        bookService.save(book);

        return "redirect:/books";

    }


}
