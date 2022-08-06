package com.example.springboot.repository;

import com.example.springboot.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, String> {

}
