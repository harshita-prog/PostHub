package com.post.posthub.Service;

import com.post.posthub.DTO.postDTO;
import com.post.posthub.Entity.Post;
import com.post.posthub.Repository.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(postDTO post) {
      Post post1 = new Post();
      post1.setId(Long.parseLong(post.getId()));
      post1.setContent(post.getContent());
      post1.setTitle(post.getTitle());
        return postRepository.save(post1);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            return postRepository.save(existingPost);
        } else {
            return null;
        }
    }
    // adding this to check how it will take care ( abbbb bbbbb ccccccc cccccdddddd ccccccdccccdddd uuuuuu  mmmmm THis
    // line willt ake lot of characters at once and will check on it )
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
