package com.post.posthub.controller;

import com.post.posthub.Entity.Post;
import com.post.posthub.Repository.PostRepository;
import com.post.posthub.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update-and-delete")
public class DeleteAndUpdateController {
    private final PostRepository postRepository;
    private final PostService postService;

    public DeleteAndUpdateController(PostRepository postRepository, @Autowired PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }
    @PutMapping("update/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    // DELETE endpoint to delete a post by ID
    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
