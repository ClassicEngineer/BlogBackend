package ru.ddev.blog.post.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String content = "";
    private String header = "";
    private LocalDate createdAt;
}
