package project;

public class ComboItem {
    protected String label;
    protected String value;

    public ComboItem(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return label;
    }
}
