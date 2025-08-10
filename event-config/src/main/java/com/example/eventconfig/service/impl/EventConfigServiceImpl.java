package com.example.eventconfig.service.impl;

import com.example.eventconfig.dto.EventConfigDTO;
import com.example.eventconfig.entity.EventConfig;
import com.example.eventconfig.exception.ResourceNotFoundException;
import com.example.eventconfig.repository.EventConfigRepository;
import com.example.eventconfig.service.EventConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventConfigServiceImpl implements EventConfigService {

    private final EventConfigRepository repository;

    @Override
    public EventConfigDTO create(EventConfigDTO dto) {
        EventConfig entity = new EventConfig();
        BeanUtils.copyProperties(dto, entity);
        return convertToDto(repository.save(entity));
    }

    @Override
    public EventConfigDTO getById(Long id) {
        EventConfig entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventConfig not found with id: " + id));
        return convertToDto(entity);
    }

    @Override
    public List<EventConfigDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventConfigDTO update(Long id, EventConfigDTO dto) {
        EventConfig entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventConfig not found with id: " + id));
        BeanUtils.copyProperties(dto, entity);
        entity.setId(id);
        return convertToDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        EventConfig entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventConfig not found with id: " + id));
        repository.delete(entity);
    }

    private EventConfigDTO convertToDto(EventConfig entity) {
        EventConfigDTO dto = new EventConfigDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
