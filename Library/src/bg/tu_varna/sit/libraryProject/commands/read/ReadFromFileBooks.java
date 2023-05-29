package bg.tu_varna.sit.libraryProject.commands.read;

import java.io.File;

public interface ReadFromFileBooks extends ReadFromFile{
    File fileName = new File("src\\bg\\tu_varna\\sit\\libraryProject\\xmls\\books.xml");
    
}