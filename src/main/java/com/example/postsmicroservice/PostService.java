package com.example.postsmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Cacheable("posts")
    List<Post> findAll() {
        // Simulate a time-consuming lookup
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post save(Post product) {
        return postRepository.save(product);
    }

    public Post updatePost(Long id, Post updatePost) {
        Post existingPost = postRepository.findById(id).get();

        existingPost.setTitle(updatePost.getTitle());
        existingPost.setDescription(updatePost.getDescription());
        existingPost.setDescription(updatePost.getDescription());

        return postRepository.save(existingPost);
    }

    @CacheEvict(value = "posts", key = "#id")
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
