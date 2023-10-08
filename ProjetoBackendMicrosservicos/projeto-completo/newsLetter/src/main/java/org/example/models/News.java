package org.example.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document(collection = "newletters")
public class News {
    @Id
    private ObjectId id;
    private String title;
    private String date;
    private String editorName;
    private List<Post> posts;
}