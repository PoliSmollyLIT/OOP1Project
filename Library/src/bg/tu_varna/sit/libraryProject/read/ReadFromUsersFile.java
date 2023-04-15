package bg.tu_varna.sit.libraryProject.read;

import org.w3c.dom.*;

import bg.tu_varna.sit.libraryProject.users.AccessLevel;
import bg.tu_varna.sit.libraryProject.users.User;
import bg.tu_varna.sit.libraryProject.users.UsersListSingleton;

import javax.xml.parsers.*;
import java.io.File;

public class ReadFromUsersFile extends ReadFromAllFiles implements ReadFromFileUsers {
    private File inputFile;
    private User user;
    private UsersListSingleton usersList = UsersListSingleton.getInstance();

    @Override
    public void readFile() {
        try {
            inputFile = fileName;
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();  
            NodeList nList = doc.getElementsByTagName("user");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    user = new User();
                    user.setUserInfo(eElement.getElementsByTagName("name").item(0).getTextContent(),
                    eElement.getElementsByTagName("password").item(0).getTextContent(), 
                    AccessLevel.valueOf(eElement.getElementsByTagName("access").item(0).getTextContent()));
                    usersList.addUser(user);
                    System.out.println("Successufully opened users.xml");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getFileName(){
        return fileName.getName();
    }
}
