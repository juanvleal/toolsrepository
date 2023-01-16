package com.toolsrepository.controllers;

import com.toolsrepository.dto.ToolDto;
import com.toolsrepository.form.ToolForm;
import com.toolsrepository.models.Tool;
import com.toolsrepository.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tools")
public class ToolController {

    @Autowired
    private ToolService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ToolDto> findById(@PathVariable Long id){
        ToolDto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Tool>> findAll() {

        List<Tool> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<ToolDto> insert(@RequestBody ToolForm form) {

        ToolDto toolDto = service.insert(form);

        return ResponseEntity.ok().body(toolDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ToolDto> update(@RequestBody ToolForm form, @PathVariable Long id) {


        ToolDto toolDto = service.update(id, form);

        return ResponseEntity.ok().body(toolDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
