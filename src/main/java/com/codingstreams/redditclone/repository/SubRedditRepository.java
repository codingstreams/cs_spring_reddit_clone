package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRedditRepository extends JpaRepository<SubReddit, Long> {
}
