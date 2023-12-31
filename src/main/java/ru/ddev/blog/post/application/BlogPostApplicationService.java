package ru.ddev.blog.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostPaginationView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.dto.GetPostsDto;
import ru.ddev.blog.post.domain.BlogPostService;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;

import java.util.Optional;

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

    public BlogPostPaginationView getPaginationView(Long limit, Long page) {
        var dto = blogPostService.getPosts(new GetPostsDto(limit, page));
        var views = dto.getPosts().stream().map(BlogPostFactory::dtoToView).toList();
        return new BlogPostPaginationView(views, dto.getTotalPages());
    }

    public Optional<BlogPostView> getPostById(String id) {
        return blogPostService.getPostById(id).map(BlogPostFactory::dtoToView);
    }
}
