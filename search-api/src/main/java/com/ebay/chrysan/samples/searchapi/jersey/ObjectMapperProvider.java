
package com.ebay.chrysan.samples.searchapi.jersey;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

        //set up ISO 8601 date/time stamp format:
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.objectMapper.setDateFormat(df);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return this.objectMapper;
    }
}
