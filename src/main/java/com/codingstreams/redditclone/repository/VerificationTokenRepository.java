package com.codingstreams.redditclone.repository;

import com.codingstreams.redditclone.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
