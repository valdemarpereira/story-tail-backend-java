package com.valdemar.storytail.controller;

import com.valdemar.storytail.model.AuthApiKey;
import com.valdemar.storytail.model.ServerResponse;
import com.valdemar.storytail.model.UserInfo;
import com.valdemar.storytail.service.AuthLoginType;
import com.valdemar.storytail.service.AuthenticatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 5/24/13
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Path("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticatorService authService;

    @GET
    @Path("/fb_login")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalesNearPoint(@QueryParam("token") String token) {
        if(token == null || "".equals(token)) {
            return Response.serverError().entity(new ServerResponse<UserInfo>("token cannot be empty")).build();
        }

        try {
            UserInfo userInfo = authService.authenticate(token, AuthLoginType.FACEBOOK);
            return Response.ok(new ServerResponse<UserInfo>(userInfo)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<UserInfo>(e.getMessage())).build();
        }
    }
}
