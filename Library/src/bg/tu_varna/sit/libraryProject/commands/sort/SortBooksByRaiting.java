package bg.tu_varna.sit.libraryProject.commands.sort;
import java.util.Comparator;

import bg.tu_varna.sit.libraryProject.books.Book;

public class SortBooksByRaiting implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
            return o1.getRaiting().getRaiting().compareTo(o2.getRaiting().getRaiting());
    }   
}
