package com.toolsrepository.dto;

import com.toolsrepository.models.Tool;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class ToolDto {
    private Long id;
    private String title;
    private String description;
    private String link;
    private List<String> tags;

    public ToolDto(Tool entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.link = entity.getLink();
        this.tags = entity.getTags();
    }
}
