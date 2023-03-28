package bg.tu_varna.sit.libraryProject.books;

import java.util.ArrayList;

public class BookListSingleton {

    private static BookListSingleton bookListSingleton;
    private static ArrayList<Book> books;

    private BookListSingleton() { 
          books = new ArrayList<>();
     }

    public static BookListSingleton getInstance(){
        if(bookListSingleton == null){
            bookListSingleton = new BookListSingleton();
        }
        return bookListSingleton;
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }
    
    public void addBook(Book book){
        books.add(book);
    }
}
