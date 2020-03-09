package project;

public class LatestUpdates {
    protected static String[][] updates = new String[20][4];
    
    public static void addUpdate(String update, String object, String name, String data){
        if(!(update.equals(updates[0][0]) && object.equals(updates[0][1]) && name.equals(updates[0][2]) && data.equals(updates[0][3]))) {
            Window.lblToSave.setText(Window.resources.getString("ChangesToSave") + ": " + ++Window.unsavedChanges + " ");
            Window.lblStartSett.setText(" " + Window.resources.getString("CurrentSettings") + ": "
                    + Window.resources.getString("Language") + " [" + DataHandler.getElements("Language")[0] + "], "
                    + Window.resources.getString("WindowSize") + " [" + DataHandler.getElements("SizeX")[0] + "x" + DataHandler.getElements("SizeY")[0]
                    + "], " + Window.resources.getString("TextSize") + " [" + ((Integer.parseInt(DataHandler.getElements("TextSize")[0])==14)?Window.resources.getString("Small")
                            :((Integer.parseInt(DataHandler.getElements("TextSize")[0])==18)?Window.resources.getString("Medium"):Window.resources.getString("Large"))) + "]");
            if(!(updates[19][0] == null)) {
                updates = new String[20][4];
                DataHandler.exportData();
                return;
            }
            Window.btnSave.setEnabled(true);
            for(int i = 19; i > 0; i--) {
                if(updates[i-1][0] == null) continue;
                updates[i][0] = updates[i-1][0];
                updates[i][1] = updates[i-1][1];
                updates[i][2] = updates[i-1][2];
                updates[i][3] = updates[i-1][3];
            }
            updates[0][0] = update;
            updates[0][1] = object;
            updates[0][2] = name;
            updates[0][3] = data;
        }
    }
}
