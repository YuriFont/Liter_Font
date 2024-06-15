package com.yurifont.LiterFont.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public  Author(AuthorData a) {
        this.name = a.name();
        this.birthYear = Optional.ofNullable(a.birth_year()).orElse(0);
        this.deathYear = Optional.ofNullable(a.death_year()).orElse(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        List<String> booksNames = new ArrayList<>();
        this.getBooks().forEach(b -> booksNames.add(b.getTitle()));

        return "\nAuthor - " + this.getName() +
                "\nYear of Birth - " + this.getBirthYear() +
                "\nyear of death - " + this.getDeathYear() +
                "\nBooks - " + booksNames + "\n";
    }
}
