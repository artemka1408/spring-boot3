package com.example.springboot.filter;

import com.example.springboot.manager.UserManager;
import com.example.springboot.security.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//   @Component
@RequiredArgsConstructor
@Slf4j
public class AuthFilter extends HttpFilter {
    private final UserManager userManager;

    // log - logger
    @Override
    protected void doFilter(final HttpServletRequest req, final HttpServletResponse res, final FilterChain chain) throws IOException, ServletException, ServletException {
        // before servlet
        // ctrl + alt + t -> surround with
        // TODO:
        //  servlets -> 1. Old School -> req.getHeader("Login") -> null
        //  2. Modern -> req.getHeader("Login") -> Optional
        //  3. Strict -> req.getHeader("Login") -> Exception/RuntimeException
        final String login = req.getHeader("X-Login");
        final String password = req.getHeader("X-Password");
        // TODO: credential
        //  -> log.trace
        //  -> log.debug
        log.debug("login: {}, password: {}", login, password);
        // TODO:
        //  1. DB (map)
        //  2. Hash & Compare
        //  3. User

        // TODO:
        //  -> 1. Exception/Error Status Code
        //  2. Anonymous

        // ifn + Tab
        if (login == null) {
            res.setStatus(401);
            res.getWriter().write("Not authenticated");
            return; // чтобы не попало в chain.doFilter
        }

        if (password == null) {
            res.setStatus(401);
            res.getWriter().write("Not authenticated");
            return; // чтобы не попало в chain.doFilter
        }

        try {
            final Authentication authentication = userManager.authenticateByLoginAndPassword(
                    login,
                    password
            );
            req.setAttribute("authentication", authentication);
        } catch (RuntimeException e) {
            res.setStatus(401);
            res.getWriter().write("Not authenticated");
            return; // чтобы не попало в chain.doFilter
        }

        chain.doFilter(req, res);
    }
}
