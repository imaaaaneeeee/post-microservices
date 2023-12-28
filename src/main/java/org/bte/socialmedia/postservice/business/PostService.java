package org.bte.socialmedia.postservice.business;

import java.util.List;

import org.bte.socialmedia.postservice.models.Post;

public interface PostService {
	
	public Post getPostById(String id);

	public List<Post> getAllPosts();

	public Post addPost(Post post);

	public Post updatePost(Post post);

	public boolean deletePost(String id);
	
	public List<Post> searchByCaption(String caption);

}
