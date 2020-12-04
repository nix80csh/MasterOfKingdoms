package com.mok.entity;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class UnixTimestampDeserializer extends JsonDeserializer<Date> {

    public Date deserialize(JsonParser parser, DeserializationContext context) 
            throws IOException, JsonProcessingException {
        String unixTimestamp = parser.getText().trim();
        return new Date(TimeUnit.SECONDS.toMillis(Long.valueOf(unixTimestamp)));
    }
}
