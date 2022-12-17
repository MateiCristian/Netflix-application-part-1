package classesinput;

public class Filters {
    private Sort sort;
    private Contains contains;

    /**
     * @return returning the sorting method
     */
    public Sort getSort() {
        return sort;
    }

    /**
     * @param sort setting the sorting method
     */
    public void setSort(final Sort sort) {
        this.sort = sort;
    }

    /**
     * @return returning contains method
     */
    public Contains getContains() {
        return contains;
    }

    /**
     * @param contains setting contains method
     */
    public void setContains(final Contains contains) {
        this.contains = contains;
    }
}
