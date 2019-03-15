package me.arun.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(Exception e) {
        super(e);
    }

    @Override
    public String getMessage() {
        return "Database problem" + super.getMessage();
    }
}
