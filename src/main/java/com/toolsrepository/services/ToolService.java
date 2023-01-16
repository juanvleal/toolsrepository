package com.toolsrepository.services;

import com.toolsrepository.dto.ToolDto;
import com.toolsrepository.form.ToolForm;
import com.toolsrepository.models.Tool;
import com.toolsrepository.repositories.ToolRepository;
import com.toolsrepository.services.exceptions.EmptyResultDataAccessException;
import com.toolsrepository.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Transactional
    public ToolDto insert(ToolForm form){
        Tool entity = new Tool();
        entity.setTitle(form.getTitle());
        entity.setDescription(form.getDescription());
        entity.setLink(form.getLink());
        entity.setTags(form.getTags());
        entity = toolRepository.save(entity);
        return new ToolDto(entity);
    }

    public ToolDto findById(Long id){
        Optional<Tool> obj = toolRepository.findById(id);
        Tool entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada!"));
        return new ToolDto(entity);
    }

    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    @Transactional
    public ToolDto update(Long id, ToolForm form){
        Tool entity = toolRepository.getReferenceById(id);
        entity.setTitle(form.getTitle());
        entity.setDescription(form.getDescription());
        entity.setLink(form.getLink());
        entity.setTags(form.getTags());
        entity = toolRepository.save(entity);
        return new ToolDto(entity);
    }

    public void delete(Long id){
        try {
            findById(id);
            toolRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado para deletar!");
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Resultado da pesquisa vazio!");
        }
    }
}
