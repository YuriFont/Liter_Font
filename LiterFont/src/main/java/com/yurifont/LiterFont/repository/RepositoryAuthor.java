package com.yurifont.LiterFont.repository;

import com.yurifont.LiterFont.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryAuthor extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
