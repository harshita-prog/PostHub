package com.post.posthub.Service;

import com.post.posthub.Entity.Post;

import java.util.List;

public interface PostService {


    Post getPostById(Long id);

    List<Post> getAllPosts();

    Post createPost(Post post);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);
}