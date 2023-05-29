package bg.tu_varna.sit.libraryProject.commands.write;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.books.Book;

public interface WriteToBooksFile extends WriteToFile{
    String filename = "src\\bg\\tu_varna\\sit\\libraryProject\\xmls\\books.xml";
    void writeToFile(ArrayList<Book> books) throws ParserConfigurationException;    
}