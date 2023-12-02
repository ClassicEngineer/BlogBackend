package ru.ddev.blog.post.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ddev.blog.post.domain.BlogPost;
import ru.ddev.blog.post.infrastructure.entity.BlogPostEntity;
import ru.ddev.blog.post.infrastructure.factory.BlogPostFactory;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class BlogPostRepository {

    private final BlogPostDomainRepository blogPostDomainRepository;
    public void save(BlogPost post) {
        BlogPostEntity entity = BlogPostFactory.domainToEntity(post);
        entity.setLastUpdatedAt(LocalDate.now());
        entity = blogPostDomainRepository.save(entity);
        post.setId(entity.getId());
    }

    public Optional<BlogPost> findById(String id) {
        return blogPostDomainRepository.findById(id).map(BlogPostFactory::entityToDomain);
    }

    public Collection<BlogPost> findByPageRequest(PageRequest request) {
        return blogPostDomainRepository.findAll(request).stream().map(BlogPostFactory::entityToDomain).toList();
    }

    public Collection<BlogPost> findBy(String searchBy) {
        return blogPostDomainRepository.findAllByContentContainsIgnoreCaseOrTitleContainsIgnoreCase(searchBy, searchBy).stream()
                .map(BlogPostFactory::entityToDomain)
                .toList();
    }
}
