package ru.ddev.blog.post.domain;

import lombok.*;

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

    @SneakyThrows
    public BlogPost(String raw)  {
        MarkdownHeader header = MarkdownHeader.extract(raw);
        MarkdownContent content = MarkdownContent.extract(raw);

        this.title = header.getTitle();
        this.content = new PostContent(raw, header.getRaw(), content.getRaw());
        this.createdAt = LocalDate.now();
    }

    @SneakyThrows
    public void update(String title, String raw) {
        MarkdownHeader header = MarkdownHeader.extract(raw);
        MarkdownContent md = MarkdownContent.extract(raw);

        this.title = title;
        this.content = new PostContent(raw, header.getRaw(), content.getRaw());
    }
}
