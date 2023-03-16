package bg.tu_varna.sit.libraryProject;

public class Book {

    private String title;
    private Author author;
    private Genre genre;
    private int publishingYear;
    private String anotation;
    private String keywords;
    private Raiting raiting;
    private String isbn;

    public Book(String title, Author author, Genre genre, int publishingYear, String anotation, String keywords,
            Raiting raiting, String isbn) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setPublishingYear(publishingYear);
        setAnotation(anotation);
        setKeywords(keywords);
        setRaiting(raiting);
        setIsbn(isbn);
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getAnotation() {
        return anotation;
    }

    public String getKeywords() {
        return keywords;
    }

    public Raiting getRaiting() {
        return raiting;
    }

    public String getIsbn() {
        return isbn;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(Author author) {
        this.author = author;
    }

    private void setGenre(Genre genre) {
        this.genre = genre;
    }

    private void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    private void setAnotation(String anotation) {
        this.anotation = anotation;
    }

    private void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    private void setRaiting(Raiting raiting) {
        this.raiting = raiting;
    }

    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}