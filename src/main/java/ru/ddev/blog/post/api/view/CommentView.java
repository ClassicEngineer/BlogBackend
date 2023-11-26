package ru.ddev.blog.post.api.view;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentView {

    private String content;
    private CommentAuthorView author;
    private LocalDate creationDate;
}
