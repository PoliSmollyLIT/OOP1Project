package bg.tu_varna.sit.libraryProject.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.users.UsersListSingleton;

public class LoginCommand{
    
    public void login() throws Exception{
        User userToLog = new User();
        String username = writeUserName();
        String password = writePassword();
        userToLog.setUserLoginInfo(username, password);
        if(!(UsersListSingleton.getInstance().userExist(userToLog))){
            if(!(UsersListSingleton.getInstance().checkIfCorrectCredentials(userToLog))){
                System.out.println("Wrong username or password!");
            }            
        }else{
            if(UsersListSingleton.getInstance().checkIfUserIsActive(userToLog)){
                System.out.println("You are already logged!");
            }else{
                UsersListSingleton.getInstance().setActiveUser(userToLog);
                System.out.println("Welcome, " + username + "!");
            }
        }
    }

    private String writeUserName() throws IOException{
        System.out.println("Enter username: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().toString();
    }

    private String writePassword() throws IOException{
        System.out.println("Enter password: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().toString();
    }
}