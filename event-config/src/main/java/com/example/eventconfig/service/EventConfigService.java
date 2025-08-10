package com.example.eventconfig.service;

import com.example.eventconfig.dto.EventConfigDTO;

import java.util.List;

public interface EventConfigService {
    EventConfigDTO create(EventConfigDTO dto);
    EventConfigDTO getById(Long id);
    List<EventConfigDTO> getAll();
    EventConfigDTO update(Long id, EventConfigDTO dto);
    void delete(Long id);
}
