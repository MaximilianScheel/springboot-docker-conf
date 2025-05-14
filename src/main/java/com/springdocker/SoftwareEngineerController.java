package com.springdocker;

import com.springdocker.SoftwareEngineerDto;
import com.springdocker.SoftwareEngineerMapper;
import com.springdocker.ResourceNotFoundException;
import com.springdocker.SoftwareEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineerDto> getAll() {
        return softwareEngineerService.getAll()
                .stream()
                .map(SoftwareEngineerMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftwareEngineerDto> getById(@PathVariable Integer id) {
        return softwareEngineerService.getById(id)
                .map(SoftwareEngineerMapper::toDto)
                .map(dto -> ResponseEntity.ok(dto))
                .orElseThrow(() -> new ResourceNotFoundException("ID " + id + " nicht gefunden"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoftwareEngineerDto create(@Valid @RequestBody SoftwareEngineerDto dto) {
        var created = softwareEngineerService.create(dto);
        return SoftwareEngineerMapper.toDto(created);
    }

    @PutMapping("/{id}")
    public SoftwareEngineerDto update(
            @PathVariable Integer id,
            @Valid @RequestBody SoftwareEngineerDto dto) {
        var updated = softwareEngineerService.update(id, dto);
        return SoftwareEngineerMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        softwareEngineerService.delete(id);
    }
}
