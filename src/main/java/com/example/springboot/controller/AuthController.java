package com.example.springboot.controller;

import com.example.springboot.dto.AuthRequestDTO;
import com.example.springboot.dto.AuthResponseDTO;
import com.example.springboot.manager.AuthManager;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthManager manager;

    @PostMapping
    public AuthResponseDTO auth(@Valid @RequestBody AuthRequestDTO requestDTO) {
        return manager.auth(requestDTO);
    }
}
