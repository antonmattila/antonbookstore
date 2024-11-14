package antonbookstore.antonbookstore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import antonbookstore.antonbookstore.Models.*;

import java.util.List;

import antonbookstore.antonbookstore.repository.BookRepository;

@Controller
public class BookController {
    @GetMapping("/index")
    public String index() {
        return "toimii";
    }

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
}
