package ru.ddev.blog.post.infrastructure.factory;

import ru.ddev.blog.post.api.view.AuthorView;
import ru.ddev.blog.post.api.view.BlogPostView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class DummyFactory {

    private final static Random random = new Random();

    public static List<BlogPostView> generatePosts(Long limit) {
        return Stream.generate(() -> dummy(random.nextLong())).limit(limit).toList();
    }

    public static List<BlogPostView> one() {
        return Collections.singletonList(BlogPostView.builder()
                .author(new AuthorView("Dan", 1L))
                .title("New Post")
                .creationDate(LocalDate.now())
                .content("Lorem Ipsum content")
                .build());
    }

    private static BlogPostView dummy(Long id) {
        return BlogPostView.builder()
                .author(new AuthorView("Dan", id))
                .title("New Post")
                .creationDate(LocalDate.now())
                .content("Lorem Ipsum content")
                .build();
    }

}
