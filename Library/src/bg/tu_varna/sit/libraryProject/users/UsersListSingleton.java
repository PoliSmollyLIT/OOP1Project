package bg.tu_varna.sit.libraryProject.users;

import java.util.ArrayList;

public class UsersListSingleton {
    private static UsersListSingleton usersListSingleton;
    private static ArrayList<User> users;
    private User activeUser = new User();

    private UsersListSingleton() {
        users = new ArrayList<>();
    }

    public static UsersListSingleton getInstance() {
        if (usersListSingleton == null) {
            usersListSingleton = new UsersListSingleton();
        }
        return usersListSingleton;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public void addUser(User userToAdd) {
        users.add(userToAdd);
    }

    public User getActiveUser() {
        return this.activeUser;
    }

    public void setActiveUser(User user) {
        int activeUserIndex = 0; //users.indexOf(user);
        int i=0;
        for (User user2 : users) {
            if(user.getUserName().equals(user2.getUserName()) && user.getPassword().equals(user2.getPassword())){
                activeUserIndex = i;
            }
            i++;
        }
        activeUser = users.get(activeUserIndex);
    }

    public boolean userExist(User user) {
        for (User searchUser : users) {
            if (searchUser.getUserName().equals(user.getUserName()) || searchUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfCorrectCredentials(User user){
        for (User searchUser : users) {
            if (searchUser.getUserName().equals(user.getUserName()) && searchUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfUserIsActive(User user) {
        if (user.getUserName().equals(activeUser.getUserName()) && user.getPassword().equals(activeUser.getPassword())) {
            return true;
        }
        return false;
    }
}