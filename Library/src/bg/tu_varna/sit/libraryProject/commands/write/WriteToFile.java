package bg.tu_varna.sit.libraryProject.commands.write;

import java.io.OutputStream;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

public interface WriteToFile {
    void writeXml(Document doc, OutputStream output) throws TransformerException;
    
}