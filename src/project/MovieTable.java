package project;

import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class MovieTable extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private Filter filter = Filter.ALL;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return Window.resources.getString("Name");
        } else if (column == 1 && !(DataHandler.getElements("Name2")[0] == "")) {
            return Window.resources.getString("Suggested");
        } else if (column == 2 || (column == 1 && (DataHandler.getElements("Name2")[0] == ""))) {
            return Window.resources.getString("Status");
        } else {
            return "Error";
        }
    }

    @Override
    public int getRowCount() {
        if(filter == Filter.ALL) {
            return DataHandler.getElements("Movie").length;
        } else if (filter == Filter.FINISHED) {
            return DataHandler.getFinishedElements("Movie", true).length;
        } else if (filter == Filter.PENDING) {
            return DataHandler.getFinishedElements("Movie", false).length;
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        if((DataHandler.getElements("Name2")[0] == "")) {
            return 2;
        }
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (filter == Filter.ALL) {
            String[][] all = ArrayCompare.transpose(new String[][] {DataHandler.getElements("MName"), DataHandler.getElements("Suggested"), DataHandler.getElements("MStatus")});
            Arrays.sort(all, new ArrayCompare());
            if (DataHandler.getElements("Name2")[0] == "" && columnIndex == 1) {
                return DataHandler.translateIfPossible(all[rowIndex][columnIndex+1]);
            } else {
                return DataHandler.translateIfPossible(all[rowIndex][columnIndex]);
            }
        } else if (filter == Filter.FINISHED) {
            String[][] finished = DataHandler.getFinishedElements("Movie", true);
            Arrays.sort(finished, new ArrayCompare());
            if(DataHandler.getElements("Name2")[0] == "" && columnIndex == 1) {
                return DataHandler.translateIfPossible(finished[rowIndex][columnIndex+1]);
            } else {
                return DataHandler.translateIfPossible(finished[rowIndex][columnIndex]);
            }
        } else if (filter == Filter.PENDING) {
            String[][] pending = DataHandler.getFinishedElements("Movie", false);
            Arrays.sort(pending, new ArrayCompare());
            if(DataHandler.getElements("Name2")[0] == "" && columnIndex == 1) {
                return DataHandler.translateIfPossible(pending[rowIndex][columnIndex+1]);
            } else {
                return DataHandler.translateIfPossible(pending[rowIndex][columnIndex]);
            }
        } else {
            return null;
        }
    }

}
