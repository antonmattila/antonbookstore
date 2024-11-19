package antonbookstore.antonbookstore.Models;

import java.math.BigDecimal;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private BigDecimal price;

    //Konstruktori
    public Book(String title, String author, int publicationYear, String isbn, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    //Tyhjä konstruktori
    public Book(){}

    //Getterit ja Setterit
    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getPublicationYear(){
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
