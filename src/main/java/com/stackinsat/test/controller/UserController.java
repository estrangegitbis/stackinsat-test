package com.stackinsat.test.controller;

import com.stackinsat.test.dto.AccountDTO;
import com.stackinsat.test.dto.UserDataDTO;
import com.stackinsat.test.dto.UserResponseDTO;
import com.stackinsat.test.model.AppUser;
import com.stackinsat.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signin")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {
        return userService.signin(username,
                                  password);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDataDTO user) {
        return userService.signup(modelMapper.map(user,
                                                  AppUser.class));
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO search(@PathVariable String username) {
        return modelMapper.map(userService.search(username),
                               UserResponseDTO.class);
    }

    @GetMapping(value = "/{username}/accounts")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AccountDTO> findUserAccounts(@PathVariable String username) {
        return modelMapper.map(userService.search(username).getAccounts(),
                               new TypeToken<List<AccountDTO>>() {
                               }.getType());
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public UserResponseDTO whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req),
                               UserResponseDTO.class);
    }

    @GetMapping(value = "/accounts")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<AccountDTO> findMyAccounts(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req).getAccounts(),
                               new TypeToken<List<AccountDTO>>() {
                               }.getType());
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }
}
