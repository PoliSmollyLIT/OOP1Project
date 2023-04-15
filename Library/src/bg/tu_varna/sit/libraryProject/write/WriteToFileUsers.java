package bg.tu_varna.sit.libraryProject.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import bg.tu_varna.sit.libraryProject.users.User;

public class WriteToFileUsers extends WriteToAllFiles implements WriteToUsersFile {

    public WriteToFileUsers() {
    }

    @Override
    public void writeToFile(ArrayList<User> users) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("userlist");
        doc.appendChild(rootElement);
        for (User userToAdd : users) {
            Element user = doc.createElement("user");
            Element userName = doc.createElement("name");
            Text userNameTxt = doc.createTextNode(userToAdd.getUserName());
            userName.appendChild(userNameTxt);
            Element userPass = doc.createElement("password");
            Text userPassTxt = doc.createTextNode(userToAdd.getPassword());
            userPass.appendChild(userPassTxt);
            Element userAccess = doc.createElement("access");
            Text userAccessTxt = doc.createTextNode(userToAdd.getAccessLevel().toString());
            userAccess.appendChild(userAccessTxt);
            user.appendChild(userName);
            user.appendChild(userPass);
            user.appendChild(userAccess);
            rootElement.appendChild(user);
        }

        // write dom document to a file
        try (FileOutputStream output = new FileOutputStream(filename)) {
            super.writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}