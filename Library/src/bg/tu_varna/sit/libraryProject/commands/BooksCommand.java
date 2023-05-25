package bg.tu_varna.sit.libraryProject.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.books.Author;
import bg.tu_varna.sit.libraryProject.books.Book;
import bg.tu_varna.sit.libraryProject.books.BookListSingleton;
import bg.tu_varna.sit.libraryProject.books.Genre;
import bg.tu_varna.sit.libraryProject.books.Raiting;
import bg.tu_varna.sit.libraryProject.sort.SortBooksByAuthor;
import bg.tu_varna.sit.libraryProject.sort.SortBooksByRaiting;
import bg.tu_varna.sit.libraryProject.sort.SortBooksByTitle;
import bg.tu_varna.sit.libraryProject.sort.SortBooksByYear;
import bg.tu_varna.sit.libraryProject.write.WriteToFileBooks;

public class BooksCommand {
    private BookListSingleton bookList;
   
    public BooksCommand() {
        this.bookList = BookListSingleton.getInstance();
    }

    private ArrayList<Book> getBooksList(){
        return bookList.getAllBooks();
    }

    public void showAllBooks(){
        for(Book book : this.getBooksList()){
            System.out.println(book.toString());
        }
    }

    public void addBook() throws IOException{
             
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first and last name of Author: ");
        String authorName = reader.readLine().toString();
        Author author = new Author.AuthorBuilder(authorName).build();
        System.out.println("Enter title of book: ");
        String bookTitle = reader.readLine().toString();
        System.out.println("Enter ISBN of book: ");
        String bookISBN = reader.readLine().toString();
        System.out.println("Enter rainting of book: [5 stars = 5 | 4,5 stars = 4,5 | 4 stars = 4 | 3,5 stars = 3,5 | 3 stars = 3 | 2,5 stars = 2,5 | 2 stars = 2 | 1,5 stars = 1,5 | 1 star = 1 | SKIP = s]");
        String bookRait = reader.readLine().toString();
        System.out.println("Enter publishing year of book: [yyyy | SKIP = s]");
        String bookYear = reader.readLine().toString();
        System.out.println("Enter genre of book: [Romance = r | Thriller = t | Crime = c | Erotica = e | Sci-Fi = sf | Historic = h | Autobiography = a | SKIP = s]");
        String bookGen = reader.readLine().toString();
        System.out.println("Enter keywords of book: [SKIP = s]");
        String bookKeywords = reader.readLine().toString();
        System.out.println("Enter anotation of book: [SKIP = s]");
        String bookAnotation = reader.readLine().toString();     

        Book.Builder bookToAdd = new Book.Builder(bookTitle, author, bookISBN);
        
        Genre bookGenre = null;        
        if(bookGen.equals("s")){
            bookGenre = null;
        }else{
            if(bookGen.equals("r")){
                bookGenre = Genre.ROMANCE;
            }
            if(bookGen.equals("t")){
                bookGenre = Genre.THRILLER;
            }
            if(bookGen.equals("c")){
                bookGenre = Genre.CRIME;
            }
            if(bookGen.equals("e")){
                bookGenre = Genre.EROTICA;
            }
            if(bookGen.equals("sf")){
                bookGenre = Genre.SCI_FI;
            }
            if(bookGen.equals("h")){
                bookGenre = Genre.HISTORIC;
            }
            if(bookGen.equals("a")){
                bookGenre = Genre.AUTOBIOGRAPHY;
            }
            bookToAdd.withGenre(bookGenre);
        }

        Raiting bookRaiting = null;        
        if(bookRait.equals("s")){ 
            bookRaiting = null;
        }else{
            if(bookRait.equals("5")){
                bookRaiting = Raiting.FIVE_STARS;
            }
            if(bookRait.equals("4,5")){
                bookRaiting = Raiting.FOUR_STARS_AND_A_HALF;
            }
            if(bookRait.equals("4")){
                bookRaiting = Raiting.FOUR_STARS;
            }
            if(bookRait.equals("3,5")){
                bookRaiting = Raiting.THREE_STARS_AND_A_HALF;
            }
            if(bookRait.equals("3")){
                bookRaiting = Raiting.THREE_STARS;
            }
            if(bookRait.equals("2,5")){
                bookRaiting = Raiting.TWO_STARS_AND_A_HALF;
            }
            if(bookRait.equals("2")){
                bookRaiting = Raiting.TWO_STARS;
            }
            if(bookRait.equals("1,5")){
                bookRaiting = Raiting.STAR_AND_A_HALF;
            }
            if(bookRait.equals("1")){
                bookRaiting = Raiting.ONE_STAR;
            }
            bookToAdd.withRaiting(bookRaiting);
        }
        
        if(!bookYear.equals("s")){
            int bookPublishingYear = Integer.parseInt(bookYear);
            bookToAdd.withPublishingYear(bookPublishingYear);
        }

        if(!bookKeywords.equals("s")){
            bookToAdd.withKeywords(bookKeywords);
        }

        if(!bookAnotation.equals("s")){
            bookToAdd.withAnotation(bookAnotation);
        }

        //bookList.addBook(bookToAdd.build());
        Book b2 = bookToAdd.build();
        BookListSingleton.getInstance().addBook(b2);
        System.out.println(b2.toString());
       
    }

    public void removeBook() throws IOException, ParserConfigurationException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ISBN of book: ");
        String bookISBN = reader.readLine().toString();
        Book bookToRemove = new Book.Builder(null, null, bookISBN).build();
        if(!(BookListSingleton.getInstance().bookExist(bookToRemove))){
            throw new IOException("Book with this ISBN doesn't exist!");
        }else{
        BookListSingleton.getInstance().removeBook(bookToRemove);
        WriteToFileBooks fileWriter = new WriteToFileBooks();
        fileWriter.writeToFile(BookListSingleton.getInstance().getAllBooks());
    }
    }

    public void findBookInfo(String isbn){
        for(Book book : this.getBooksList()){
            if(book.getIsbn().equals(isbn)){
                System.out.println(book.toString());
            }
        }
    }

    public void findBook(String criteria, String value){
        if(criteria.equals("title")){
            if(findBookTitle(value) == null){
                System.out.println("There is no book with this title");
            }else{
                System.out.println(findBookTitle(value).toString());
            }            
        }else if(criteria.equals("author")){
            if(findBookAuthor(value) == null){
                System.out.println("There is no book with this author");
            }else{
                System.out.println(findBookAuthor(value).toString());
            }
        }else if(criteria.equals("tag")){ // keywords
            if(findBookTag(value) == null){
                System.out.println("There is no book with this tag");
            }else{
                System.out.println(findBookTag(value).toString());
            }
        }
    }

    private Book findBookTitle(String title){
        for(Book book : this.getBooksList()){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    private Book findBookAuthor(String author){
        for(Book book : this.getBooksList()){
            if(book.getAuthor().toString().equalsIgnoreCase(author)){
                return book;
            }
        }
        return null;
    }

    private Book findBookTag(String tag){
        for(Book book : this.getBooksList()){
            if(book.getKeywords().contains(tag)){
                return book;
            }
        }
        return null;
    }

    public void sortBooks(String criteria, boolean asc) throws Exception{
        if(criteria.equals("title")){
            if(asc == true){
                Collections.sort(this.getBooksList(), new SortBooksByTitle());
            }else{
                Collections.sort(getBooksList(), Collections.reverseOrder(new SortBooksByTitle()));
            }
        }else if(criteria.equals("author")){
            if(asc == true){
                Collections.sort(this.getBooksList(), new SortBooksByAuthor());
            }else{
                Collections.sort(getBooksList(), Collections.reverseOrder(new SortBooksByAuthor()));
            }
        }else if(criteria.equals("year")){
            if(asc == true){
                Collections.sort(this.getBooksList(), new SortBooksByYear());
            }else{
                Collections.sort(getBooksList(), Collections.reverseOrder(new SortBooksByYear()));
            }
        }else if(criteria.equals("raiting")){
            if(asc == true){
                Collections.sort(this.getBooksList(), new SortBooksByRaiting());
            }else{
                Collections.sort(getBooksList(), Collections.reverseOrder(new SortBooksByRaiting()));
            }
        }else{
            throw new Exception("ERROR 404: Something went wrong...");
        }
    }
}