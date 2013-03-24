package com.valdemar.storytail.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.valdemar.storytail.exceptions.RestClientFailedException;
import com.valdemar.storytail.exceptions.RestClientFatalException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class RestClient {


    public static <T> T getJson(URI url, Class<T> type) throws RestClientFatalException {

        try {
            String output = getJson(url);

            ObjectMapper mapper = new ObjectMapper();
            T object = mapper.readValue(output, type);

            return object;
        } catch (Exception e) {
            throw new RestClientFatalException(e.getMessage());
        }
    }

    public static String getJson(URI url) throws RestClientFatalException {

        ClientResponse response = null;

        try {

            Client client = Client.create();

            WebResource webResource = client.resource(url);

            response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RestClientFailedException("Failed : HTTP error code : " + response.getStatus(), HttpStatus.valueOf(response.getStatus()));
            }

            return response.getEntity(String.class);

        } catch (Exception e) {
            throw new RestClientFatalException(e.getMessage());
        }
    }
}
