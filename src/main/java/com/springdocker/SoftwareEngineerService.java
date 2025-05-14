package com.springdocker;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository repo;

    public SoftwareEngineerService(SoftwareEngineerRepository repo) {
        this.repo = repo;
    }

    public List<SoftwareEngineer> getAll() {
        return repo.findAll();
    }

    public Optional<SoftwareEngineer> getById(int id) {
        return repo.findById(id);
    }

    public SoftwareEngineer create(SoftwareEngineerDto dto) {
        var se = SoftwareEngineerMapper.toEntity(dto);
        return repo.save(se);
    }

    public SoftwareEngineer update(int id, SoftwareEngineerDto dto) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setTechStack(dto.getTechStack());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new ResourceNotFoundException("ID " + id + " nicht gefunden"));
    }

    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("ID " + id + " nicht gefunden");
        }
        repo.deleteById(id);
    }
}
