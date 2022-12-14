package classes;

import java.util.ArrayList;

public class Page {
    private String name;
    private ArrayList<String> nextPages;
    public Page() {
    }
    public Page(final String name, final ArrayList<String> nextPages) {
        this.name = name;
        this.nextPages = nextPages;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public ArrayList<String> getNextPages() {
        return nextPages;
    }

    /**
     * @param nextPages
     */
    public void setNextPages(final ArrayList<String> nextPages) {
        this.nextPages = nextPages;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Page{"
                + "name='" + name + '\''
                + ", nextPages=" + nextPages
                + '}';
    }
}
