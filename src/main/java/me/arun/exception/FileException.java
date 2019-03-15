package me.arun.exception;

public class FileException extends RuntimeException {
    public FileException(Exception e) {
        super(e);
    }
}
