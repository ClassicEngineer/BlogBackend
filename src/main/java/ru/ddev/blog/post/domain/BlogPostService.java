package ru.ddev.blog.post.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ddev.blog.post.application.dto.PostDto;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;
import ru.ddev.blog.post.infrastructure.repository.BlogPostRepository;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public PostDto createPost(PostDto postDto) {
        BlogPost post = new BlogPost(postDto.getTitle(), postDto.getContent());

        blogPostRepository.save(post);

       return BlogPostFactory.postToDto(post);
    }


    public PostDto updatePostById(String id, PostDto dto) {
        BlogPost post = blogPostRepository.findById(id).orElse(new BlogPost(dto.getTitle(), dto.getContent()));

        post.update(dto.getTitle(), dto.getContent());

        blogPostRepository.save(post);

        return BlogPostFactory.postToDto(post);
    }
}
