package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens")
@Getter
@Setter
public class TokenEntity {
    @Id
    private String token;
    @ManyToOne
    private UserEntity user;
    @Column(insertable = false, columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Instant created;
}
