package classesinput;

import classes.Credentials;

public class CredentialsInput {
    private Credentials credentials;

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
    @Override
    public String toString() {
        return "CredentialsInput{"
                + "credentials=" + credentials
                + '}';
    }
}
