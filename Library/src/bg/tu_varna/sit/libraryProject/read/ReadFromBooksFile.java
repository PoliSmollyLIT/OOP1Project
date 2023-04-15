package bg.tu_varna.sit.libraryProject.read;

import org.w3c.dom.*;

import bg.tu_varna.sit.libraryProject.books.Author;
import bg.tu_varna.sit.libraryProject.books.Book;
import bg.tu_varna.sit.libraryProject.books.BookListSingleton;
import bg.tu_varna.sit.libraryProject.books.Genre;
import bg.tu_varna.sit.libraryProject.books.Raiting;

import javax.xml.parsers.*;
import java.io.File;

public class ReadFromBooksFile extends ReadFromAllFiles implements ReadFromFileBooks {

    private File inputFile;
    private Book.Builder builder;
    private Book book;
    private BookListSingleton bookList = BookListSingleton.getInstance();

    @Override
    public void readFile() {
        try {
            inputFile = fileName;
            if (!inputFile.exists()) {
                inputFile.createNewFile();
                return;
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            NodeList nList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    builder = new Book.Builder(eElement.getElementsByTagName("title").item(0).getTextContent(),
                            new Author.AuthorBuilder(eElement.getElementsByTagName("author").item(0).getTextContent())
                                    .build(),
                            eElement.getElementsByTagName("isbn").item(0).getTextContent());
                    if (eElement.hasAttribute("publishingYear")) {
                        builder.withPublishingYear(Integer
                                .parseInt(eElement.getElementsByTagName("publishingYear").item(0).getTextContent()));
                    }
                    if (eElement.hasAttribute("genre")) {
                        builder.withGenre(
                                Genre.valueOf(eElement.getElementsByTagName("genre").item(0).getTextContent()));
                    }
                    if (eElement.hasAttribute("anotation")) {
                        builder.withAnotation(eElement.getElementsByTagName("anotation").item(0).getTextContent());
                    }
                    if (eElement.hasAttribute("keywords")) {
                        builder.withKeywords(eElement.getElementsByTagName("keywords").item(0).getTextContent());
                    }
                    if (eElement.hasAttribute("raiting")) {
                        builder.withRaiting(
                                Raiting.valueOf(eElement.getElementsByTagName("raiting").item(0).getTextContent()));
                    }
                    book = builder.build();
                    bookList.addBook(book);
                    System.out.println("Successufully opened books.xml");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getFileName(){
        return fileName.getName();
    }
}
