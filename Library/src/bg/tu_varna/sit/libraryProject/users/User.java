package bg.tu_varna.sit.libraryProject.users;

public class User {

    private String userName;
    private String password;
    private AccessLevel accessLevel;

    public User() {
    }

    public void setUserLoginInfo(String userName, String password){
        setUserUserName(userName);
        setUserPassword(password);
    }

    public void setUserInfo(String userName, String password, AccessLevel accessLevel) {
        setUserUserName(userName);
        setUserPassword(password);
        this.accessLevel = accessLevel;
    }

    private void setUserUserName(String userName) {
        this.userName = userName;
    }

    private void setUserPassword(String password) {
        this.password = password;

    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    @Override
    public String toString() {
        return "User: " + userName + "\npassword: " + password + "\naccessLevel: " + accessLevel + "\n";
    }

}