package project;

import javax.swing.table.AbstractTableModel;

public class ActivityTable extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    private String status = "All";
    private String location = "All";
    private String category = "All";

    public void setFilter(Filter filter) {
        if(filter == Filter.ALL) {
            status = "All";
        } else if (filter == Filter.FINISHED) {
            status = "Finished";
        } else if (filter == Filter.PENDING) {
            status = "Pending";
        }
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == 0) {
            return "Description";
        } else if (column == 1) {
            return "Location";
        } else if (column == 2) {
            return "Category";
        } else if (column == 3) {
            return "Status";
        } else {
            return "Error";
        }
    }
    
    @Override
    public int getRowCount() {
        return DataHandler.getActivities(status, location, category).length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DataHandler.getActivities(status, location, category)[rowIndex][columnIndex];
    }
}
