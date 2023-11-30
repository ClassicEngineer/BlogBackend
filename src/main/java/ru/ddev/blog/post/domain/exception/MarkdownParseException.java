package ru.ddev.blog.post.domain.exception;

public class MarkdownParseException extends Throwable {
    public MarkdownParseException(Exception e) {
        super(e);
    }
}
