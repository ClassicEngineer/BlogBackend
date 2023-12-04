package ru.ddev.blog.post.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostPaginationView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.BlogPostApplicationService;

import java.util.Collection;

@Log
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class RestApiBlogPostController {

    private final BlogPostApplicationService applicationService;

    @GetMapping("/posts")
    public ResponseEntity<BlogPostPaginationView> getPosts(@RequestParam(required = false) Long limit,
                                             @RequestParam(required = false) Long page) {
        BlogPostPaginationView paginationView = applicationService.getPaginationView(limit, page);
        return ResponseEntity.ok()
                .body(paginationView);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<BlogPostView> getPostById(@PathVariable String id) {
        log.info("Get post by id called: " + id);
        return applicationService.getPostById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
