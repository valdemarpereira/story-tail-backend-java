package com.valdemar.storytail.controller;

import com.valdemar.storytail.model.Location;
import com.valdemar.storytail.model.ServerResponse;
import com.valdemar.storytail.model.WindParameters;
import com.valdemar.storytail.model.Woeid;
import com.valdemar.storytail.weather.WeatherProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
 * Date: 19-03-2013
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Path("/weather")
public class WindService {

    @Autowired
    WeatherProxy weatherProxy;

    @GET
    @Path("/wind")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWind(@QueryParam("lat") Double lat,
                            @QueryParam("lon") Double lon) {

        if(lat == null || lon == null) {
            return Response.serverError().entity(new ServerResponse<Woeid>("lat or lon parameters cannot be empty")).build();
        }
        try {
            WindParameters wind = weatherProxy.getWind(new Location(lat, lon));
            return Response.ok(new ServerResponse<WindParameters>(wind)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<Woeid>(e.getMessage())).build();
        }
    }


    /*
    @GET
    @Path("/woeid")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovie(@QueryParam("lat") Double lat,
                             @QueryParam("lon") Double lon) {

        if(lat == null || lon == null) {
            return Response.serverError().entity(new ServerResponse<Woeid>("lat or lon parameters cannot be empty")).build();
        }

        try {
            Woeid woeid = yahooWOEIDService.getWOEID(new Location(lat,lon));
            return Response.ok(new ServerResponse<Woeid>(woeid)).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ServerResponse<Woeid>(e.getMessage())).build();
        }
    }
    */
}
