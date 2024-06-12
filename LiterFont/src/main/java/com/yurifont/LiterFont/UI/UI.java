package com.yurifont.LiterFont.UI;

import com.yurifont.LiterFont.model.Author;
import com.yurifont.LiterFont.model.BookData;
import com.yurifont.LiterFont.repository.Repository;
import com.yurifont.LiterFont.service.ConsumeAPI;
import com.yurifont.LiterFont.service.ConvertData;

import java.util.Scanner;

public class UI {
    private final Scanner SC = new Scanner(System.in);
    private final String URL = "https://gutendex.com/books/?search=";
    private final ConsumeAPI CAPI = new ConsumeAPI();
    private final ConvertData CD = new ConvertData();
    private Repository repository;

    public UI(Repository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        String menu = """
                
                ------------- Menu -------------
                1 - Search book by name
                2 - List registered books
                3 - List registered authors
                4 - List living authors in a given year
                5 - List books in a given language
                
                """;
        Integer r = 42;

        do {
            System.out.println(menu);
            r = SC.nextInt();

            switch (r) {
                case (0):
                    System.out.println("Leaving...");
                    break ;

                case (1):
                    searchBookByName();
                    break ;

                default:
                    System.out.println("Invalid option!!!");
                    break ;
            }
        } while (r != 0);
    }

    private void searchBookByName() {
        BookData data = this.getBookData();
    }

    private
}
