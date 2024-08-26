package com.example.capstone3ee.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class ResumeDTO {

    @NotNull(message = "User Id must be not null ")
    private Integer userId;
    @NotEmpty(message = "Content must be not empty")
    private String content;
    @NotEmpty(message = "skills must be not empty")
    private List<String> skills;
    private List<String> projects;
    private List<String> certification;
    @NotEmpty(message = "award must be not empty")
    private List<String> award;
    @NotEmpty(message = "Eduction must be not empty")
    private String eduction;




}
