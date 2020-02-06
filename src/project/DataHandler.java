package project;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DataHandler {
    static String FILEPATH_IN = "Data.xml";
    private static Document doc;

    public static void read() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new File(FILEPATH_IN));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getElements(String tagName) {
        NodeList list = doc.getElementsByTagName(tagName);
        String[] s = new String[list.getLength()];
        for(int i = 0; i < list.getLength(); i++) {
            s[i] = list.item(i).getTextContent();
        }
        return s;
    }
    
    public static String[][] getFinishedElements(String type, boolean isTrue) {
        String[][] content;
        int counter = 0;
        if(type.equals("Game")) {
            String[] allNames = getElements("GName");
            String[] allPlats = getElements("GPlatform");
            String[] allStats = getElements("GStatus");
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    counter++;
                }
            }
            content = new String[counter][3];
            counter = 0;
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allStats[i];
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allStats[i];
                    counter++;
                }
            }
            return content;
        } else if(type.equals("Movie")) {
            String[] allNames = getElements("MName");
            String[] allPlats = getElements("Suggested");
            String[] allStats = getElements("MStatus");
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    counter++;
                }
            }
            content = new String[counter][3];
            counter = 0;
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allStats[i];
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allStats[i];
                    counter++;
                }
            }
            return content;
        }else if(type.contentEquals("Series")){
            String[] allNames = getElements("SName");
            String[] allPlats = getElements("SPlatform");
            String[] allSeasns = getElements("Seasons");
            String[] allStats = getElements("SStatus");
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    counter++;
                }
            }
            content = new String[counter][4];
            counter = 0;
            for(int i = 0; i < allNames.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allSeasns[i];
                    content[counter][3] = allStats[i];
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    content[counter][0] = allNames[i];
                    content[counter][1] = allPlats[i];
                    content[counter][2] = allSeasns[i];
                    content[counter][3] = allStats[i];
                    counter++;
                }
            }
            return content;
        } else {
            return null;
        }
    }
    
    public static void addGame(String name, String platform, String status) {
        Element data = doc.getDocumentElement();
        Element game = doc.createElement("Game");
        Element elementName = doc.createElement("GName");
        Element elementPlatform = doc.createElement("GPlatform");
        Element elementStatus = doc.createElement("GStatus");
        Text textName = doc.createTextNode(name);
        Text textPlatform = doc.createTextNode(platform);
        Text textStatus = doc.createTextNode(status);
        data.appendChild(game);
        game.appendChild(elementName);
        elementName.appendChild(textName);
        game.appendChild(elementPlatform);
        elementPlatform.appendChild(textPlatform);
        game.appendChild(elementStatus);
        elementStatus.appendChild(textStatus);
        
    }
    
    public static void addMovie(String name, String suggested, String status) {
        Element data = doc.getDocumentElement();
        Element movie = doc.createElement("Movie");
        Element elementName = doc.createElement("MName");
        Element elementSuggested = doc.createElement("Suggested");
        Element elementStatus = doc.createElement("MStatus");
        Text textName = doc.createTextNode(name);
        Text textPlatform = doc.createTextNode(suggested);
        Text textStatus = doc.createTextNode(status);
        data.appendChild(movie);
        movie.appendChild(elementName);
        elementName.appendChild(textName);
        movie.appendChild(elementSuggested);
        elementSuggested.appendChild(textPlatform);
        movie.appendChild(elementStatus);
        elementStatus.appendChild(textStatus);
        
    }
    
    public static void addSeries(String name, String platform, String seasons, String status) {
        Element data = doc.getDocumentElement();
        Element series = doc.createElement("Series");
        Element elementName = doc.createElement("SName");
        Element elementPlatform = doc.createElement("SPlatform");
        Element elementSeason = doc.createElement("Seasons");
        Element elementStatus = doc.createElement("SStatus");
        Text textName = doc.createTextNode(name);
        Text textPlatform = doc.createTextNode(platform);
        Text textSeason = doc.createTextNode(seasons);
        Text textStatus = doc.createTextNode(status);
        data.appendChild(series);
        series.appendChild(elementName);
        elementName.appendChild(textName);
        series.appendChild(elementPlatform);
        elementPlatform.appendChild(textPlatform);
        series.appendChild(elementSeason);
        elementSeason.appendChild(textSeason);
        series.appendChild(elementStatus);
        elementStatus.appendChild(textStatus);
        
    }
    
    public static void deleteEntry(String name, String type) {
        NodeList all;
        if (type.equals("Game")) {
            all = doc.getElementsByTagName("Game");
            for(int i = 0; i < all.getLength(); i++) {
                if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                    Element element = (Element) all.item(i);
                    element.getParentNode().removeChild(element);
                }
            }
        } else if (type.equals("Series")) {
            all = doc.getElementsByTagName("Series");
            for(int i = 0; i < all.getLength(); i++) {
                if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                    Element element = (Element) all.item(i);
                    element.getParentNode().removeChild(element);
                }
            }
        } else if (type.equals("Movie")) {
            all = doc.getElementsByTagName("Movie");
            for(int i = 0; i < all.getLength(); i++) {
                if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                    Element element = (Element) all.item(i);
                    element.getParentNode().removeChild(element);
                }
            }
        }
    }
    
    public static void editGame(String name, String platform, String status) {
        NodeList all = doc.getElementsByTagName("Game");
        for(int i = 0; i < all.getLength(); i++) {
            if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                all.item(i).getChildNodes().item(1).setTextContent(platform);
                all.item(i).getChildNodes().item(2).setTextContent(status);
            }
        }
    }
    
    public static void editMovie(String name, String suggested, String status) {
        NodeList all = doc.getElementsByTagName("Movie");
        for(int i = 0; i < all.getLength(); i++) {
            if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                all.item(i).getChildNodes().item(1).setTextContent(suggested);
                all.item(i).getChildNodes().item(2).setTextContent(status);
            }
        }
    }
    
    public static void editSeries(String name, String platform, String seasons, String status) {
        NodeList all = doc.getElementsByTagName("Series");
        for(int i = 0; i < all.getLength(); i++) {
            if (all.item(i).getChildNodes().item(0).getTextContent().equals(name)) {
                all.item(i).getChildNodes().item(1).setTextContent(platform);
                all.item(i).getChildNodes().item(2).setTextContent(seasons);
                all.item(i).getChildNodes().item(3).setTextContent(status);
            }
        }
    }
    
    public static void saveData() {
        try {
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("Data.xml"));
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "DataDTD.dtd");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.transform(domSource, streamResult);
            
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } finally {}
    }
    
    public static String getMovieSuggestions() {
        String[] suggested = getElements("Suggested");
        String[] mStatus = getElements("MStatus");
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < suggested.length; i++) {
            if(mStatus[i].equals("Finished")) {
                if(suggested[i].equals("Sascha")) {
                    p2++;
                } else if (suggested[i].equals("Saskia")) {
                    p1++;
                }
            }
        }
        return "Suggested Movies watched: Saskia - " + p1 + ", Sascha - " + p2;
    }
}
