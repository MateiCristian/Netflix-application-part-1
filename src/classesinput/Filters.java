package classesinput;

import classes.Contains;

public class Filters {
    private Sort sort;
    private Contains contains;

    /**
     * @return
     */
    public Sort getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(final Sort sort) {
        this.sort = sort;
    }

    /**
     * @return
     */
    public Contains getContains() {
        return contains;
    }

    /**
     * @param contains
     */
    public void setContains(final Contains contains) {
        this.contains = contains;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Filters{"
                + "sort=" + sort
                + ", contains=" + contains
                + '}';
    }
}
