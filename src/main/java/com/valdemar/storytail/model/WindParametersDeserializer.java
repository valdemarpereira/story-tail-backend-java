package com.valdemar.storytail.model;

import com.google.common.base.Optional;
import com.valdemar.storytail.exceptions.YahooWOEIDServiceException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 10/08/13
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class WindParametersDeserializer extends JsonDeserializer<WindParameters> {


    @Override
    public WindParameters deserialize(JsonParser jParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {


            // loop until token equal to "}"
            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldname = jParser.getCurrentName();

                if ("wind".equals(fieldname)) {

                    String windSpeed = "0.0";
                    String windDirection = "0";

                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        fieldname = jParser.getCurrentName();

                        if ("direction".equals(fieldname)) {
                            // jParser.nextToken();
                            windDirection = jParser.getText();
                        } else if ("speed".equals(fieldname)) {
                            // jParser.nextToken();
                            windSpeed = jParser.getText();
                        } else
                            jParser.nextToken();
                    }
                    return new WindParameters(Float.parseFloat(windSpeed), Integer.parseInt(windDirection));
                }
            }

        return null;

    }
}
