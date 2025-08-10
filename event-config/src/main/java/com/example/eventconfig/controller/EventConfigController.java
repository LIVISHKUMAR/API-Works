package com.example.eventconfig.controller;

import com.example.eventconfig.dto.EventConfigDTO;
import com.example.eventconfig.service.EventConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-configs")
@RequiredArgsConstructor
public class EventConfigController {

    private final EventConfigService service;

    @PostMapping
    public ResponseEntity<EventConfigDTO> create(@RequestBody EventConfigDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventConfigDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EventConfigDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventConfigDTO> update(@PathVariable Long id, @RequestBody EventConfigDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
