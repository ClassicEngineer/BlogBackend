package ru.ddev.blog.post.api.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostCreateView {

    private String content = ""; // Markdown content with special header
}
