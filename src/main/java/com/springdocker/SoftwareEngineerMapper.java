package com.springdocker;

public class SoftwareEngineerMapper {
    public static SoftwareEngineerDto toDto(SoftwareEngineer se) {
        SoftwareEngineerDto dto = new SoftwareEngineerDto();
        dto.setId(se.getId());
        dto.setName(se.getName());
        dto.setTechStack(se.getTechStack());
        return dto;
    }

    public static SoftwareEngineer toEntity(SoftwareEngineerDto dto) {
        var se = new SoftwareEngineer();
        se.setName(dto.getName());
        se.setTechStack(dto.getTechStack());
        return se;
    }
}

