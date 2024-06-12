package com.yurifont.LiterFont.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String language;
    private Integer download_count;
    private String authorName;
    @ManyToOne
    private Author author;

    public Book() {}

    public Book(BookData b) {
        this.title = b.title();
        this.language = Arrays.toString(b.languages());
        this.download_count = b.download_count();
        if (!b.authors().isEmpty())
            this.authorName = b.authors().get(0).name();
        else
            this.authorName = "None";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = String.join(", ", language);
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\n***** BOOK *****\n"
                + "Title - " + this.title + "\n"
                + "Language - " + this.language + "\n"
                + "Author - " + this.authorName + "\n"
                + "Downloads count - " + this.download_count + "\n";
    }
}
