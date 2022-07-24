package com.example.springboot.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public final class ApplicationErrorController implements ErrorController {

    @RequestMapping
 public ErrorResponseDTO error(final HttpServletRequest request) {
     return new ErrorResponseDTO(ErrorResponseDTO.SERVER_ERROR);
 }

}
