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