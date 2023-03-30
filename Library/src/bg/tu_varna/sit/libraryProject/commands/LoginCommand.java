package bg.tu_varna.sit.libraryProject.commands;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.users.AccessLevel;
import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.write.WriteToFileUsers;

public class LoginCommand implements Command{
    private User user;
    private WriteToFileUsers fileWriter;

    @Override
    public void runCommand() {
        // add-logic
        
        try {
            fileWriter.writeToFile(user);
        } catch (ParserConfigurationException e) {
             e.printStackTrace();
        }
    }

    @Override
    public void setParameters(String[] args) {
        user = new User();
        user.setUserInfo(args[0], args[1], AccessLevel.USER);
    }
    
    
}