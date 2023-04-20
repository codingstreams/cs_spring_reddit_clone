package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.RedditUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedditUserRepository extends JpaRepository<RedditUser, String> {
    boolean existsByUsername(String username);
}
