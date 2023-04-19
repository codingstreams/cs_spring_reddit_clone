package com.codingstreams.redditclone.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String token;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private RedditUser redditUser;
}
