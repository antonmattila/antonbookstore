package antonbookstore.antonbookstore.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    //Linkit
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

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

    public Set<Book> getBooks(){
        return books;
    }
    public void setBooks(Set<Book> books){
        this.books = books;
    }
}
