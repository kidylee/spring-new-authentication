package com.kidylee.spring.security.addnewauthentication.apikey;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class APIKeyAuthenticationProvider implements AuthenticationProvider {

    UserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apiKey = (String) authentication.getCredentials();
        UserDetails userdetails = null;
//        userdetails = userDetailsService.loadUserByAPIKey(authentication.getPrincipal().toString());
        APIKeyAuthenticationToken newAuth = new APIKeyAuthenticationToken(userdetails, userdetails.getAuthorities());
        newAuth.setAuthenticated(true);
        return newAuth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return APIKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
