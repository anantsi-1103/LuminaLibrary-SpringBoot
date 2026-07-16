package com.Ducat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Book title cannot be blank")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;

    @NotBlank(message = "Author name cannot be blank")
    @Size(max = 255, message = "Author name cannot exceed 255 characters")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    @Size(max = 50, message = "ISBN cannot exceed 50 characters")
    @Column(unique = true)
    private String isbn;

    @Size(max = 100, message = "Genre cannot exceed 100 characters")
    private String genre;

    @Min(value = 1, message = "Total copies must be at least 1")
    private int totalCopies;

    private int availableCopies;

    public Book(String title, String author, String isbn, String genre, int totalCopies, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

//    no args constructor
//    public Book() {
//    }

//    all constructor
//    public Book(int id, String name, String author, String isbn, String genre, int totalCopies, int availableCopies) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.isbn = isbn;
//        this.genre = genre;
//        this.totalCopies = totalCopies;
//        this.availableCopies = availableCopies;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public int getTotalCopies() {
//        return totalCopies;
//    }
//
//    public void setTotalCopies(int totalCopies) {
//        this.totalCopies = totalCopies;
//    }
//
//    public int getAvailableCopies() {
//        return availableCopies;
//    }
//
//    public void setAvailableCopies(int availableCopies) {
//        this.availableCopies = availableCopies;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", isbn='" + isbn + '\'' +
//                ", genre='" + genre + '\'' +
//                ", totalCopies=" + totalCopies +
//                ", availableCopies=" + availableCopies +
//                '}';
//    }
}
