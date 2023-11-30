package ru.ddev.blog.post.api.view;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BlogPostView {

    private String id;

    private String title;

    private String imageSrc;

    private String content;

    private String header;

    private List<TagView> tags;

    private List<CommentView> comments;

    private AuthorView author;

    private LocalDate creationDate;


}
