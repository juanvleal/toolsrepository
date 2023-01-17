package com.toolsrepository.services;

import com.toolsrepository.dto.ToolDto;
import com.toolsrepository.form.ToolForm;
import com.toolsrepository.models.Tool;
import com.toolsrepository.repositories.ToolRepository;
import com.toolsrepository.services.exceptions.EmptyResultDataAccessException;
import com.toolsrepository.services.exceptions.ResourceNotFoundException;
import com.toolsrepository.services.exceptions.TitleDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Transactional
    public ToolDto insert(ToolForm form){

        if(toolRepository.existsToolByTitle(form.getTitle())){
            throw new TitleDuplicatedException("Já existe uma ferramente com esse título!");
        }

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
        if(toolRepository.existsToolByTitle(form.getTitle())){
            throw new TitleDuplicatedException("Já existe uma ferramente com esse título!");
        }
        if(form.getTitle() != null) entity.setTitle(form.getTitle());
        if(form.getDescription() != null) entity.setDescription(form.getDescription());
        if(form.getLink() != null) entity.setLink(form.getLink());
        if(form.getTags() != null) entity.setTags(form.getTags());
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
