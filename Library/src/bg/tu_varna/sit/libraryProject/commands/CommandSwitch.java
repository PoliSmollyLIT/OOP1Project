package bg.tu_varna.sit.libraryProject.commands;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

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
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            if(openedFile.equals("books.xml")){
                WriteToFileBooks writeFile = new WriteToFileBooks();
                try {
                    writeFile.writeToFile(BookListSingleton.getInstance().getAllBooks());
                    System.out.println("Saved successfully");
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
            else if(openedFile.equals("users.xml")){
                WriteToFileUsers writeFile = new WriteToFileUsers();
                try {
                    writeFile.writeToFile(UsersListSingleton.getInstance().getAllUsers());
                    System.out.println("Saved successfully");
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
            else{
                    System.out.println("Saved unsuccessfully");
                }
            
        } else if (realCommand.equals(CommandsEnum.SAVEAS.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            
            else if(openedFile.equals("books.xml")){
                WriteToFileBooks writeFile = new WriteToFileBooks();
                writeFile.setNewFileName(params);
                try {
                    writeFile.writeToFile(BookListSingleton.getInstance().getAllBooks());
                    System.out.println("Saved successfully");
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
            else if(openedFile.equals("users.xml")){
                WriteToFileUsers writeFile = new WriteToFileUsers();
                writeFile.setNewFileName(params);
                try {
                    writeFile.writeToFile(UsersListSingleton.getInstance().getAllUsers());
                    System.out.println("Saved successfully");
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
            else{
                    System.out.println("Saved unsuccessfully");
                }

        } else if (realCommand.equals(CommandsEnum.HELP.getCommand())) {
            for (CommandsEnum command : CommandsEnum.values()) {
                System.out.printf("%-15s %-40s \n", command.getCommand(), command.getDescription());    // %-10s left-aligned space ot 10 pos for text
            }

        } else if (realCommand.equals(CommandsEnum.LOGIN.getCommand())) {
            LoginCommand login = new LoginCommand();
            try {
                login.login();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (realCommand.equals(CommandsEnum.LOGOUT.getCommand())) {
            LoginCommand login = new LoginCommand();
            login.logout();
            System.out.println("You have been sucssessfully logged out!");

        } else if (realCommand.equals(CommandsEnum.BOOKS_ALL.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }
            BooksCommand booksCommands = new BooksCommand();
            booksCommands.showAllBooks();
            System.out.println(CommandsEnum.BOOKS_ALL.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_INFO.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }else{
                BooksCommand booksCommands = new BooksCommand();
                booksCommands.findBookInfo(params);
                System.out.println(CommandsEnum.BOOKS_INFO.getDescription());
            }
            

        } else if (realCommand.equals(CommandsEnum.BOOKS_FIND.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }else{
                BooksCommand booksCommands = new BooksCommand();
                String criteria = params;
                String value = enteredCommand.substring(enteredCommand.indexOf(" ", enteredCommand.indexOf(criteria)));
                value = value.trim();
                booksCommands.findBook(criteria, value);
            }
            

        } else if (realCommand.equals(CommandsEnum.BOOKS_SORT.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }else{
                BooksCommand booksCommand = new BooksCommand();
                boolean asc = true;
                if(enteredCommand.contains("desc")){
                    asc = false;
                }
                if(!enteredCommand.contains("title") && !enteredCommand.contains("author") && !enteredCommand.contains("year") && !enteredCommand.contains("raiting")){
                    System.out.println("Invalid criteria!");
                }else{
                    try{
                    booksCommand.sortBooks(params, asc);
                    booksCommand.showAllBooks();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }                
            }
            System.out.println(CommandsEnum.BOOKS_FIND.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_ADD.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }else{
                BooksCommand booksCommands = new BooksCommand();
                try {
                    booksCommands.addBook();
                    System.out.println("Book added sucssessfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }                
            }            

        } else if (realCommand.equals(CommandsEnum.BOOKS_REMOVE.getCommand())) {
            if(openedFile == "" || openedFile == "users.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }else{
                BooksCommand booksCommands = new BooksCommand();
                try {
                    booksCommands.removeBook();
                    System.out.println("Book added sucssessfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                   e.printStackTrace();
                }                
            }        

        } else if (realCommand.equals(CommandsEnum.USER_ADD.getCommand())) {
            if(openedFile == "" || openedFile == "books.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }else{
                UsersCommand usersCommands = new UsersCommand();
                try {
                    usersCommands.addUser();
                    System.out.println("User added sucssessfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }                
            }

        } else if (realCommand.equals(CommandsEnum.USER_REMOVE.getCommand())) {
            if(openedFile == "" || openedFile == "books.xml"){
                System.out.println("There is no opened file to save");
            }
            if(activeUser == null){
                System.out.println("There is no active user!");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }else{
                UsersCommand usersCommands = new UsersCommand();
                try {
                    usersCommands.removeUser();
                    System.out.println("User removed sucssessfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }                
            }
        } else {
            System.exit(0);
        }

    }}