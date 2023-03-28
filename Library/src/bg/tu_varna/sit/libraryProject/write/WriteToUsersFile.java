package bg.tu_varna.sit.libraryProject.write;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.users.User;

public interface WriteToUsersFile extends WriteToFile{
    String filename = "users.xml";
    void writeToFile(User userToAdd) throws ParserConfigurationException;
    
}