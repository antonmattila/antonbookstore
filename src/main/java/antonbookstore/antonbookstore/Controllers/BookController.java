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

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/booklist")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bad book id " + id));
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/editbook/{id}")
    public String editbook(@PathVariable Long id, @ModelAttribute Book book) {
        System.out.println("Saving book with ID: " + book.getId());

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublicationYear(book.getPublicationYear());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());

        bookRepository.save(existingBook);

        return "redirect:/booklist";
    }

}
