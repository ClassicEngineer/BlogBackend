package ru.ddev.blog.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {

    private String id;

    private String title;

    private PostContent content;

    private LocalDate createdAt;

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = new PostContent(content);
        this.createdAt = LocalDate.now();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = new PostContent(content);
    }
}
