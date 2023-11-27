package ru.ddev.blog.properties.api.view;

import lombok.Builder;
import lombok.Data;
import ru.ddev.blog.properties.domain.PaginationType;

@Data
@Builder
public class BlogPostPropertiesView {

    private String blogName;

    private PaginationType paginationType;


    public static BlogPostPropertiesView defaultProperties() {
        return BlogPostPropertiesView.builder()
                .blogName("Developer's Blog")
                .paginationType(PaginationType.INFINITE_SCROLL)
                .build();
    }
}
