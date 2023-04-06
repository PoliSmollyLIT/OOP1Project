package bg.tu_varna.sit.libraryProject.write;

import javax.xml.parsers.ParserConfigurationException;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import bg.tu_varna.sit.libraryProject.books.Book;

public class WriteToFileBooks extends WriteToAllFiles implements WriteToBooksFile {

    public WriteToFileBooks() {
    }

    @Override
    public void writeToFile(Book bookToAdd) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("booklist");
        doc.appendChild(rootElement);

        Element book = doc.createElement("book");
        Element bookTitle = doc.createElement("title");
        Text bookTitleTxt = doc.createTextNode(bookToAdd.getTitle());
        bookTitle.appendChild(bookTitleTxt);
        Element bookAuthor = doc.createElement("author");
        Text bookAuthorTxt = doc.createTextNode(bookToAdd.getAuthor().toString());
        bookAuthor.appendChild(bookAuthorTxt);
        Element bookIsbn = doc.createElement("isbn");
        Text bookIsbnTxt = doc.createTextNode(bookToAdd.getIsbn());
        bookIsbn.appendChild(bookIsbnTxt);
        book.appendChild(bookTitle);
        book.appendChild(bookAuthor);
        book.appendChild(bookIsbn);
        if (bookToAdd.getPublishingYear() != 0) {
            Element bookYear = doc.createElement("publishinYear");
            Text bookYearTxt = doc.createTextNode(String.valueOf(bookToAdd.getPublishingYear()));
            bookYear.appendChild(bookYearTxt);
            book.appendChild(bookYear);
        }
        if (bookToAdd.getGenre() != null) {
            Element bookGenre = doc.createElement("genre");
            Text bookGenreTxt = doc.createTextNode(bookToAdd.getGenre().toString());
            bookGenre.appendChild(bookGenreTxt);
            book.appendChild(bookGenre);
        }
        if (bookToAdd.getAnotation() != null) {
            Element bookAnotation = doc.createElement("anotation");
            Text bookAnotationTxt = doc.createTextNode(bookToAdd.getAnotation());
            bookAnotation.appendChild(bookAnotationTxt);
            book.appendChild(bookAnotation);
        }
        if (bookToAdd.getKeywords() != null) {
            Element bookKeywords = doc.createElement("keywords");
            Text bookKeywordsTxt = doc.createTextNode(bookToAdd.getKeywords());
            bookKeywords.appendChild(bookKeywordsTxt);
            book.appendChild(bookKeywords);
        }
        if (bookToAdd.getRaiting() != null) {
            Element bookRaiting = doc.createElement("raiting");
            Text bookRaitingTxt = doc.createTextNode(bookToAdd.getRaiting().toString());
            bookRaiting.appendChild(bookRaitingTxt);
            book.appendChild(bookRaiting);
        }

        rootElement.appendChild(book);

        // write dom document to a file
        try (FileOutputStream output = new FileOutputStream(filename)) {
            super.writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}