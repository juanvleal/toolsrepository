package com.toolsrepository;

import com.toolsrepository.models.Tool;
import com.toolsrepository.repositories.ToolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ToolsTests {

    @Autowired
    ToolRepository toolRepository;

    @Test
    void createToolTest(){
        Tool tool = new Tool();
        tool.setTitle("JpaRepository");
        tool.setDescription("JpaRepository is particularly a JPA specific extension for Repository.");
        tool.setLink("https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html");
        toolRepository.save(tool);
    }

    @Test
    void listAllToolsTest(){
        List<Tool> tools = toolRepository.findAll();
        assertThat(tools).isNotNull();
    }
    @Test
    void listToolByIdTest(){
        Tool tool = toolRepository.findById(13L).get();
        assertEquals("JpaRepository Documentation", tool.getTitle());
    }

    @Test
    void updateToolTest(){
        Tool tool = toolRepository.findById(13L).get();
        tool.setTitle("JpaRepository Documentation");
        toolRepository.save(tool);
        assertNotEquals("JpaRepository", tool.getTitle());
    }

    @Test
    void deleteToolTest(){
        toolRepository.deleteById(10L);
        assertThat(toolRepository.existsById(10L));
    }
}
