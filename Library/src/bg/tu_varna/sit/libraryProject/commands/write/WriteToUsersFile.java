package bg.tu_varna.sit.libraryProject.commands.write;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import bg.tu_varna.sit.libraryProject.users.User;

public interface WriteToUsersFile extends WriteToFile{
    String filename = "src\\bg\\tu_varna\\sit\\libraryProject\\xmls\\users.xml";
    void writeToFile(ArrayList<User> users) throws ParserConfigurationException;
    
}