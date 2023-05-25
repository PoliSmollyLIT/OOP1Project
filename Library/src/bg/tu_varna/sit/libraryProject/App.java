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
         do{
            String emoji = :full_moon:;
            System.out.println(emoji);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            CommandSwitch.runCommand(reader.readLine());
        }while(true);

    }
}
