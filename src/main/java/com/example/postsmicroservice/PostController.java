package com.example.postsmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserSenderService senderService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody Post product) {
        senderService.sendMessage("", "PostQueue", "New post has been created");
        return postService.save(product);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
