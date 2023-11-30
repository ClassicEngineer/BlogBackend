package ru.ddev.blog.post.domain;

import lombok.Data;

@Data
public class PostContent {
    private String raw;
    private String header;
    private String content;


    public PostContent(String raw, String header, String content) {
        this.raw = raw;
        this.header = header;
        this.content = content;
    }

    public void parse() {

    }
}
