package classesinput;

import classes.Credentials;

public class Actions {
    private String type;
    private String page;
    private String feature;
    private Credentials credentials;
    private Filters filters;
    private String startsWith;
    private String objectType;
    private String movie;
    private int rate;
    private int count;

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Actions{"
                + "type='" + type + '\''
                + ", page='" + page + '\''
                + ", feature='" + feature + '\''
                + ", credentials=" + credentials
                + ", filters=" + filters
                + ", startsWith='" + startsWith + '\''
                + ", objectType='" + objectType + '\''
                + ", movie='" + movie + '\''
                + ", rate=" + rate
                + ", count=" + count
                + '}';
    }

    /**
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page
     */
    public void setPage(final String page) {
        this.page = page;
    }

    /**
     * @return
     */
    public String getFeature() {
        return feature;
    }

    /**
     * @param feature
     */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /**
     * @return
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * @param filters
     */
    public void setFilters(final Filters filters) {
        this.filters = filters;
    }

    /**
     * @return
     */
    public String getStartsWith() {
        return startsWith;
    }

    /**
     * @param startsWith
     */
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    /**
     * @return
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * @param objectType
     */
    public void setObjectType(final String objectType) {
        this.objectType = objectType;
    }

    /**
     * @return
     */
    public String getMovie() {
        return movie;
    }

    /**
     * @param movie
     */
    public void setMovie(final String movie) {
        this.movie = movie;
    }

    /**
     * @return
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate
     */
    public void setRate(final int rate) {
        this.rate = rate;
    }

}
