package ru.ddev.blog.post.api.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorView {

    private String name;
    private Long id;
}
