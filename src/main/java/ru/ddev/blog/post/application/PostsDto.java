package ru.ddev.blog.post.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.ddev.blog.post.application.dto.PostDto;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PostsDto {
    private Collection<PostDto> posts;
    private Integer totalPages;
}
