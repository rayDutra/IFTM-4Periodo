package org.example.models.dtos;

import lombok.*;
import org.bson.types.ObjectId;
import org.example.models.News;
import org.example.models.Post;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
public class NewsDTO implements Serializable {
    private final String id;
    private final String title;
    private final String date;
    private final String editorName;
    private final List<PostDTO> posts;

    public NewsDTO(News news) {
        if(news != null) {
            this.id = (news.getId() != null) ? news.getId().toString() : null;
            this.title = news.getTitle();
            this.date = news.getDate();
            this.editorName = news.getEditorName();

            if (news.getPosts() != null) {
                this.posts = news.getPosts().stream().map(PostDTO::new).collect(Collectors.toList());
            } else {
                this.posts = null;
            }
        } else {
            this.id = null;
            this.title = null;
            this.date = null;
            this.editorName = null;
            this.posts = null;
        }
    }

    public News convertToNews() {
        ObjectId convertedId = (this.id != null) ? new ObjectId(this.id) : null;
        List<Post> convertedPosts = (this.posts != null) ? this.posts.stream().map(PostDTO::toPost).collect(Collectors.toList()) : null;
        return new News(convertedId, this.title, this.date, this.editorName, convertedPosts);
    }
}
