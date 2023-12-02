package ru.ddev.blog.post.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDto {

    private String searchBy;

    public static SearchDto from(String input) {
        return new SearchDto(input);
    }
}
