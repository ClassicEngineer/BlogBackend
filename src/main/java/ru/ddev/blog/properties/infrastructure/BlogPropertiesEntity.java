package ru.ddev.blog.properties.infrastructure;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@Document(collation = "properties")

public class BlogPropertiesEntity {
    @MongoId
    private String id;

    private String blogName;


}