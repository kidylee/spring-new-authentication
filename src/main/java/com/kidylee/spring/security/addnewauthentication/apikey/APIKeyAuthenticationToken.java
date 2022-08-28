package com.kidylee.spring.security.addnewauthentication.apikey;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class APIKeyAuthenticationToken extends AbstractAuthenticationToken {
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public APIKeyAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    UserDetails principal;
    String credentials;
    public APIKeyAuthenticationToken(String apikey) {
        super(Collections.EMPTY_LIST);
        this.credentials = apikey;
    }

    public APIKeyAuthenticationToken(UserDetails userdetails, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = userdetails;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
