package antonbookstore.antonbookstore.Models;

import java.math.BigDecimal;

public class Book {
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
    public String getTitle(String title){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(String author){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getPublicationYear(int publicationYear){
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    public String getIsbn(String isbn){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public BigDecimal getPrice(BigDecimal price){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
