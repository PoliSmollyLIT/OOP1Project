package bg.tu_varna.sit.libraryProject.commands.sort;
import java.util.Comparator;

import bg.tu_varna.sit.libraryProject.books.Book;

public class SortBooksByYear implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
            return Integer.valueOf(o1.getPublishingYear()).compareTo(Integer.valueOf(o2.getPublishingYear()));
    }   
}