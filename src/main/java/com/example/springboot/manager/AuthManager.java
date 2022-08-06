package com.example.springboot.manager;

import com.example.springboot.dto.AuthRequestDTO;
import com.example.springboot.dto.AuthResponseDTO;
import com.example.springboot.entity.TokenEntity;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.exception.UserLoginNotFoundException;
import com.example.springboot.exception.UserPasswordNotMatchesException;
import com.example.springboot.repository.TokenRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.security.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class AuthManager {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;

    public AuthResponseDTO auth(final AuthRequestDTO requestDTO) {
        final UserEntity userEntity = userRepository.findByLogin(requestDTO.getLogin())
                .orElseThrow(UserLoginNotFoundException::new);
        if (!passwordEncoder.matches(requestDTO.getPassword(), userEntity.getPassword())) {
            throw  new UserPasswordNotMatchesException();
        }

        final String token = tokenGenerator.generate();


        final TokenEntity tokenEntity = TokenEntity.builder()
                .token(token)
                .user(userEntity)
                .build();
        tokenRepository.save(tokenEntity);


        return new AuthResponseDTO(token);
    }
}
