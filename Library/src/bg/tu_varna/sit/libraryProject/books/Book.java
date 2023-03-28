package bg.tu_varna.sit.libraryProject.books;

public class Book {

    public static class Builder {
        private String title;
        private Author author;
        private Genre genre;
        private int publishingYear;
        private String anotation;
        private String keywords;
        private Raiting raiting;
        private String isbn;
        

        public Builder(String title, Author author, String isbn) {
            setTitle(title);
            setAuthor(author);
            setIsbn(isbn);
        }

        public Builder withPublishingYear(int publishingYear) {
            setPublishingYear(publishingYear);
            return this;
        }

        public Builder withGenre(Genre genre) {
            setGenre(genre);
            return this;
        }

        public Builder withAnotation(String anotation) {
            setAnotation(anotation);
            return this;
        }

        public Builder withKeywords(String keywords) {
            setKeywords(keywords);
            return this;
        }

        public Builder withRaiting(Raiting raiting) {
            setRaiting(raiting);
            return this;
        }

        public Book build() {
            return new Book();
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

        protected String getTitle() {
            return title;
        }

        protected Author getAuthor() {
            return author;
        }

        protected Genre getGenre() {
            return genre;
        }

        protected int getPublishingYear() {
            return publishingYear;
        }

        protected String getAnotation() {
            return anotation;
        }

        protected String getKeywords() {
            return keywords;
        }

        protected Raiting getRaiting() {
            return raiting;
        }

        protected String getIsbn() {
            return isbn;
        }
    }

    private Book() {
    }

    public String getTitle() {
        return getTitle();
    }

    public Author getAuthor() {
        return getAuthor();
    }

    public Genre getGenre() {
        return getGenre();
    }

    public int getPublishingYear() {
        return getPublishingYear();
    }

    public String getAnotation() {
        return getAnotation();
    }

    public String getKeywords() {
        return getKeywords();
    }

    public Raiting getRaiting() {
        return getRaiting();
    }

    public String getIsbn() {
        return getIsbn();
    }
    
}