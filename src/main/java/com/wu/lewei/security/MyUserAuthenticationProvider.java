/*
 *
 */
package com.wu.lewei.security;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import com.wu.lewei.constants.AuthoritiesConstants;

/**
 * The Class UsstUserAuthenticationProvider fetches user data from USST using a rest client and .
 *
 * @author cn40580
 */
@Component
public class MyUserAuthenticationProvider implements AuthenticationProvider {

    private static final Log LOG = LogFactory.getLog(MyUserAuthenticationProvider.class);

    /**
     * Uses authentication provided by IV-USER header to fetch user and role information from USST
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        //TODO use userId to login.
        Collection<GrantedAuthority> auths = new HashSet<>();
        auths.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMINISTRATE_ROLES));
        auths.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMINISTRATE_USERS));
        MyUserToken userToken = new MyUserToken(auths);
        userToken.setAuthenticated(true);//login
        return userToken;
    }

    /**
     * We support only {@link PreAuthenticatedAuthenticationToken} here to catch the userId out of the iv-user header.
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(PreAuthenticatedAuthenticationToken.class);
    }

}
