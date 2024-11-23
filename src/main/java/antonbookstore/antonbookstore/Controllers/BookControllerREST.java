package antonbookstore.antonbookstore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import antonbookstore.antonbookstore.Models.*;
import antonbookstore.antonbookstore.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/books") // This maps all requests starting with /api/books
public class BookControllerREST {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping //GET ALL
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}") //GET SPESIFI
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));
    }

    @PostMapping //LISÄÄ KIRJA
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (book.getCategory() != null && book.getCategory().getId() != null) {
            Category category = categoryRepository.findById(book.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id " + book.getCategory().getId()));

            book.setCategory(category);
        }
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") //PÄiVITÄ KIRJA
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublicationYear(book.getPublicationYear());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());

        if (book.getCategory() != null && book.getCategory().getId() != null) {
            Category category = categoryRepository.findById(book.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found with id " + book.getCategory().getId()));
            existingBook.setCategory(category);
        }

        Book updatedBook = bookRepository.save(existingBook);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //POISTA KIRJA
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book existingBook = bookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + id));

        bookRepository.delete(existingBook);
        return ResponseEntity.noContent().build();
    }
}
