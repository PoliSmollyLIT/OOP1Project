package bg.tu_varna.sit.libraryProject.commands;

import bg.tu_varna.sit.libraryProject.books.BookListSingleton;
import bg.tu_varna.sit.libraryProject.read.ReadFromBooksFile;
import bg.tu_varna.sit.libraryProject.read.ReadFromUsersFile;
import bg.tu_varna.sit.libraryProject.users.AccessLevel;
import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.users.UsersListSingleton;
import bg.tu_varna.sit.libraryProject.write.WriteToFileBooks;
import bg.tu_varna.sit.libraryProject.write.WriteToFileUsers;

public class CommandSwitch {
    private static String openedFile = "";

    public CommandSwitch() {
    }

    public static void runCommand(String enteredCommand) {
        User activeUser = UsersListSingleton.getInstance().getActiveUser();
        
        String realCommand, params = "";
        if(!enteredCommand.contains(" ")){
            realCommand = enteredCommand;    
        }else{
            realCommand = enteredCommand.split(" ")[0];
            params = enteredCommand.split(" ")[1];
        }
        try{
        if (realCommand.equals(CommandsEnum.OPEN.getCommand())) {
            if(params.equals("books.xml")){
                ReadFromBooksFile readFile = new ReadFromBooksFile();
                readFile.readFile();
                openedFile = readFile.getFileName();
            }
            else if(params.equals("users.xml")){
                ReadFromUsersFile readFile = new ReadFromUsersFile();
                readFile.readFile();
                openedFile = readFile.getFileName();   
            }else{
                System.out.println("Failed opening the file");
            }           

        } else if (realCommand.equals(CommandsEnum.CLOSE.getCommand())) {
            System.out.println(CommandsEnum.CLOSE.getDescription());
            openedFile = "";

        } else if (realCommand.equals(CommandsEnum.SAVE.getCommand())) {
            if(openedFile.equals("")){
                throw new Exception("There is no opened file to save");
            }
            if(openedFile.equals("books.xml")){
                WriteToFileBooks writeFile = new WriteToFileBooks();
                    writeFile.writeToFile(BookListSingleton.getInstance().getAllBooks());
                    System.out.println("Saved successfully");
            }
            else if(openedFile.equals("users.xml")){
                WriteToFileUsers writeFile = new WriteToFileUsers();
                    writeFile.writeToFile(UsersListSingleton.getInstance().getAllUsers());
                    System.out.println("Saved successfully");
            }
            else{
                    System.out.println("Saved unsuccessfully");
                }
            
        } else if (realCommand.equals(CommandsEnum.SAVEAS.getCommand())) {
            if(openedFile.equals("")){
                throw new Exception("There is no opened file to save");
            }
            
            else if(openedFile.equals("books.xml")){
                WriteToFileBooks writeFile = new WriteToFileBooks();
                writeFile.setNewFileName(params);
                    writeFile.writeToFile(BookListSingleton.getInstance().getAllBooks());
                    System.out.println("Saved successfully");
               }
            else if(openedFile.equals("users.xml")){
                WriteToFileUsers writeFile = new WriteToFileUsers();
                writeFile.setNewFileName(params);
                    writeFile.writeToFile(UsersListSingleton.getInstance().getAllUsers());
                    System.out.println("Saved successfully");
               }
            else{
                    System.out.println("Saved unsuccessfully");
                }

        } else if (realCommand.equals(CommandsEnum.HELP.getCommand())) {
            for (CommandsEnum command : CommandsEnum.values()) {
                System.out.printf("%-15s %-40s \n", command.getCommand(), command.getDescription());    // %-10s left-aligned space ot 10 pos for text
            }

        } else if (realCommand.equals(CommandsEnum.LOGIN.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("books.xml")){
                throw new Exception("Cannot log in when you work on books file!");
            }else{
                LoginCommand login = new LoginCommand();
                login.login(); 
            }
            
        } else if (realCommand.equals(CommandsEnum.LOGOUT.getCommand())) {
            LoginCommand login = new LoginCommand();
            login.logout();
            System.out.println("You have been successfully logged out!");

        } else if (realCommand.equals(CommandsEnum.BOOKS_ALL.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("users.xml")){
                throw new Exception("The opened file is not right");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
            BooksCommand booksCommands = new BooksCommand();
            booksCommands.showAllBooks();
    
        } else if (realCommand.equals(CommandsEnum.BOOKS_INFO.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("users.xml")){
                throw new Exception("The opened file is not right");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
           else{
                BooksCommand booksCommands = new BooksCommand();
                booksCommands.findBookInfo(params);
            }
            

        } else if (realCommand.equals(CommandsEnum.BOOKS_FIND.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("users.xml")){
                throw new Exception("The opened file is not right");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
           else{
                BooksCommand booksCommands = new BooksCommand();
                String criteria = params;
                String value = enteredCommand.substring(enteredCommand.indexOf(" ", enteredCommand.indexOf(criteria)));
                value = value.trim();
                booksCommands.findBook(criteria, value);       
            }
            

        } else if (realCommand.equals(CommandsEnum.BOOKS_SORT.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("users.xml")){
                throw new Exception("The opened file is not right");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }else{               
                BooksCommand booksCommand = new BooksCommand();
                boolean asc = true;
                if(enteredCommand.contains("desc")){
                    asc = false;
                }
                if(!enteredCommand.contains("title") && !enteredCommand.contains("author") && !enteredCommand.contains("year") && !enteredCommand.contains("raiting")){
                    System.out.println("Invalid criteria!");
                }else{
                   
                    booksCommand.sortBooks(params, asc);
                    booksCommand.showAllBooks();
                    }
            }
        } else if (realCommand.equals(CommandsEnum.BOOKS_ADD.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("users.xml")){
                throw new Exception("Cannot add book when you work on users file!");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                throw new Exception("You do not have access to do this");
            }else{
                BooksCommand booksCommands = new BooksCommand();
               
                    booksCommands.addBook();
                    System.out.println("Book added sucssessfully!");
                            
            }            

        } else if (realCommand.equals(CommandsEnum.BOOKS_REMOVE.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                throw new Exception("Cannot remove book when you work on users file!");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                throw new Exception("You do not have access to do this");
            }else{
                BooksCommand booksCommands = new BooksCommand();
                    booksCommands.removeBook();
                    System.out.println("Book removed sucssessfully!");              
            }        

        } else if (realCommand.equals(CommandsEnum.USER_ADD.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("books.xml")){
                throw new Exception("Cannot add user when you work on books file!");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                throw new Exception("You do not have access to do this");
            }else{
                UsersCommand usersCommands = new UsersCommand();
                    usersCommands.addUser();
                    System.out.println("User added sucssessfully!");           
            }

        } else if (realCommand.equals(CommandsEnum.USER_REMOVE.getCommand())) {
            if(openedFile.equals("") || openedFile.equals("books.xml")){
                throw new Exception("Cannot remove user when you work on books file!");
            }
            if(activeUser == null){
                throw new Exception("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                throw new Exception("You do not have access to do this");
            }else{
                UsersCommand usersCommands = new UsersCommand();
                   usersCommands.removeUser();
                    System.out.println("User removed sucssessfully!");          
            }
        } else if(realCommand.equals(CommandsEnum.EXIT.getCommand())){
            System.exit(0);
        }else{
            System.out.println("Invalid command! Try again");
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }

    }}