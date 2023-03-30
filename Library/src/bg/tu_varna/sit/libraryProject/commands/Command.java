package bg.tu_varna.sit.libraryProject.commands;

public interface Command {
    void runCommand();
    void setParameters(String[] args);    
}