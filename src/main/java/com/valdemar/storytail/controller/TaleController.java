package com.valdemar.storytail.controller;

import com.valdemar.storytail.model.*;
import com.valdemar.storytail.service.TaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.*;
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
public class TaleController {


    @Autowired
    TaleService taleService;

    @GET
    @Path("/near")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalesNearPoint(@QueryParam("lat") Double lat,
                                      @QueryParam("lon") Double lon) {
        if(lat == null || lon == null) {
            return Response.serverError().entity(new ServerResponse<NearTales>("lat or lon parameters cannot be empty")).build();
        }

        try {
            NearTales tales = taleService.findNearTales(new Location(lat, lon));
            return Response.ok(new ServerResponse<NearTales>(tales)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<NearTales>(e.getMessage())).build();
        }
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTale(@QueryParam("taleId") String taleId) {

        if ("".equals(taleId)){
            return Response.serverError().entity(new ServerResponse<Tale>("lat or lon parameters cannot be empty")).build();
        }

        try {
            Tale tale = taleService.findTale(taleId);
            return Response.ok(new ServerResponse<Tale>(tale)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<Tale>(e.getMessage())).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTale(NewTale tale) {

        if(tale == null){
            return Response.serverError().entity(new ServerResponse<Tale>("tale cannot be empty")).build();
        }

        try {
            taleService.createNewTale(tale);
            return Response.status(201).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<Tale>(e.getMessage())).build();
        }
    }




}
