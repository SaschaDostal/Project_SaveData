package project;

public class LatestUpdates {
    protected static String[][] updates = new String[10][4];
    
    public static void addUpdate(String update, String object, String name, String data){
        if(!(update.equals(updates[0][0]) && object.equals(updates[0][1]) && name.equals(updates[0][2]) && data.equals(updates[0][3]))) {
            for(int i = 9; i > 0; i--) {
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
