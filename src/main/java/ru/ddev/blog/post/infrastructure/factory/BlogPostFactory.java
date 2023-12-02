package ru.ddev.blog.post.infrastructure.factory;

import ru.ddev.blog.post.api.view.BlogPostCreateView;
import ru.ddev.blog.post.api.view.BlogPostUpdateView;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.dto.PostDto;
import ru.ddev.blog.post.domain.BlogPost;
import ru.ddev.blog.post.domain.PostContent;
import ru.ddev.blog.post.infrastructure.entity.BlogPostEntity;

import java.text.MessageFormat;


public class BlogPostFactory {

    public static PostDto viewToDto(BlogPostCreateView view) {
        return PostDto.builder()
                .content(view.getContent())
                .build();
    }

    public static PostDto viewToDto(BlogPostUpdateView view) {
        return PostDto.builder()
                .content(view.getContent())
                .build();
    }

    public static BlogPostView dtoToView(PostDto dto) {
        return BlogPostView.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .header(dto.getHeader())
                .content(dto.getContent())
                .creationDate(dto.getCreatedAt())
                .imgSrc(dto.getImageSource())
                .build();
    }

    public static PostDto postToDto(BlogPost post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent().getContent())
                .header(post.getContent().getHeader())
                .createdAt(post.getCreatedAt())
                .imageSource(post.getImageSource())
                .build();
    }

    public static BlogPostEntity domainToEntity(BlogPost post) {
        return BlogPostEntity.builder()
                .id(post.getId())
                .title(post.getTitle())
                .header(post.getContent().getHeader())
                .content(post.getContent().getContent())
                .imageSource(post.getImageSource())
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static BlogPost entityToDomain(BlogPostEntity entity) {
        String post = MessageFormat.format("{0}\n{1}", entity.getHeader(), entity.getContent());
        return BlogPost.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(new PostContent(post, entity.getHeader(), entity.getContent()))
                .createdAt(entity.getCreatedAt())
                .imageSource(entity.getImageSource())
                .build();
    }
}
