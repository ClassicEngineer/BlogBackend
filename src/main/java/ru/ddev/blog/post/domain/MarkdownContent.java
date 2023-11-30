package ru.ddev.blog.post.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ddev.blog.post.domain.exception.MarkdownParseException;

@Data
@AllArgsConstructor
public class MarkdownContent {

    public String raw;

    public static MarkdownContent extract(String raw) throws MarkdownParseException {
        try {
            return raw.contains("---") ? new MarkdownContent(raw.split("---")[2]) : new MarkdownContent(raw);
        } catch (Exception e) {
            throw new MarkdownParseException(e);
        }
    }
}
