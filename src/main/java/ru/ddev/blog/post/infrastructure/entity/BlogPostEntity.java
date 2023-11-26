package ru.ddev.blog.post.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@Builder
@Document(collation = "posts")
public class BlogPostEntity {

    @MongoId
    private String id;

   //TODO: private Long postIndex with sequence

    private String content;

    private String title;

    private LocalDate createdAt;

    private LocalDate lastUpdatedAt;

    /*
        TODO: comments, author, date of creation
     */

}
