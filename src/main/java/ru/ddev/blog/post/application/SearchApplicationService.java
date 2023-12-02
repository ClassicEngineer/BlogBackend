package ru.ddev.blog.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.dto.SearchDto;
import ru.ddev.blog.post.domain.BlogPostService;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SearchApplicationService {

    private final BlogPostService postService;
    public Collection<BlogPostView> searchByInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return Collections.emptyList();
        }
        return postService.getPosts(SearchDto.from(input))
                .stream().map(BlogPostFactory::dtoToView).toList();
    }
}
