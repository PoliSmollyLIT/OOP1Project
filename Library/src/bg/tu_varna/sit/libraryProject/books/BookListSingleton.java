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
        return BookListSingleton.books;
    }
    
    public void addBook(Book book){
        if(this.bookExist(book) == false){
            books.add(book);
        }
    }

    public void removeBook(Book bookToRemove){
        Book actualBookToRemove = findBookWithEntereISBN(bookToRemove);
        books.remove(actualBookToRemove);
    }

    public boolean bookExist(Book book) {
            for (Book searchBook : books) {
                if (searchBook.getIsbn().equals(book.getIsbn())) {
                    return true;
                }
            }
        return false;
    }

    private Book findBookWithEntereISBN(Book book){
        Book bookToreturn = new Book.Builder(null, null, null).build();
        for (Book searchBook : books) {
            if (searchBook.getIsbn().equals(book.getIsbn())) {
                bookToreturn = searchBook;
            }
        }
        return bookToreturn;
    }
}
