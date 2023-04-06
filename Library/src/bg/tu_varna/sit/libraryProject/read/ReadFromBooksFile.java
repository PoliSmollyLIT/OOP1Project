package bg.tu_varna.sit.libraryProject.read;

import org.w3c.dom.*;

import bg.tu_varna.sit.libraryProject.books.Author;
import bg.tu_varna.sit.libraryProject.books.Book;

import javax.xml.parsers.*;
import java.io.File;

public class ReadFromBooksFile extends ReadFromAllFiles implements ReadFromFileBooks {

    private File inputFile;
    private Book book;

    @Override
    public void readFile(File fileName) {
        try {
            inputFile = fileName;
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            NodeList nList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    book = new Book.Builder(eElement.getElementsByTagName("title").item(0).getTextContent(),
                     Author.AuthorBuilder(eElement.getElementsByTagName("author").item(0).getTextContent()).build(),
                     eElement.getElementsByTagName("isbn").item(0).getTextContent())
                     .build();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
