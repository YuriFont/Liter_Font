package com.yurifont.LiterFont.repository;

import com.yurifont.LiterFont.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Author, Long> {
}
