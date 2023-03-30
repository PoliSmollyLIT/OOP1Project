package bg.tu_varna.sit.libraryProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import bg.tu_varna.sit.libraryProject.books.Author;
//import bg.tu_varna.sit.libraryProject.books.Book;
//import bg.tu_varna.sit.libraryProject.books.Genre;
//import bg.tu_varna.sit.libraryProject.books.Raiting;
import bg.tu_varna.sit.libraryProject.commands.CommandSwitch;

public class App {
    public static void main(String[] args) throws Exception {
       // Author author1 = new Author("Joseph", "Heller"); // cath22
      /* Author author2 = new Author("Douglas", "Adams");
        Book book1 = new Book.Builder("Hitchhikers's guide to life", author2, "1234")
                .withAnotation("really cool book about life")
                .withGenre(Genre.SCI_FI)
                .withKeywords("classic, cool, all-time favourite")
                .withPublishingYear(1979)
                .withRaiting(Raiting.FIVE_STARS)
                .build();

        //System.out.println(book1.getAnotation().toString());
        // Book book2 = new Book.Builder("Cath 22", author1, "1235")
        //         .withAnotation("really cool book about life")
        //         .withGenre(Genre.SCI_FI)
        //         .withKeywords("classic, cool, all-time favourite")
        //         .withPublishingYear(1979)
        //         .withRaiting(Raiting.FIVE_STARS)
        //         .build();

        StringBuilder output1 = new StringBuilder();
        output1.append(book1.getIsbn() + " " + book1.getTitle() + " " + book1.getAuthor() + " " + book1.getPublishingYear() + " " + book1.getGenre());
        //System.out.println(output1);
*/
        do{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            CommandSwitch.runCommand(reader.readLine());
        }while(true);

    }
}
