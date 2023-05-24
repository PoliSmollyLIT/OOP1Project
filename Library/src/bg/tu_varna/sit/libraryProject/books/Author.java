package bg.tu_varna.sit.libraryProject.books;
public class Author {
    
    private String firstName;
    private String lastName;
    private Author(AuthorBuilder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    } 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
        Author other = (Author) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }

    public int compareTo(Author author) {
         if(this.equals(author))
            return 0;
        return this.getLastName().compareTo(author.getLastName());
    }


    public static class AuthorBuilder{
        private String fullName;
        private String[] name;

        public AuthorBuilder(String fullName) {
            this.fullName = fullName;
        }


        public Author build(){
           name = fullName.split(" ");
            return new Author(this);
        }

        protected String getFirstName(){
            return name[0];
        }

        protected String getLastName(){
            return name[1];
        }
    }
}