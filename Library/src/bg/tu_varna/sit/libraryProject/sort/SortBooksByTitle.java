package bg.tu_varna.sit.libraryProject.sort;

import java.util.Comparator;

import bg.tu_varna.sit.libraryProject.books.Book;

public class SortBooksByTitle implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
    }   
}
