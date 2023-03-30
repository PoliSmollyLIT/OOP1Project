package bg.tu_varna.sit.libraryProject.commands;

public enum CommandsEnum {
    OPEN("open", "Opens a file and reads all of its content"),
    CLOSE("close", "Closes the opened file"),
    SAVE("save", "Saves changes to the previously opened file"),
    SAVEAS("saveas", "Saves changes to chosen file"),
    HELP("help", "Shows all commands and their descriptions"),
    EXIT("exit", "Exits the program"),
    LOGIN("login", "Logs into the program with certain username and password"),
    LOGOUT("logout", "Logs out of the user"),
    BOOKS_ALL("booksall", "Shows all the info of entered books"),
    BOOKS_INFO("booksinfo", "Shows all the info of book with entered <isbn>"),
    BOOKS_FIND("booksfind", "Searches for book with specific <title/tag/author> that is <certaint_string>"),
    BOOKS_SORT("bookssort", "Sorts all the books [asc] - by default [desc] - optional parameter"),
    BOOKS_ADD("booksadd", "Adds book to the library"),
    BOOKS_REMOVE("booksremove", "Removes book"),
    USER_ADD("useradd", "Adds new user"),
    USER_REMOVE("userremove", "Removes a user with <username>");
    
    private final String writtenCommand;
    private final String description;

    CommandsEnum( String writtenCommand, String description){
            this.writtenCommand = writtenCommand;
            this.description = description;
    }

    public String getCommand(){
        return this.writtenCommand;
    }

    public String getDescription(){
        return this.description;
    }
}