package bg.tu_varna.sit.libraryProject.users;

import java.util.ArrayList;

public class UsersListSingleton {
    private static UsersListSingleton usersListSingleton;
    private static ArrayList<User> users;
    private User activeUser;
    
    private UsersListSingleton(){
        users = new ArrayList<>();
    }
    
    public static UsersListSingleton getInstance(){
        if(usersListSingleton == null){
            usersListSingleton = new UsersListSingleton();
        }
        return usersListSingleton;
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public void addUser(User userToAdd){
        users.add(userToAdd);
    }

    public User getActiveUser(){
        return this.activeUser;
    }
    public void setActiveUser(User user){
        int activeUserIndex = users.indexOf(user);
        activeUser = users.get(activeUserIndex);
    }
}