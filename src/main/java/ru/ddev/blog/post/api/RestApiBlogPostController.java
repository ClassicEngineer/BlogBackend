package ru.ddev.blog.post.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.BlogPostApplicationService;
import ru.ddev.blog.post.infrastructure.factory.DummyFactory;

import java.util.Collection;
import java.util.Optional;

@Log
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class RestApiBlogPostController {

    private final BlogPostApplicationService applicationService;

    @GetMapping("/posts")
    public Collection<BlogPostView> getPosts(@RequestParam(required = false) Long limit,
                                             @RequestParam(required = false) Long page) {
        return Optional.ofNullable(limit).map(DummyFactory::generatePosts).orElse(DummyFactory.one());
    }

    @GetMapping(value = "/posts/{id}")
    public BlogPostView getPostById(@PathVariable String id) {
        log.info("Get post by id called: " + id);
        return DummyFactory.dummy(id);
    }


    @PostMapping(value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BlogPostView createPost(@RequestBody BlogPostCreateView body) {
        log.info("Post body accepted: " + body);
       return applicationService.createPost(body);
    }

    @PutMapping(value = "/posts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BlogPostView updatePost(@RequestBody BlogPostUpdateView body, @PathVariable String id) {
        log.info("Put body accepted: " + body);
        return applicationService.updatePostById(id, body);
    }
}
