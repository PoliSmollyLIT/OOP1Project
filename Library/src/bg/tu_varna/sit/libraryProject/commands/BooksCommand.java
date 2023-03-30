package bg.tu_varna.sit.libraryProject.commands;

import java.util.ArrayList;

import bg.tu_varna.sit.libraryProject.books.Book;
import bg.tu_varna.sit.libraryProject.books.BookListSingleton;

public abstract class BooksCommand implements Command{
    private BookListSingleton bookList;

    @Override
    public abstract void runCommand();

    @Override
    public abstract void setParameters(String[] args);
    
    protected ArrayList<Book> getBooksList(){
        return bookList.getAllBooks();
    }
}