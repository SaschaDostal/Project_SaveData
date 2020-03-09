package project;

import javax.swing.table.AbstractTableModel;

public class UpdateTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public String getColumnName(int column) {
        if (column == 0) {
            return Window.resources.getString("Update");
        } else if (column == 1) {
            return Window.resources.getString("Object");
        } else if (column == 2) {
            return Window.resources.getString("Label");
        } else if (column == 3) {
            return Window.resources.getString("DataOf");
        } else {
            return "Error";
        }
    }
    
    @Override
    public int getRowCount() {
        int i = 0;
        while(i < 20) {
            if(LatestUpdates.updates[i][0] == null) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DataHandler.translateIfPossible(LatestUpdates.updates[rowIndex][columnIndex]);
    }

}
