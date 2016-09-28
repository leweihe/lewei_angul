/*
 *
 */
package com.wu.lewei.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * A user object to hold all required stuff about for authentication and authorization. This also contains the user's
 * authorities, what enables this class to be used as an authentication token in spring security context
 *
 * @author cn40580
 *
 */
public class MyUserToken extends AbstractAuthenticationToken implements Authentication {
    
    private static final long serialVersionUID = 7324100183539530864L;
    
    public MyUserToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }


    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return "";
    }

}
