package ru.ddev.blog.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.domain.BlogPostService;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;

@Service
@RequiredArgsConstructor
public class BlogPostApplicationService {

    private final BlogPostService blogPostService;
    public BlogPostView createPost(BlogPostCreateView view) {
        var dto = BlogPostFactory.viewToDto(view);
        dto = blogPostService.createPost(dto);
        return BlogPostFactory.dtoToView(dto);
    }

    public BlogPostView updatePostById(String id, BlogPostUpdateView view) {
        var dto = BlogPostFactory.viewToDto(view);
        dto = blogPostService.updatePostById(id, dto);
        return BlogPostFactory.dtoToView(dto);
    }
}
