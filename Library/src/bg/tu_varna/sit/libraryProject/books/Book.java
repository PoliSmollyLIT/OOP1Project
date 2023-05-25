package bg.tu_varna.sit.libraryProject.books;

public class Book implements Comparable<Book>{

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
            return new Book(this);
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
            return this.isbn;
        }
    }

    private String title;
        private Author author;
        private Genre genre;
        private int publishingYear;
        private String anotation;
        private String keywords;
        private Raiting raiting;
        private String isbn;

    private Book(Builder bookBuilder) {
        this.title = bookBuilder.getTitle();
        this.isbn = bookBuilder.getIsbn();
        this.author = bookBuilder.getAuthor();
        this.genre = bookBuilder.getGenre();
        this.publishingYear = bookBuilder.getPublishingYear();
        this.anotation = bookBuilder.getAnotation();
        this.keywords = bookBuilder.getKeywords();
        this.raiting = bookBuilder.getRaiting();
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
        return this.isbn;
    }

    @Override
    public String toString() {
        StringBuilder bookInfo = new StringBuilder();
        bookInfo.append("Book " + this.getIsbn() + " - " + this.getTitle() + ", " + this.getAuthor().toString());
        if(getRaiting() != null){
            bookInfo.append("\n" + this.getRaiting().getRaiting());
        }
        if(getGenre() != null){
            bookInfo.append("\n" + this.getGenre());
        }
        if(getPublishingYear() != 0){
            bookInfo.append("\nPublishing year: " + this.getPublishingYear());
        }
        if(getKeywords() != null){
            bookInfo.append("\nKeywords: " + this.getKeywords());
        }
        if(getAnotation() != null){
            bookInfo.append("\n" + this.getAnotation());
        }
        return bookInfo.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + publishingYear;
        result = prime * result + ((anotation == null) ? 0 : anotation.hashCode());
        result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
        result = prime * result + ((raiting == null) ? 0 : raiting.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (genre != other.genre)
            return false;
        if (publishingYear != other.publishingYear)
            return false;
        if (anotation == null) {
            if (other.anotation != null)
                return false;
        } else if (!anotation.equals(other.anotation))
            return false;
        if (keywords == null) {
            if (other.keywords != null)
                return false;
        } else if (!keywords.equals(other.keywords))
            return false;
        if (raiting != other.raiting)
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    @Override
    public int compareTo(Book o) {
        return this.getIsbn().compareTo(o.getIsbn());
    }
   
    
}