package bg.tu_varna.sit.libraryProject.commands;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.users.AccessLevel;
import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.users.UsersListSingleton;
import bg.tu_varna.sit.libraryProject.write.WriteToFileUsers;

public class UsersCommand {
    private UsersListSingleton users;

    public UsersCommand() {
    this.users = UsersListSingleton.getInstance();
    }

    private ArrayList<User> getUsers(){
        return users.getAllUsers();
    }
    
    public void showAllUsers(){
        for(User user : this.getUsers()){
            System.out.println(user.toString());
        }
    }

    public static String writeUserName() throws IOException{
        System.out.print("Enter username: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().toString();
    }

    public static String writePassword() throws IOException{
        System.out.print("Enter password: ");
        StringBuilder pass = new StringBuilder();
        Console console = System.console();
        char[] password = console.readPassword();
        for(int i=0; i<password.length; i++){
            System.out.print("*");
            pass.append(password[i]);
        }
        System.out.print("\n");
        return pass.toString();
    }

    private static AccessLevel writeAccessLevel() throws IOException{
        System.out.print("Enter access level: [a = admin | u = user]: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toString();
        AccessLevel accLevel = null;
        if(input.equals("a")){
            accLevel = AccessLevel.ADMIN;
        }
        else if(input.equals("u")){
            accLevel = AccessLevel.USER;
        }
        else{
            throw new IOException("You entered invalid value of access level!");
        }
        return accLevel;
    }

    public void addUser() throws IOException, ParserConfigurationException{
        User userToAdd = new User();
        String username = writeUserName();
        String password = writePassword();
        AccessLevel accLevel = writeAccessLevel();
        userToAdd.setUserInfo(username, password, accLevel);
        if(UsersListSingleton.getInstance().userExist(userToAdd)){
                System.out.println("This user already exist!");
        }else{
            UsersListSingleton.getInstance().addUser(userToAdd);
            WriteToFileUsers fileWriter = new WriteToFileUsers();
            fileWriter.writeToFile(UsersListSingleton.getInstance().getAllUsers());
        }
    }

    public void removeUser() throws IOException, ParserConfigurationException{
        User userToRemove = new User();
        String username = writeUserName();
        String password = "";
        userToRemove.setUserLoginInfo(username, password);
        if(!(UsersListSingleton.getInstance().userExist(userToRemove))){
            throw new IOException("User with this username doesn't exist!");
        }else{
            UsersListSingleton.getInstance().removeUser(userToRemove);
            WriteToFileUsers fileWriter = new WriteToFileUsers();
            fileWriter.writeToFile(UsersListSingleton.getInstance().getAllUsers());
        }
        
    }
}
