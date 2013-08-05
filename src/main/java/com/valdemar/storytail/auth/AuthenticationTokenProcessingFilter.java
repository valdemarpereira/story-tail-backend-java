package com.valdemar.storytail.auth;

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

//    @Autowired
//    UserService userService;

//    @Autowired TokenUtils tokenUtils;

    AuthenticationManager authManager;

    public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        @SuppressWarnings("unchecked")

        Map<String, String[]> parms = request.getParameterMap();

        if(parms.containsKey("token")) {
            String token = parms.get("token")[0]; // grab the first "token" parameter

            if("12345".equals(token)) {

                //just a simple example
                //TODO implement token validation againt DB


                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken("mkyong", "123456");

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));

                // SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));

            }

        }

       /*

        if(parms.containsKey("token")) {
            String token = parms.get("token")[0]; // grab the first "token" parameter



            // validate the token
            if (tokenUtils.validate(token)) {
                // determine the user based on the (already validated) token
                UserDetails userDetails = tokenUtils.getUserFromToken(token);
                // build an Authentication object with the user's info
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                // set the authentication into the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(authentication));
            }

           /

            //passar o token do facebook??
            //terei que implementar o meu custom autenticador :)

        }

        */
        // continue thru the filter chain
        chain.doFilter(request, response);
    }
}