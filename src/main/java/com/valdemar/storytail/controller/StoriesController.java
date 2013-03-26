package com.valdemar.storytail.controller;

import com.valdemar.storytail.model.*;
import com.valdemar.storytail.service.TaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 19-03-2013
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/stories/tales")
public class StoriesController {


    @Autowired
    TaleService taleService;

    @GET
    @Path("/near")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalesNearPoint(@QueryParam("lat") Double lat,
                             @QueryParam("lon") Double lon) {
        if(lat == null || lon == null) {
            return Response.serverError().entity(new ServerResponse<List<Tale>>("lat or lon parameters cannot be empty")).build();
        }

        try {
            List<Tale> tales = taleService.findNearTales(new Location(lat, lon));
            return Response.ok(new ServerResponse<List<Tale>>(tales)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<List<Tale>>(e.getMessage())).build();
        }
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTale(@QueryParam("taleId") String taleId) {

        return null;
    }




}
