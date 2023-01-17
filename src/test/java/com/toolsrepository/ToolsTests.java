package com.toolsrepository;

import com.toolsrepository.models.Tool;
import com.toolsrepository.repositories.ToolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ToolsTests {

    @Autowired
    ToolRepository toolRepository;

    Tool createTool(){
        Tool tool = new Tool();
        tool.setTitle("New Tool to Test");
        tool.setDescription("JpaRepository is particularly a JPA specific extension for Repository.");
        tool.setLink("https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html");
        return toolRepository.save(tool);
    }

    @Test
    void createToolTest(){
        Tool tool = new Tool();
        tool.setTitle("Testando nova tool");
        tool.setDescription("JpaRepository is particularly a JPA specific extension for Repository.");
        tool.setLink("https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html");
        toolRepository.save(tool);
        toolRepository.deleteById(tool.getId());
    }

    @Test
    void listAllToolsTest(){
        List<Tool> tools = toolRepository.findAll();
        assertThat(tools).isNotNull();
    }
    @Test
    void listToolByIdTest() {
        Tool tool =  createTool();
        toolRepository.findById(tool.getId()).get();
        assertEquals("https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html", tool.getLink());
        toolRepository.deleteById(tool.getId());
    }

    @Test
    void updateToolTest(){
        Tool tool =  createTool();
        Tool toolUp = toolRepository.findById(tool.getId()).get();
        toolUp.setTitle("Nova Tool testada.");
        toolRepository.save(tool);
        assertNotEquals("Testando nova tool", tool.getTitle());
        toolRepository.deleteById(tool.getId());
    }

    @Test
    void deleteToolTest(){
        Tool tool =  createTool();
        Long toolId = tool.getId();
        toolRepository.deleteById(toolId);
        assertFalse(toolRepository.existsById(toolId));
    }
}
