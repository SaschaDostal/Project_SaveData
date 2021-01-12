package project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.stream.Stream;

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
    private static Document paths;
    private static Document doc;
    
    public static void readPath() {
        DocumentBuilderFactory factoryPath = DocumentBuilderFactory.newInstance();
        factoryPath.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder builder = factoryPath.newDocumentBuilder();
            paths = builder.parse(new File("Paths.xml"));
            FILEPATH_IN = paths.getElementsByTagName("Start").item(0).getTextContent();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getNextPath() {
        NodeList pathList = paths.getElementsByTagName("Path");
        for(int i = 0; i < pathList.getLength(); i++) {
            if(pathList.item(i).getTextContent().contentEquals(FILEPATH_IN)) {
                if(i < pathList.getLength() - 1) {
                    FILEPATH_IN = pathList.item(i + 1).getTextContent();
                    break;
                } else {
                    FILEPATH_IN = pathList.item(0).getTextContent();
                    break;
                }
            }
        }
        read();
        saveData();
        
        NodeList startPath = paths.getElementsByTagName("Start");
        startPath.item(0).setTextContent(FILEPATH_IN);
        try {
            DOMSource domSource = new DOMSource(paths);
            StreamResult streamResult = new StreamResult(new File("Paths.xml"));
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "PathsDTD.dtd");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.transform(domSource, streamResult);
            
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        return FILEPATH_IN;
    }
    
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
    
    public static String[][] searchElements(String search){
        String[][] games = new String[getElements("GName").length][3];
        for(int i = 0; i < games.length; i++) {
            games[i][0] = getElements("GName")[i];
            games[i][1] = getElements("GPlatform")[i];
            games[i][2] = getElements("GStatus")[i];
        }
        Arrays.sort(games, new ArrayCompare());
        String[][] series = new String[getElements("SName").length][4];
        for(int i = 0; i < series.length; i++) {
            series[i][0] = getElements("SName")[i];
            series[i][1] = getElements("SPlatform")[i];
            series[i][2] = getElements("Seasons")[i];
            series[i][3] = getElements("SStatus")[i];
        }
        Arrays.sort(series, new ArrayCompare());
        String[][] movies = new String[getElements("MName").length][3];
        for(int i = 0; i < movies.length; i++) {
            movies[i][0] = getElements("MName")[i];
            movies[i][1] = getElements("Suggested")[i];
            movies[i][2] = getElements("MStatus")[i];
        }
        Arrays.sort(movies, new ArrayCompare());
        String[][] activities = getActivities("All", "All", "All");
        Arrays.sort(activities, new ArrayCompare());
        String[][] all = new String[games.length + series.length + movies.length + activities.length][5];
        
        for(int i = 0; i < games.length; i++) {
            all[i][1] = "Game";
            all[i][0] = games[i][0];
            all[i][2] = games[i][1];
            all[i][4] = games[i][2];
        }
        for(int i = games.length; i < games.length + series.length; i++) {
            all[i][1] = "Series";
            all[i][0] = series[i - games.length][0];
            all[i][2] = series[i - games.length][1];
            all[i][3] = series[i - games.length][2];
            all[i][4] = series[i - games.length][3];
        }
        for(int i = games.length + series.length; i < games.length + series.length + movies.length; i++) {
            all[i][1] = "Movie";
            all[i][0] = movies[i - (games.length + series.length)][0];
            all[i][2] = movies[i - (games.length + series.length)][1];
            all[i][4] = movies[i - (games.length + series.length)][2];
        }
        for(int i = games.length + series.length + movies.length; i < games.length + series.length + movies.length + activities.length; i++) {
            all[i][1] = "Activity";
            all[i][0] = activities[i - (games.length + series.length + movies.length)][0];
            all[i][2] = activities[i - (games.length + series.length + movies.length)][1];
            all[i][3] = activities[i - (games.length + series.length + movies.length)][2];
            all[i][4] = activities[i - (games.length + series.length + movies.length)][3];
        }
        int counter = 0;
        for(int i = 0; i < all.length; i++) {
            if(all[i][0].toLowerCase().contains(search.toLowerCase())) {
                counter++;
            }
        }
        String[][] searchResults = new String[counter][5];
        counter = 0;
        for(int i = 0; i < all.length; i++) {
            if(all[i][0].toLowerCase().contains(search.toLowerCase())) {
                searchResults[counter][0] = all[i][0];
                searchResults[counter][1] = all[i][1];
                searchResults[counter][2] = all[i][2];
                searchResults[counter][3] = all[i][3];
                searchResults[counter][4] = all[i][4];
                counter++;
            }
        }
        return searchResults;
    }
    
    public static String translateIfPossible(String s) {
        try {
            s = Window.resources.getString(s);
        } catch (MissingResourceException e) {
            
        }
        return s;
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
        } else if(type.contentEquals("Activity")){
            String[] allDes = getElements("Description");
            String[] allLoc = getElements("Location");
            String[] allCat = getElements("Category");
            String[] allStats = getElements("AStatus");
            for(int i = 0; i < allDes.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    counter++;
                }
            }
            content = new String[counter][4];
            counter = 0;
            for(int i = 0; i < allDes.length; i++) {
                if (allStats[i].equals("Finished") && isTrue){
                    content[counter][0] = allDes[i];
                    content[counter][1] = allLoc[i];
                    content[counter][2] = allCat[i];
                    content[counter][3] = allStats[i];
                    counter++;
                } else if (!allStats[i].equals("Finished") && !isTrue){
                    content[counter][0] = allDes[i];
                    content[counter][1] = allLoc[i];
                    content[counter][2] = allCat[i];
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
    
    public static void addActivity(String description, String location, String category, String status) {
        Element data = doc.getDocumentElement();
        Element series = doc.createElement("Activity");
        Element elementName = doc.createElement("Description");
        Element elementPlatform = doc.createElement("Location");
        Element elementSeason = doc.createElement("Category");
        Element elementStatus = doc.createElement("AStatus");
        Text textDes = doc.createTextNode(description);
        Text textLoc = doc.createTextNode(location);
        Text textCat = doc.createTextNode(category);
        Text textStatus = doc.createTextNode(status);
        data.appendChild(series);
        series.appendChild(elementName);
        elementName.appendChild(textDes);
        series.appendChild(elementPlatform);
        elementPlatform.appendChild(textLoc);
        series.appendChild(elementSeason);
        elementSeason.appendChild(textCat);
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
        } else if (type.equals("Activity")) {
            all = doc.getElementsByTagName("Activity");
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
    
    public static void editActivity(String description, String location, String category, String status) {
        NodeList all = doc.getElementsByTagName("Activity");
        for(int i = 0; i < all.getLength(); i++) {
            if (all.item(i).getChildNodes().item(0).getTextContent().equals(description)) {
                all.item(i).getChildNodes().item(1).setTextContent(location);
                all.item(i).getChildNodes().item(2).setTextContent(category);
                all.item(i).getChildNodes().item(3).setTextContent(status);
            }
        }
    }
    
    public static void setTextSize(int textSize) {
        NodeList size = doc.getElementsByTagName("TextSize");
        size.item(0).setTextContent(String.valueOf(textSize));
        saveData();
    }
    
    public static void setLanguage(String lang) {
        NodeList language = doc.getElementsByTagName("Language");
        language.item(0).setTextContent(lang);
        saveData();
    }
    
    public static void setWindowSize(int x, int y) {
        NodeList sizeX = doc.getElementsByTagName("SizeX");
        NodeList sizeY = doc.getElementsByTagName("SizeY");
        sizeX.item(0).setTextContent(String.valueOf(x));
        sizeY.item(0).setTextContent(String.valueOf(y));
        saveData();
    }
    
    public static void exportData() {
        try {
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File(FILEPATH_IN));
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
        } finally {
            Window.unsavedChanges = 0;
            Window.btnSave.setEnabled(false);
            Window.lblToSave.setText(Window.resources.getString("ChangesToSave") + ": " + Window.unsavedChanges + " ");
            LatestUpdates.updates = new String[20][4];
        }
    }
    
    public static void saveData() {
        int games = DataHandler.getElements("GName").length;
        int series = DataHandler.getElements("SName").length;
        int movies = DataHandler.getElements("MName").length;
        int activities = DataHandler.getElements("Description").length;
        int gamesP = DataHandler.getFinishedElements("Game", false).length;
        int seriesP = DataHandler.getFinishedElements("Series", false).length;
        int moviesP = DataHandler.getFinishedElements("Movie", false).length;
        int activitiesP = DataHandler.getFinishedElements("Activity", false).length;
        
        Window.labelTotal.setText(String.valueOf(games + series + movies + activities) + " (" + (gamesP + seriesP + moviesP + activitiesP)
                + " " + Window.resources.getString("Pending") + ")");
        Window.label_GameCounter.setText(String.valueOf(games) + " (" + gamesP + " " + Window.resources.getString("Pending") + ")");
        Window.label_SeriesCounter.setText(String.valueOf(series) + " (" + seriesP + " " + Window.resources.getString("Pending") + ")"); 
        Window.label_MovieCounter.setText(String.valueOf(movies) + " (" + moviesP + " " + Window.resources.getString("Pending") + ")");
        Window.label_ActivityCounter.setText(String.valueOf(activities) + " (" + activitiesP + " " + Window.resources.getString("Pending") + ")");
        Window.lblTextbox.setText(" " + Window.resources.getString("Owner") + ": " 
                + ((DataHandler.getElements("Name2")[0] == "") ? (DataHandler.getElements("Name1")[0])
                        : (DataHandler.getElements("Name1")[0] + ", " + DataHandler.getElements("Name2")[0])));
    }
    
    public static void setNames(String name1, String name2) {
        NodeList settings = doc.getElementsByTagName("Settings");
        settings.item(0).getChildNodes().item(0).setTextContent(name1);
        settings.item(0).getChildNodes().item(1).setTextContent(name2);
        saveData();
     }
    
    public static String getMovieSuggestions() {
        String[] name1 = getElements("Name1");
        String[] name2 = getElements("Name2");
        String[] suggested = getElements("Suggested");
        String[] mStatus = getElements("MStatus");
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < suggested.length; i++) {
            if(mStatus[i].equals("Finished")) {
                if(suggested[i].equals(name2[0])) {
                    p2++;
                } else if (suggested[i].equals(name1[0])) {
                    p1++;
                }
            }
        }
        return Window.resources.getString("SuggestedMoviesWatched") + ": " + name1[0] + " - " + p1 + ", " + name2[0] + " - " + p2;
    }
    
    public static String[][] getActivities(String status, String location, String category) {
        String[][] data;
        Object[] objects;
        String[] des = getElements("Description");
        String[] loc = getElements("Location");
        String[] cat = getElements("Category");
        String[] sta = getElements("AStatus");
        data = new String[des.length][4];
        for(int i = 0; i < des.length; i++) {
            data[i][0] = des[i];
            data[i][1] = loc[i];
            data[i][2] = cat[i];
            data[i][3] = sta[i];
        }
        if(status.contentEquals("All")) {
            if(location.contentEquals("All")) {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[2].equals(category)).toArray();
                }
            } else {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[1].equals(location)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[1].equals(location)).filter((x) -> x[2].equals(category)).toArray();
                }
            }
        } else {
            if(location.contentEquals("All")) {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[2].equals(category)).toArray();
                }
            } else {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[1].equals(location)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[1].equals(location)).filter((x) -> x[2].equals(category)).toArray();
                }
            }
        }
        data = new String[objects.length][4];
        for(int i = 0; i < objects.length; i++) {
            data[i] = (String[]) objects[i];
        }
        return data;
    }
    
    public static String getRandomActivity(String status, String location, String category) {
        String[][] data;
        Object[] objects;
        String[] des = getElements("Description");
        String[] loc = getElements("Location");
        String[] cat = getElements("Category");
        String[] sta = getElements("AStatus");
        data = new String[des.length][4];
        for(int i = 0; i < des.length; i++) {
            data[i][0] = des[i];
            data[i][1] = loc[i];
            data[i][2] = cat[i];
            data[i][3] = sta[i];
        }
        if(status.contentEquals("All")) {
            if(location.contentEquals("All")) {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[2].equals(category)).toArray();
                }
            } else {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[1].equals(location)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[1].equals(location)).filter((x) -> x[2].equals(category)).toArray();
                }
            }
        } else {
            if(location.contentEquals("All")) {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[2].equals(category)).toArray();
                }
            } else {
                if(category.contentEquals("All")) {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[1].equals(location)).toArray();
                } else {
                    objects = Stream.of(data).filter((x) -> x[3].equals(status)).filter((x) -> x[1].equals(location)).filter((x) -> x[2].equals(category)).toArray();
                }
            }
        }
        data = new String[objects.length][4];
        for(int i = 0; i < objects.length; i++) {
            data[i] = (String[]) objects[i];
        }
        int random = (int) (Math.random()*data.length);
        try {
            return data[random][0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "No Activities Found";
        }
        
    }
}
