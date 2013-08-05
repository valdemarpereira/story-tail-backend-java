package com.valdemar.storytail.auth;

import com.valdemar.storytail.service.ApiTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    @Autowired
    ApiTokenService apiTokenService;

    AuthenticationManager authManager;

    public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {


        String token = ((HttpServletRequest) request).getHeader("auth_token");

        if (token != null && TokenUtils.validateToken(token)) {
            String userId = apiTokenService.getUserIdFromToken(token);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userId, token);

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
            // set the authentication into the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));
        }

        // continue thru the filter chain
        chain.doFilter(request, response);
    }
}