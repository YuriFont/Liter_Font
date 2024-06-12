package com.yurifont.LiterFont;

import com.yurifont.LiterFont.UI.UI;
import com.yurifont.LiterFont.repository.RepositoryAuthor;
import com.yurifont.LiterFont.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterFontApplication implements CommandLineRunner {
	@Autowired
	private RepositoryAuthor repositoryAuthor;
	@Autowired
	private RepositoryBook repositoryBook;

	public static void main(String[] args) {
		SpringApplication.run(LiterFontApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UI ui = new UI(repositoryAuthor, repositoryBook);
		ui.showMenu();
    }
}
