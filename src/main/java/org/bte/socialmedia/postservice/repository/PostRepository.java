package org.bte.socialmedia.postservice.repository;

import java.util.List;

import org.bte.socialmedia.postservice.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>{
	
    public List<Post> findByCaptionContaining(String caption);


}
