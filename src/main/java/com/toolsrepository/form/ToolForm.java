package com.toolsrepository.form;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class ToolForm {
    private String title;
    private String description;
    private String link;
    private List<String> tags;

    public ToolForm(String title, String description, String link, List<String> tags) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }
}
