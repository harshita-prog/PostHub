package com.post.posthub.controller;

import com.post.posthub.DTO.postDTO;
import com.post.posthub.Entity.Post;
import com.post.posthub.Repository.PostRepository;
import com.post.posthub.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    public PostController( @Autowired PostRepository postRepository, @Autowired PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }

    @GetMapping("/all")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "all-posts";
    }



    @PostMapping("/create-post")
    public String createPost(@ModelAttribute("post") postDTO post, Model model) {
      Post post1 =  postService.createPost(post);
      model.addAttribute("post", post);
        return "redirect:/posts/all";

    }
    @GetMapping("/create-post")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }




}
