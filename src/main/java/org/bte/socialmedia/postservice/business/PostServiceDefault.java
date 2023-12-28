package org.bte.socialmedia.postservice.business;

import java.util.List;
import java.util.Optional;

import org.bte.socialmedia.postservice.models.Post;
import org.bte.socialmedia.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceDefault implements PostService {
	@Autowired
	private PostRepository postRepository;

	public PostServiceDefault() {
	}

	public Post getPostById(String id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		return optionalPost.orElse(null);
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public Post addPost(Post post) {
		return postRepository.save(post);
	}

	public Post updatePost(Post post) {
		if (postRepository.existsById(post.getId())) {
			return postRepository.save(post);
		}
		return null;
	}

	public boolean deletePost(String id) {
		if (postRepository.existsById(id)) {
			postRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Post> searchByCaption(String caption) {
		return postRepository.findByCaptionContaining(caption);
		
	}

}
