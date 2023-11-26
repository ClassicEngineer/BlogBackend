package ru.ddev.blog.post.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String content = "";
}
