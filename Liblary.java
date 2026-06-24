import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Book {
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private int year;
    private String isbn;
    private int pageCount;
    private String language;
    private boolean availability;
    private String dateBorrowed;
    private String dateDue;
    private int borrowPeriod;
    private int timesBorrowed;


    public Book(String title, String genre, String author, String publisher, int year, String isbn, int pageCount, String language) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.language = language;
        this.availability = true;
        this.dateBorrowed = null;
        this.dateDue = null;
        this.borrowPeriod = 0;
        this.timesBorrowed = 0;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }


    public void borrowBook(String dateBorrowed, String dateDue, int borrowPeriod) {
        this.availability = false;
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.borrowPeriod = borrowPeriod;
        this.timesBorrowed++;
    }

    public void returnBook() {
        this.availability = true;
        this.dateBorrowed = null;
        this.dateDue = null;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public boolean isAvailable() {
        return availability;
    }
    public void updateInformation(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }
    public String getPublisher() {
        return publisher;
    }

    public int getPageCount() {
        return pageCount;
    }
}

class Library {
    private String name;
    private String address;
    private int numberOfEmployees;
    private List<Book> books;


    public Library(String name, String address, int numberOfEmployees) {
        this.name = name;
        this.address = address;
        this.numberOfEmployees = numberOfEmployees;
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title, String isbn) {
        // Find and remove the book by title and ISBN
        books.removeIf(book -> book.getTitle().equals(title) && book.getISBN().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return books;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public List<Book> searchBooks(String title, String author, int year, String isbn) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if ((title == null || book.getTitle().equalsIgnoreCase(title))
                    && (author == null || book.getAuthor().equalsIgnoreCase(author))
                    && (year == -1 || book.getYear() == year)
                    && (isbn == null || book.getIsbn().equals(isbn))) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


}

public class domashna {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = enterLibraryData(scanner);


        List<Book> books = enterBooksData(scanner, library);


        scanner.close();


        for (Book book : books) {
            library.addBook(book);
        }


        System.out.println("Информация за библиотеката:");
        System.out.println("Име: " + library.getName());
        System.out.println("Адрес: " + library.getAddress());
        System.out.println("Брой работници: " + library.getNumberOfEmployees());

        System.out.println("\nКниги в библиотеката:");
        List<Book> allBooks = library.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Заглавие: " + book.getTitle());
            System.out.println("Автор: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Наличност: " + (book.isAvailable() ? "Наличен" : "Заета"));
            System.out.println();
        }
    }


    private static Library enterLibraryData(Scanner scanner) {
        System.out.println("Здтавейте, моля въведете информация за библиотеката!:");
        System.out.print("Въведете наименование: ");
        String name = scanner.nextLine();

        System.out.print("Въведете адрес: ");
        String address = scanner.nextLine();

        int numberOfEmployees = -1;
        while (numberOfEmployees <= 0 || numberOfEmployees >= 10) {
            System.out.print("Въведете брой служители: ");
            try {
                numberOfEmployees = Integer.parseInt(scanner.nextLine());
                if (numberOfEmployees <= 0 || numberOfEmployees >= 10) {
                    System.out.println("Броят на служителите трябва да са повече от 0 и по-малък от 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("Моля въведете валидно число");
            }
        }

        return new Library(name, address, numberOfEmployees);
    }


    private static List<Book> enterBooksData(Scanner scanner, Library library) {
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавяне на книга");
            System.out.println("2. Премахване на книга");
            System.out.println("3. Търсене на книга");
            System.out.println("4. Обновяване на книга");
            System.out.println("5. Пълен списък с книги");
            System.out.println("6. Изход");

            System.out.print("Изберете опция (1-6): ");
            int option = scanner.nextInt();

            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Добавяне на нова книга:");

                    System.out.print("Заглавие: ");
                    String title = scanner.nextLine();
                    while (title.length() >= 100) {
                        System.out.println("Заглавието не трябва да е над 100 букви");
                        System.out.print("Заглавие: ");
                        title = scanner.nextLine();
                    }

                    System.out.print("Автор: ");
                    String author = scanner.nextLine();
                    while (author.length() >= 50) {
                        System.out.println("Името на автора не трябва да е над 50 букви");
                        System.out.print("Автор: ");
                        author = scanner.nextLine();
                    }

                    System.out.print("Година на издаване: ");
                    int year = scanner.nextInt();
                    while (year < 0 || year > 2023) {
                        System.out.println("Моля въведете коректна година");
                        System.out.print("Година на издаване: ");
                        year = scanner.nextInt();
                    }
                    scanner.nextLine(); // Consume the newline

                    System.out.print("Издателство: ");
                    String publisher = scanner.nextLine();
                    while (publisher.length() >= 50) {
                        System.out.println("Името на издателството не трябва да е над 50 букви");
                        System.out.print("Издателство: ");
                        publisher = scanner.nextLine();
                    }

                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    while (isbn.length() >= 10) {
                        System.out.println("ISBN не трябва да е над 10 символа");
                        System.out.print("ISBN: ");
                        isbn = scanner.nextLine();
                    }

                    System.out.print("Брой страници: ");
                    int pageCount = scanner.nextInt();
                    while (pageCount <= 0) {
                        System.out.println("Моля въведете коректен брой страници");
                        System.out.print("Брой страници: ");
                        pageCount = scanner.nextInt();
                    }

                    System.out.print("Наличност (да/не): ");
                    boolean availability = scanner.next().equalsIgnoreCase("да");

                    System.out.print("Колко пъти книгата е била взимана: ");
                    int timesBorrowed = scanner.nextInt();
                    while (timesBorrowed < 0) {
                        System.out.println("Моля въведете положително число ");
                        System.out.print("Колко пъти книгата е била взимана: ");
                        timesBorrowed = scanner.nextInt();
                    }

                    // Create a new book and add it to the library
                    Book newBook = new Book(title, null, author, publisher, year, isbn, pageCount, null);
                    library.addBook(newBook);
                    books.add(newBook);

                    break;


                case 2:
                    System.out.print("Моля въведете заглавието и ISBN кода на книгата, която искате да премахнете:\n");
                    System.out.print("Заглавие: ");
                    String removeTitle = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String removeISBN = scanner.nextLine();


                    library.removeBook(removeTitle, removeISBN);
                    books.removeIf(book -> book.getTitle().equals(removeTitle) && book.getISBN().equals(removeISBN));
                    System.out.print("Книгата беше премахната: ");

                    break;
                case 3:
                    System.out.println("Търсене на книга:");

                    System.out.print("Заглавие (или Enter за пропуск): ");
                    String searchTitle = scanner.nextLine();
                    if (searchTitle.isEmpty()) {
                        searchTitle = null;
                    }

                    System.out.print("Автор (или Enter за пропуск): ");
                    String searchAuthor = scanner.nextLine();
                    if (searchAuthor.isEmpty()) {
                        searchAuthor = null;
                    }

                    System.out.print("Година на издаване (-1 за пропуск): ");
                    int searchYear = scanner.nextInt();
                    scanner.nextLine();
                    if (searchYear == -1) {
                        searchYear = -1;
                    }

                    System.out.print("ISBN (или Enter за пропуск): ");
                    String searchISBN = scanner.nextLine();
                    if (searchISBN.isEmpty()) {
                        searchISBN = null;
                    }

                    List<Book> foundBooks = library.searchBooks(searchTitle, searchAuthor, searchYear, searchISBN);
                    if (!foundBooks.isEmpty()) {
                        System.out.println("Намерени книги:");
                        System.out.println("-----------------------------------------------------------------");
                        System.out.printf( "Заглавие", "Автор", "Година", "ISBN");
                        System.out.println("-----------------------------------------------------------------");
                        for (Book foundBook : foundBooks) {
                            System.out.printf( foundBook.getTitle(), foundBook.getAuthor(), foundBook.getYear(), foundBook.getIsbn());
                        }
                        System.out.println("-----------------------------------------------------------------");
                    } else {
                        System.out.println("Книги с посочените параметри не бяха намерени.");
                    }

                    break;
                case 4:
                    System.out.println("Обновяване на книга:");
                    System.out.print("Моля въведете ISBN на книгата, която искате да обновите: ");
                    String updateIsbn = scanner.nextLine();
                    Book bookToUpdate = library.findBookByISBN(updateIsbn);

                    if (bookToUpdate != null) {
                        System.out.println("Избрахте да обновите информация за книга с ISBN номер: " + updateIsbn);
                        System.out.print("Ново заглавие: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Нов автор: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Нова година на издаване: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        System.out.print("Нов ISBN: ");
                        String newIsbn = scanner.nextLine();

                        bookToUpdate.updateInformation(newTitle, newAuthor, newYear, newIsbn);
                        System.out.println("Информацията за книгата с ISBN " + updateIsbn + " беше успешно обновена.");
                    } else {
                        System.out.println("Книга с ISBN " + updateIsbn + " не беше намерена.");
                    }
                    break;
                case 5:

                    List<Book> allBooks = library.getAllBooks();
                    for (Book book : allBooks) {
                        System.out.println("Заглавие: " + book.getTitle());
                        System.out.println("Автор: " + book.getAuthor());
                        System.out.println("Издателство: " + book.getPublisher());
                        System.out.println("Година: " + book.getYear());
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("Брой страници: " + book.getPageCount());
                        System.out.println("----------------------------------------");
                    }
                    break;
                case 6:
                    // Изход
                    System.out.println("Довиждане! До нови срещи!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Невалиден избор. Моля, изберете отново.");
                    break;
            }
        }
    }
}
