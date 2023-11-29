package ru.ddev.blog.post.infrastructure.factory;

import ru.ddev.blog.post.api.view.AuthorView;
import ru.ddev.blog.post.api.view.BlogPostView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class DummyFactory {

    private final static Random random = new Random();

    public static List<BlogPostView> generatePosts(Long limit) {
        return Stream.generate(() -> dummy(UUID.randomUUID().toString())).limit(limit).toList();
    }

    public static List<BlogPostView> one() {
        return Collections.singletonList(BlogPostView.builder()
                        .id("1")
                .author(new AuthorView("Dan", 1L))
                .title("New Post")
                .creationDate(LocalDate.now())
                .content("Lorem Ipsum content")
                .build());
    }

    public static BlogPostView dummy(String id) {
        return BlogPostView.builder()
                .id(id)
                .author(new AuthorView("Dan", 1L))
                .title("New Post")
                .creationDate(LocalDate.now())
                .content("Lorem Ipsum content")
                .build();
    }

}
