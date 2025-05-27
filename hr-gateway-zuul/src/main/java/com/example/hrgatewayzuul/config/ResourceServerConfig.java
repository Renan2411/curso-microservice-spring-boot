package com.example.hrgatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.List;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
    private static final String[] OPERATORS_ROUTES = {"/hr-worker/**"};
    private static final String[] ADMIN_ROUTES = {"/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**"};
    private static final String OPERATOR_ROLE = "OPERATOR";
    private static final String ADMIN_ROLE = "ADMIN";

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATORS_ROUTES).hasAnyRole(OPERATOR_ROLE, ADMIN_ROLE)
                .antMatchers(ADMIN_ROUTES).hasRole(ADMIN_ROLE)
                .anyRequest().authenticated();
    }
}
