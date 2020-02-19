package project;

import javax.swing.table.AbstractTableModel;

public class SearchTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    protected String[][] searchedElements;
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return Window.resources.getString("SearchResult");
        } else if (column == 1) {
            return Window.resources.getString("Type");
        } else if (column == 2) {
            return Window.resources.getString("Data");
        } else if (column == 3) {
            return Window.resources.getString("Data");
        } else if (column == 4) {
            return Window.resources.getString("Status");
        } else {
            return "Error";
        }
    }
    
    @Override
    public int getRowCount() {
        if(searchedElements == null) {
            return 0;
        } else {
            return searchedElements.length;
        }
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(searchedElements[rowIndex][columnIndex] == null) {
            return " ";
        } else {
            return DataHandler.translateIfPossible(searchedElements[rowIndex][columnIndex]);
        }
    }

}
