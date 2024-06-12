package com.yurifont.LiterFont.UI;

import com.yurifont.LiterFont.model.Book;
import com.yurifont.LiterFont.model.BookData;
import com.yurifont.LiterFont.model.LibrarieData;
import com.yurifont.LiterFont.repository.RepositoryAuthor;
import com.yurifont.LiterFont.repository.RepositoryBook;
import com.yurifont.LiterFont.service.ConsumeAPI;
import com.yurifont.LiterFont.service.ConvertData;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UI {
    private final Scanner SC = new Scanner(System.in);
    private final String URL = "https://gutendex.com/books/?search=";
    private final ConsumeAPI CAPI = new ConsumeAPI();
    private final ConvertData CD = new ConvertData();
    private RepositoryAuthor repositoryAuthor;
    private RepositoryBook repositoryBook;
    private Optional<Book> searchBook;

    public UI(RepositoryAuthor repositoryAuthor, RepositoryBook repositoryBook) {
        this.repositoryAuthor = repositoryAuthor;
        this.repositoryBook = repositoryBook;
    }

    public void showMenu() {
        String menu = """
                
                ------------- Menu -------------
                1 - Search book by name
                2 - List registered books
                3 - List registered authors
                4 - List living authors in a given year
                5 - List books in a given language
                
                0 - Exit
                
                """;
        int r = 42;

        while (r != 0) {
            try {
                System.out.println(menu);
                r = SC.nextInt();
                SC.nextLine();

                switch (r) {
                    case 0:
                        System.out.println("Leaving...");
                        SC.close();
                        System.exit(0);

                    case 1:
                        searchBookByName();
                        break;

                    case 2:
                        listRegisteredBooks();
                        break;

                    default:
                        System.out.println("Invalid option!!!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                SC.nextLine();
            }
        }
    }

    private void searchBookByName() {
        BookData data = this.getBookData();
        if (data != null) {
            searchBook = Optional.of(new Book(data));
            repositoryBook.save(searchBook.get());
            System.out.println(data);
        } else
            System.out.println("Book not found!!!");
    }

    private BookData getBookData() {
        System.out.print("Enter the name of book want search: ");
        String bookName = SC.nextLine();

        List<Book> bookDataList = repositoryBook.findAll();
        if (!bookDataList.isEmpty()) {
            searchBook = bookDataList.stream()
                    .filter(b -> b.getTitle().toLowerCase().contains(bookName.toLowerCase()))
                    .findFirst();

            if (searchBook.isPresent()) {
                System.out.println("\n" + searchBook.get() + "\n");
                return null;
            }
        }
        String json = CAPI.getData(URL + bookName.replaceAll(" ", "+"));
        LibrarieData librarieData = CD.convertData(json, LibrarieData.class);

        if (librarieData.books().isEmpty())
            return null;
        return librarieData.books().getFirst();
    }

    public void listRegisteredBooks() {
        List<Book> bookList = repositoryBook.findAll();

        if (bookList.isEmpty()) {
            System.out.println("No books have been registered to date!!!");
            return ;
        }
        bookList.forEach(System.out::println);
    }
}
