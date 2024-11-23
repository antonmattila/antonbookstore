package antonbookstore.antonbookstore.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    //Linkit
    @OneToMany(mappedBy = "category")
    private List<Book> books;

    //Konstruktorit
    public Category(){}

    public Category(String name){
        this.name = name;
    }

    //Get ja Set
    public Long getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public List<Book> getBooks(){
        return books;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }
}
