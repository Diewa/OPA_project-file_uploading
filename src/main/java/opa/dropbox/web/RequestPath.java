package opa.dropbox.web;

public final class RequestPath {

    public static final String USER_PATH = "/users";

    public static final String USER_FILE_PATH = USER_PATH + "/{userId:.+}/file";
}
