package me.arun.exception;

public class DatabaseException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Database problem" + super.getMessage();
    }
}
