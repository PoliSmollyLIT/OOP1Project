package bg.tu_varna.sit.libraryProject;

import java.util.ArrayList;

public class BookListSingleton {

    private static BookListSingleton bookListSingleton;
    private static ArrayList<Book> books;

    private BookListSingleton() {  }

    public static BookListSingleton getInstance(){
        if(bookListSingleton == null){
            bookListSingleton = new BookListSingleton();
            books = new ArrayList<>();
        }
        return bookListSingleton;
    }

    public static ArrayList<Book> getAllBooks(){
        return books;
    }
    
    public static void addBook(Book book){
        books.add(book);
    }
}
