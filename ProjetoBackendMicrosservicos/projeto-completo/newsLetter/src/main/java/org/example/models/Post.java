package org.example.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Post {
    private String title;
    private String authorName;
    private String body;
    private List<Tag> tags;
}