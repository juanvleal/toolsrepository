package com.toolsrepository.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
public class Tool {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String link;

    @ElementCollection
    private List<String> tags;

    public Tool() {

    }

    public Tool(Long id, String title, String description, String link, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }


}
