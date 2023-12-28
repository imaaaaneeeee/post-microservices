package org.bte.socialmedia.postservice.controllers;

import java.util.List;

import org.bte.socialmedia.postservice.business.PostService;
import org.bte.socialmedia.postservice.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	public PostController() {
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = service.getPostById(id);
        return post != null
                ? new ResponseEntity<>(post, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    
    @GetMapping("/search/{caption}")
    public ResponseEntity<List<Post>> getPostsByCaption(@PathVariable String caption){
    	List<Post> posts = service.searchByCaption(caption);
    	return posts != null
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);	
    }

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        Post addedPost = service.addPost(post);
        return new ResponseEntity<>(addedPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) {
        post.setId(id);
        Post updatedPost = service.updatePost(post);

        return updatedPost != null
                ? new ResponseEntity<>(updatedPost, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        boolean deleted = service.deletePost(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
