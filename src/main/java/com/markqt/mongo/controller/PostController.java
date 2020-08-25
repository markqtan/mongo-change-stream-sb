package com.markqt.mongo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markqt.mongo.model.Comment;
import com.markqt.mongo.model.CommentRequest;
import com.markqt.mongo.model.Post;
import com.markqt.mongo.model.PostRequest;
import com.markqt.mongo.service.PostService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Flux<Post> findAll() {
        return this.postService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Post> find(@PathVariable String id) {
        return this.postService.find(id);
    }

    @GetMapping(path = "/{id}/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Post> subscribe(@PathVariable String id) {
        return this.postService.subscribe(id);
    }

    @PostMapping("/{id}/comment")
    public Mono<Post> comment(@RequestBody CommentRequest request, @PathVariable String id) {
        return this.postService.addComment(Comment.from(request), id);
    }

    @PostMapping("/create")
    public Mono<Post> create(@RequestBody PostRequest postRequest) {
        return this.postService.save(Post.from(postRequest));
    }

}