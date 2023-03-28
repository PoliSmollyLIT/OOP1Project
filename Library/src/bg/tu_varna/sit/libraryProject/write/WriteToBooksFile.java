package bg.tu_varna.sit.libraryProject.write;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.books.Book;

public interface WriteToBooksFile extends WriteToFile{
    String filename = "books.xml";
    void writeToFile(Book bookToAdd) throws ParserConfigurationException;    
}