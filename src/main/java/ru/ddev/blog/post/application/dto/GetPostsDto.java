package ru.ddev.blog.post.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class GetPostsDto {

    private Long limit; // AHAHA long limit for posts LOOOL
    private Long page;


    public int getLimit() {
        return Optional.ofNullable(limit).map(Long::intValue).orElse(10);
    }

    public int getPage() {
        return Optional.ofNullable(page).map(Long::intValue).orElse(0);
    }
}
