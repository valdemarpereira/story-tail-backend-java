package com.valdemar.storytail.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import com.valdemar.storytail.exceptions.RestClientFailedException;
import com.valdemar.storytail.exceptions.RestClientFatalException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 22-03-2013
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class RestClient {

 /*  Client instances are expensive resources. It is recommended a
     configured instance is reused for the creation of Web resources. The
     creation of Web resources, the building of requests and receiving of
     responses are guaranteed to be thread safe. Thus a Client instance
     and WebResource instances may be shared between multiple threads*/

    private static Client client = Client.create();
    private static Client client_ssl = createClientSSL();


    public static Client  createClientSSL() {

        try {

        ClientConfig config = new DefaultClientConfig();
        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(null, myTrustManager, null);
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(hostnameVerifier, ctx));
        Client client = Client.create(config);

            return client;
        }
      catch (Exception ex) {}

    }

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
