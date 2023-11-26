package ru.ddev.blog.post.infrastructure.factory;

import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.dto.PostDto;
import ru.ddev.blog.post.domain.BlogPost;
import ru.ddev.blog.post.domain.PostContent;
import ru.ddev.blog.post.infrastructure.entity.BlogPostEntity;


public class BlogPostFactory {

    public static PostDto viewToDto(BlogPostCreateView view) {
        return PostDto.builder()
                .title(view.getTitle())
                .content(view.getContent())
                .build();
    }

    public static PostDto viewToDto(BlogPostUpdateView view) {
        return PostDto.builder()
                .title(view.getTitle())
                .content(view.getContent())
                .build();
    }

    public static BlogPostView dtoToView(PostDto dto) {
        return BlogPostView.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    public static PostDto postToDto(BlogPost post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent().getRaw())
                .build();
    }

    public static BlogPostEntity domainToEntity(BlogPost post) {
        return BlogPostEntity.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent().getRaw())
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static BlogPost entityToDomain(BlogPostEntity entity) {
        return BlogPost.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(new PostContent(entity.getContent()))
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
