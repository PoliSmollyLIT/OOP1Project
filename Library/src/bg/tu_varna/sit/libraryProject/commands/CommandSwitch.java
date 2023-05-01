package bg.tu_varna.sit.libraryProject.commands;

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
                System.out.println(CommandsEnum.OPEN.getDescription());
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else if (realCommand.equals(CommandsEnum.LOGOUT.getCommand())) {
            System.out.println(CommandsEnum.LOGOUT.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_ALL.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            System.out.println(CommandsEnum.BOOKS_ALL.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_INFO.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            System.out.println(CommandsEnum.BOOKS_INFO.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_FIND.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            System.out.println(CommandsEnum.BOOKS_FIND.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_SORT.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            System.out.println(CommandsEnum.BOOKS_SORT.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_ADD.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }
            System.out.println(CommandsEnum.BOOKS_ADD.getDescription());

        } else if (realCommand.equals(CommandsEnum.BOOKS_REMOVE.getCommand())) {
            if(openedFile == ""){
                System.out.println("There is no opened file to save");
            }
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }
            System.out.println(CommandsEnum.BOOKS_REMOVE.getDescription());

        } else if (realCommand.equals(CommandsEnum.USER_ADD.getCommand())) {
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }
            System.out.println(CommandsEnum.USER_ADD.getDescription());

        } else if (realCommand.equals(CommandsEnum.USER_REMOVE.getCommand())) {
            if(activeUser.getAccessLevel() != AccessLevel.ADMIN){
                System.out.println("You do not have access to do this");
            }
            System.out.println(CommandsEnum.USER_REMOVE.getDescription());

        } else {
            System.exit(0);
        }

    }}