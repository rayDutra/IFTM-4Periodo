package org.example.models.dtos;
import lombok.*;
import org.example.models.Tag;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TagDTO implements Serializable {
    private String name;

    public TagDTO(Tag tag){
        this.name = tag.getName();
    }
    public Tag toTag(){
        var tag = new Tag();
        tag.setName(this.name);
        return tag;
    }
}