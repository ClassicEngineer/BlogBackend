package ru.ddev.blog.post.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.ddev.blog.post.api.view.BlogPostView;
import ru.ddev.blog.post.application.dto.GetPostsDto;
import ru.ddev.blog.post.application.dto.PostDto;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;
import ru.ddev.blog.post.infrastructure.repository.BlogPostRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public PostDto createPost(PostDto postDto) {
        BlogPost post = new BlogPost(postDto.getContent());

        blogPostRepository.save(post);

       return BlogPostFactory.postToDto(post);
    }


    public PostDto updatePostById(String id, PostDto dto) {
        BlogPost post = blogPostRepository.findById(id).orElse(new BlogPost(dto.getContent()));

        post.update(dto.getTitle(), dto.getContent());

        blogPostRepository.save(post);

        return BlogPostFactory.postToDto(post);
    }

    public Collection<PostDto> getPosts(GetPostsDto getPostsDto) {
        PageRequest request = PageRequest.of(getPostsDto.getPage(),
                getPostsDto.getLimit());
        return blogPostRepository.findByPageRequest(request)
                .stream()
                .map(BlogPostFactory::postToDto)
                .toList();
    }

    public <T> Optional<PostDto> getPostById(String id) {
        return blogPostRepository.findById(id).map(BlogPostFactory::postToDto);
    }
}
