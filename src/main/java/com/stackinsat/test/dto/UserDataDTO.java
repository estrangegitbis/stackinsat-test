package com.stackinsat.test.dto;

import com.stackinsat.test.model.AppUserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDataDTO {
    List<AppUserRole> appUserRoles;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
}
