
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class WriteToFileUsers extends WriteToFile{
    

    public WriteToFileUsers() {
        super("users.xml");
    }

   // @Override
    public void writeToFile(User usertoAdd) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("userlist");
        doc.appendChild(rootElement);

        Element user = doc.createElement("user");
        Element userName = doc.createElement("name");
        Text userNameTxt = doc.createTextNode(usertoAdd.getUserName());
        userName.appendChild(userNameTxt);
        Element userPass = doc.createElement("password");
        Text userPassTxt = doc.createTextNode(usertoAdd.getPassword());
        userPass.appendChild(userPassTxt);
        user.appendChild(userName);
        user.appendChild(userPass);
        rootElement.appendChild(user);

        
        // write dom document to a file
        // try (FileOutputStream output =
        //              new FileOutputStream("c:\\test\\staff-dom.xml")) {
        //     writeXml(doc, output);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

    }
    
}