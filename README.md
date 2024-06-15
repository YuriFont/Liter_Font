# LiterFont

LiterFont is an application that allows users to search for books using the Gutenberg API and save the information in a PostgreSQL database. The application offers several functionalities to manage and query book and author data.

## Features

- **Search book by name**: Allows the user to search for a book by its title.
- **List registered books**: Displays a list of all books registered in the database.
- **List registered authors**: Displays a list of all authors registered in the database.
- **List living authors in a given year**: Displays a list of authors who were alive in a specific year.
- **List books in a given language**: Displays a list of books in a specific language.

## Technologies Used

- **Language**: Java
- **Framework**: Spring Boot
- **Persistence**: JPA (Java Persistence API)
- **API**: [Gutenberg API](https://gutendex.com/)
- **Database**: PostgreSQL

## Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/LiterFont.git
   cd LiterFont

2. **Configure the application.properties:**
   
   spring.application.name=LiterFont<br>
    
   spring.datasource.url=jdbc:postgresql://localhost/liter_font<br>
   spring.datasource.username="Your PostgreSQL username"<br>
   spring.datasource.password="Your PostgreSQL password"<br>
   spring.datasource.driver-class-name=org.postgresql.Driver<br>
   hibernate.dialect=org.hibernate.dialect.HSQLDialect<br>
   spring.jpa.hibernate.ddl-auto=update<br>
   spring.jpa.show-sql=false<br>
   spring.jpa.format-sql=false
