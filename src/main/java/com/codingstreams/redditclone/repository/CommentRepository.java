package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
