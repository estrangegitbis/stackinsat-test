package com.stackinsat.test.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private String username;
    private String email;
    private LocalDate birthDate;
}
