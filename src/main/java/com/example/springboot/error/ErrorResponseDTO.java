package com.example.springboot.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponseDTO {
    public static final String SERVER_ERROR = "server_error";
    public static final String ARGUMENT_NOT_VALID = "argument_not_valid";
    public static final String ACCESS_DENIED = "access_denied";
    public static final String NOT_FOUND = "not_found";
    public static final String ALREADY_EXIST = "already_exist";


    private String message;
}
