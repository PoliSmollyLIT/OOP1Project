package bg.tu_varna.sit.libraryProject;

public abstract class WriteToFile {

    private String filename;
    
    public WriteToFile(String filename) {
        this.filename = filename;
    }


    public abstract void writeToFile();

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }


    public String getFilename() {
        return filename;
    }
    
}
