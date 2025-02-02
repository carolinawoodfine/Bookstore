package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.bookstore.domain.BookRepository;


@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/index")
    public String booklist(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
}
