package Classes;

import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<String> nextPages;
    public Page(){}
    public Page(String name, ArrayList<String> nextPages) {
        this.name = name;
        this.nextPages = nextPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getNextPages() {
        return nextPages;
    }

    public void setNextPages(ArrayList<String> nextPages) {
        this.nextPages = nextPages;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                ", nextPages=" + nextPages +
                '}';
    }
}
