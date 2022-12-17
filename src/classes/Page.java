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
     * @return returning the name of the current page
     */
    public String getName() {
        return name;
    }

    /**
     * @param name setting the name of the current page
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return returning an arraylist of next pages
     */
    public ArrayList<String> getNextPages() {
        return nextPages;
    }

    /**
     * method sets all the name of the pages where you can navigate from the current page
     * @param nextPages is an arraylist with all page names
     */
    public void setNextPages(final ArrayList<String> nextPages) {
        this.nextPages = nextPages;
    }

    /**
     * @return returning all the page parameters
     */
    @Override
    public String toString() {
        return "Page{"
                + "name='" + name + '\''
                + ", nextPages=" + nextPages
                + '}';
    }
}
