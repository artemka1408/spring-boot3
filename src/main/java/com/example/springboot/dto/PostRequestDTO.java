package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRequestDTO {
    @Min(0)
    private long id;
    @NotNull
    private String content;
    @Size(min = 1, max = 100)
    private List< @NotNull @Pattern(regexp = "^#[A-Za-zА-Яа-яЁё0-9]{1,100}$")String> tags;
    @NotNull
    private @Valid GeoDTO geo;
}
