package ru.ddev.blog.post.domain;

import lombok.Data;

@Data
public class PostContent {
    private String raw;

    public PostContent(String raw) {
        this.raw = raw;
    }

    public void parse() {

    }
}
