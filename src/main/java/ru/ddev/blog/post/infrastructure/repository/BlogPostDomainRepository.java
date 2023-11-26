package ru.ddev.blog.post.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.ddev.blog.post.infrastructure.entity.BlogPostEntity;

@Repository
public interface BlogPostDomainRepository extends MongoRepository<BlogPostEntity, String> {
}
