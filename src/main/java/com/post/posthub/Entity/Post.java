package com.post.posthub.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
}
