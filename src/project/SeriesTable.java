package project;

import java.util.Arrays;

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
            String[][] all = ArrayCompare.transpose(new String[][] {DataHandler.getElements("SName"), DataHandler.getElements("SPlatform"), DataHandler.getElements("Seasons"), DataHandler.getElements("SStatus")});
            Arrays.sort(all, new ArrayCompare());
            return DataHandler.translateIfPossible(all[rowIndex][columnIndex]);
        } else if (filter == Filter.FINISHED) {
            String[][] finished = DataHandler.getFinishedElements("Series", true);
            Arrays.sort(finished, new ArrayCompare());
            return DataHandler.translateIfPossible(finished[rowIndex][columnIndex]);
        } else if (filter == Filter.PENDING) {
            String[][] pending = DataHandler.getFinishedElements("Series", false);
            Arrays.sort(pending, new ArrayCompare());
            return DataHandler.translateIfPossible(pending[rowIndex][columnIndex]);
        } else {
            return null;
        }
    }
}
