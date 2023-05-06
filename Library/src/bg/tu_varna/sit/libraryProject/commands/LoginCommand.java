package bg.tu_varna.sit.libraryProject.commands;


import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.users.UsersListSingleton;

public class LoginCommand{
    
    public void login() throws Exception{
        User userToLog = new User();
        String username = UsersCommand.writeUserName();
        String password = UsersCommand.writePassword();
        userToLog.setUserLoginInfo(username, password);
        if(!(UsersListSingleton.getInstance().userExist(userToLog))){
                System.out.println("Wrong username or password!");
        
        }else{
            if(!(UsersListSingleton.getInstance().checkIfCorrectCredentials(userToLog))){
                System.out.println("Wrong username or password!");
            } 
            else{
                if(UsersListSingleton.getInstance().checkIfUserIsActive(userToLog)){
                    System.out.println("You are already logged!");
                }else{
                    UsersListSingleton.getInstance().setActiveUser(userToLog);
                    System.out.println("Welcome, " + username + "!");
                }
            }                
        }
    }

    public void logout(){
        UsersListSingleton.getInstance().setActiveUser(null);
    }
}
