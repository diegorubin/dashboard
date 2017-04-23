package com.diegorubin.datacenter.config.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * LocalDateTimeDeserializer
 *
 * @author diegorubin
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(final JsonParser jsonParser,
                                     final DeserializationContext deserializationCtx) throws IOException {
        final ObjectCodec codec = jsonParser.getCodec();
        final String content = codec.readValue(jsonParser, String.class);

        if (content == null) {
            return null;
        }

        return LocalDateTime.parse(content);
    }
}
