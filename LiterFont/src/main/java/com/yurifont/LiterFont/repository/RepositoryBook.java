package com.yurifont.LiterFont.repository;

import com.yurifont.LiterFont.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book, Long> {
}
