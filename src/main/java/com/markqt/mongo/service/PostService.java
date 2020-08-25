package com.markqt.mongo.service;

import com.markqt.mongo.model.Comment;
import com.markqt.mongo.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Mono<Post> save(Post post);

    Flux<Post> findAll();

    Mono<Post> addComment(Comment comment, String postId);

    Mono<Post> find(String postId);

    Flux<Post> subscribe(String postId);
}