package com.wu.lewei.config;

import org.hibernate.InstantiationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import com.wu.lewei.security.MyUserAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Created a new USST user authentication provider in spring context.
     *
     * @return the usst user authentication provider
     */
    @Bean
    public MyUserAuthenticationProvider authenticationProvider() {
        return new MyUserAuthenticationProvider();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter#configure(org.springframework.security. config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(final HttpSecurity http) {
        try {
            http.csrf().disable().addFilter(createIVUserHeaderFilter()).authorizeRequests().antMatchers("/**")
                    .authenticated().and().logout().permitAll();
            http.headers().frameOptions().sameOrigin();
            http.headers().contentTypeOptions().disable();
        } catch (Exception e) {
            LOG.error("Error during security setup", e);
        }

    }

    /**
     * Creates an iv-user header filter to get user id from TAM/Webseal.
     *
     * @return the request header authentication filter
     * @throws Exception
     *             the exception if something goes wrong
     */
    private RequestHeaderAuthenticationFilter createIVUserHeaderFilter() {
        RequestHeaderAuthenticationFilter requestFilter = new RequestHeaderAuthenticationFilter();
        requestFilter.setPrincipalRequestHeader("iv-user");
        requestFilter.setExceptionIfHeaderMissing(false);
        requestFilter.setCheckForPrincipalChanges(true);
        try {
            requestFilter.setAuthenticationManager(this.authenticationManagerBean());
        } catch (Exception e) {
            LOG.error("Error during security setup", e);
            throw new InstantiationException("Error creating authentication manager", WebSecurityConfig.class, e);
        }
        return requestFilter;
    }
}
