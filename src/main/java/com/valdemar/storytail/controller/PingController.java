package com.valdemar.storytail.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 19-03-2013
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */

@Controller
@Path("/ping")
public class PingController {

    @GET
    @Path("/")
    public Response pong() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username


        return Response.ok("pong " + name).build();

    }

}
