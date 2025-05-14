package com.springdocker;

import jakarta.validation.constraints.NotBlank;

public class SoftwareEngineerDto {

    private Integer id;

    @NotBlank(message = "Name darf nicht leer sein")
    private String name;

    @NotBlank(message = "Tech-Stack darf nicht leer sein")
    private String techStack;

    public SoftwareEngineerDto() {
    }

    public SoftwareEngineerDto(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }
}
