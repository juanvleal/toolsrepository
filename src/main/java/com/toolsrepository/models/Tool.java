package com.toolsrepository.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Tool {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Size(max = 256, message = "O tamanho máximo da descrição é 256 caracteres!")
    @Lob
    private String description;
    private String link;

    @ElementCollection
    @Size(max = 8, message = "O tamanho máximo da descrição é 256 caracteres!")
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
