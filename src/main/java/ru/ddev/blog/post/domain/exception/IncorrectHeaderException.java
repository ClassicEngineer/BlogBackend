package ru.ddev.blog.post.domain.exception;

public class IncorrectHeaderException extends Exception {
    public IncorrectHeaderException(Exception e) {
        super(e);
    }
}
