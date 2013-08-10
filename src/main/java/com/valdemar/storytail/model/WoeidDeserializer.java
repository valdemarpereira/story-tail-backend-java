package com.valdemar.storytail.model;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;


public class WoeidDeserializer extends JsonDeserializer<Woeid> {


    @Override
    public Woeid deserialize(JsonParser jParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        Woeid woeid = new Woeid();


        // loop until token equal to "}"
        while (jParser.nextToken() != JsonToken.END_OBJECT) {

            String fieldname = jParser.getCurrentName();

            if ("ResultSet".equals(fieldname)) {

                // messages is array, loop until token equal to "]"
                while (jParser.nextToken() != JsonToken.END_OBJECT) {

                    fieldname = jParser.getCurrentName();

                    if ("Error".equals(fieldname)) {
                        jParser.nextToken();
                        if (!jParser.getText().equals("0"))
                            // TODO: Log: Error calling yahoo service
                            return null;
                    }
                    if ("Results".equals(fieldname)) {

                        jParser.nextToken(); // current token is "[", move next
                        jParser.nextToken(); // current token is "[", move next

                        while (jParser.nextToken() != JsonToken.END_OBJECT) {

                            fieldname = jParser.getCurrentName();

                            if ("woeid".equals(fieldname)) {
                                jParser.nextToken();
                                woeid.setWoeid(jParser.getText());
                            } else if ("country".equals(fieldname)) {
                                jParser.nextToken();
                                woeid.setCountry(jParser.getText());
                            } else if ("city".equals(fieldname)) {
                                jParser.nextToken();
                                woeid.setCity(jParser.getText());
                            } else if ("state".equals(fieldname)) {
                                jParser.nextToken();
                                woeid.setState(jParser.getText());
                            } else if ("county".equals(fieldname)) {
                                jParser.nextToken();
                                woeid.setCounty(jParser.getText());
                            } else
                                jParser.nextToken();
                        }

                        return woeid;
                    }
                }
            }
        }

        return null;

    }
}
