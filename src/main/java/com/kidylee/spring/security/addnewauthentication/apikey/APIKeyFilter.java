package com.kidylee.spring.security.addnewauthentication.apikey;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("apiKeyFilter")
public class APIKeyFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("application-api-key");
        if (authorization != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
            emptyContext.setAuthentication(new APIKeyAuthenticationToken(authorization));
            SecurityContextHolder.setContext(emptyContext);
        }
        filterChain.doFilter(request, response);
    }
}
