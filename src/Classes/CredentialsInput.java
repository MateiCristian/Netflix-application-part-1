package Classes;

public class CredentialsInput {
    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "CredentialsInput{" +
                "credentials=" + credentials +
                '}';
    }
}
