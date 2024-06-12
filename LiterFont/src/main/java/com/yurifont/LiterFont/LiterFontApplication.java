package com.yurifont.LiterFont;

import com.yurifont.LiterFont.UI.UI;
import com.yurifont.LiterFont.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterFontApplication implements CommandLineRunner {
	@Autowired
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiterFontApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UI ui = new UI(repository);
	}
}
