package com.springdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(
                1,
                "John Doe",
                "Java, Spring Boot"
                ),
                new SoftwareEngineer(
                        2,
                        "Thomas Anders",
                        "JS, Node, React, Tailwind"
                )
        );
    }
}
