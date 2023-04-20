package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
