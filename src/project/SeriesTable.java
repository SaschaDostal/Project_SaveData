package project;

import javax.swing.table.AbstractTableModel;

public class SeriesTable extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    private Filter filter = Filter.ALL;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == 0) {
            return Window.resources.getString("Name");
        } else if (column == 1) {
            return Window.resources.getString("Platform");
        } else if (column == 2) {
            return Window.resources.getString("Seasons");
        } else if (column == 3) {
            return Window.resources.getString("Status");
        } else {
            return "Error";
        }
    }
    
    @Override
    public int getRowCount() {
        if(filter == Filter.ALL) {
            return DataHandler.getElements("Series").length;
        } else if (filter == Filter.FINISHED) {
            return DataHandler.getFinishedElements("Series", true).length;
        } else if (filter == Filter.PENDING) {
            return DataHandler.getFinishedElements("Series", false).length;
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (filter == Filter.ALL) {
            if (columnIndex == 0) {
                return DataHandler.getElements("SName")[rowIndex];
            } else if (columnIndex == 1) {
                return DataHandler.getElements("SPlatform")[rowIndex];
            } else if (columnIndex == 2) {
                return DataHandler.getElements("Seasons")[rowIndex];
            } else if (columnIndex == 3) {
                return DataHandler.translateIfPossible(DataHandler.getElements("SStatus")[rowIndex]);
            } else {
                return "error";
            }
        } else if (filter == Filter.FINISHED) {
            return DataHandler.translateIfPossible(DataHandler.getFinishedElements("Series", true)[rowIndex][columnIndex]);
        } else if (filter == Filter.PENDING) {
            return DataHandler.translateIfPossible(DataHandler.getFinishedElements("Series", false)[rowIndex][columnIndex]);
        } else {
            return null;
        }
    }
}
