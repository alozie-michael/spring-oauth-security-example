package com.springsecurity.example.securityexample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.util.OAuth2Utils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class AuthFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    private static final String AUTHORIZED_CLIENT_ID = "client";
    private static final List<GrantedAuthority> CLIENT_AUTHORITIES = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_CLIENT, ROLE_TRUSTED_CLIENT");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String clientId = servletRequest.getParameter(OAuth2Utils.CLIENT_ID);

        if (AUTHORIZED_CLIENT_ID.equals(clientId)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    AUTHORIZED_CLIENT_ID, "", CLIENT_AUTHORITIES);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("Just authenticated : {}", clientId);
        } else {
            LOGGER.info("Did NOT authenticate : {}", clientId);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //
    }
}
