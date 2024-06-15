package com.yurifont.LiterFont.repository;

import com.yurifont.LiterFont.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryBook extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.language LIKE %:language%")
    List<Book> searchBooksByLanguage(String language);
}
