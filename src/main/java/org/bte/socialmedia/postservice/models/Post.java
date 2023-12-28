package org.bte.socialmedia.postservice.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

	@Id
	private String id;
	
	private Instant createdAt;

	private Instant updatedAt;

	private String username;

	private String lastModifiedBy;

	private String imageUrl;

	private String caption;

	public Post() {

	}

	public Post(String id, Instant createdAt, Instant updatedAt, String username, String lastModifiedBy,
			String imageUrl, String caption) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.username = username;
		this.lastModifiedBy = lastModifiedBy;
		this.imageUrl = imageUrl;
		this.caption = caption;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", username=" + username
				+ ", lastModifiedBy=" + lastModifiedBy + ", imageUrl=" + imageUrl + ", caption=" + caption + "]";
	}

}