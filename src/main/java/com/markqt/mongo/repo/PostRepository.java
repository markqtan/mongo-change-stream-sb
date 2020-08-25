package com.markqt.mongo.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.markqt.mongo.model.Post;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {
}