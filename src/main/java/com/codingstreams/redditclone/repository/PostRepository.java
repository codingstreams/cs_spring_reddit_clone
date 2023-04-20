package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
