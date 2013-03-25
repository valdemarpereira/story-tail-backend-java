package com.valdemar.storytail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;


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


    @GET
    @Path("/near")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTalesNearPoint(@QueryParam("lat") Double lat,
                             @QueryParam("lon") Double lon) {

        return null;
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTale(@QueryParam("taleId") String taleId) {

        return null;
    }



}
