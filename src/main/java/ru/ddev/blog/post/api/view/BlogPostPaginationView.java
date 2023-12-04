package ru.ddev.blog.post.api.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class BlogPostPaginationView {
    private Collection<BlogPostView> posts;
    private Integer totalCount;

}
