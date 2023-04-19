package com.codingstreams.redditclone.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class SubReddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message="SubReddit name is required")
    private String name;
    @NotBlank(message = "Description id required")
    private String description;
    @OneToMany(mappedBy = "subReddit", fetch = FetchType.LAZY)
    private List<Post> posts;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private RedditUser redditUser;
}
